package com.simomett.mycologymod.genetics;

import com.simomett.mycologymod.config.FabricCommonConfigs;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.data.ISerializable;
import com.simomett.mycologymod.genetics.gene.Gene;
import com.simomett.mycologymod.recipes.breeding.MutationRecipe;
import com.simomett.mycologymod.recipes.breeding.MutationRecipesList;
import com.simomett.mycologymod.tags.ModBlockTags;
import com.simomett.mycologymod.world.IBiomeDownfallGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.io.*;
import java.util.*;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.*;
import static com.simomett.mycologymod.genetics.FungusTraits.traitsDictionary;
import static com.simomett.mycologymod.utils.Utils.parseStringOrTag;

public record FungusGenoma(FungusTraits dominantTraits, FungusTraits recessiveTraits) implements ISerializable {
    public static final String
            SPECIES = "species";
    public static final String SPREADING = "spreading";
    public static final String SPREAD_BOOST = "spreadboost";
    public static final String LIGHT = "light";
    public static final String TERRAIN = "terrain";
    public static final String HUMIDITY = "humidity";
    public static final String TEMP = "temp";
    public static final String AREA = "area";
    public static final String EFFECT = "effect";
    public static final String EATING_EFFECT = "eat_effect";

    public FungusGenoma(FungusGenoma fungusGenoma) {
        this(fungusGenoma.dominantTraits, fungusGenoma.recessiveTraits);
    }

    public FungusGenoma(FungusTraits dominantTraits, FungusTraits recessiveTraits) {
        this.dominantTraits = new FungusTraits(dominantTraits);
        this.recessiveTraits = new FungusTraits(recessiveTraits);
    }

    public FungusGenoma(FungusSpeciesList.FungusSpecies species) {
        this(species.defaultTraits, species.defaultTraits);
    }

    public FungusGenoma(CompoundTag genomaTag) {
        FungusGenoma g = FUNGUS_GENOMA_CODEC.parse(NbtOps.INSTANCE, genomaTag).getOrThrow();
        this(g.dominantTraits, g.recessiveTraits);
    }

    private FungusGenoma()
    {
        this(new FungusTraits(FungusTraits.UNINIT), new FungusTraits(FungusTraits.UNINIT));
    }

    public FungusGenoma(FriendlyByteBuf byteBuf)
    {
        this(FUNGUS_GENOMA_STREAM_CODEC.decode(byteBuf));
    }

    public void encode(FriendlyByteBuf byteBuf) {
        try {
            byte[] serialized = serialize();
            byteBuf.writeInt(serialized.length);
            byteBuf.writeBytes(serialized);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean matchesEnvironment(LevelReader level, BlockPos origin) {
        //LightLayer.SKY is the light level of a block due to other blocks obstructing skylight. 0 is in complete darkness, 15 is in plain air.
        //LightLayer.BLOCK is the light level of a block due to other sources of light (Glowstone, torches..).
        boolean matchesLight = level.getBrightness(LightLayer.SKY, origin) <= dominantTraits.light() &&
                level.getBrightness(LightLayer.BLOCK, origin) < dominantTraits.light(); // mushrooms prefer sporing in darker areas

        float temperature = level.getBiome(origin).value().getBaseTemperature();
        //float humidity = level.getBiome(origin).components();
        float humidity = ((IBiomeDownfallGetter) ((Object) (level.getBiome(origin).value()))).getDownfall();
        boolean matchesAmbient = dominantTraits.temp().equals(temperature) && dominantTraits.humidity().equals(humidity);

        return matchesLight && matchesAmbient;
    }

    public boolean matchesTerrain(BlockState terrainBlock) {
        return matchesTerrain(dominantTraits.terrain(), terrainBlock);
    }

    public static boolean matchesTerrain(String terrain, BlockState terrainBlock) {
        Identifier a = parseStringOrTag(terrain);
        TagKey<Block> t = TagKey.create(Registries.BLOCK, a);
        return (BuiltInRegistries.BLOCK.get(a).isPresent() && terrainBlock.is(BuiltInRegistries.BLOCK.get(a).get()))
                || terrainBlock.is(t)
                || terrainBlock.is(ModBlockTags.CAN_PLANT_ON);
    }

    public final boolean matchesEnvironmentAndTerrain(LevelReader level, BlockPos blockPos, BlockState terrainBlock) {
        return (matchesEnvironment(level, blockPos) && matchesTerrain(terrainBlock)) || terrainBlock.is(Blocks.MYCELIUM);
    }

    public FungusGenoma normalCrossBreedWith(FungusGenoma that) {
        //FIXME better implementation to consider optional fields (eg. eating effect)
        FungusGenoma offspring = new FungusGenoma();
        Random random = new Random();
        for (String trait : traitsDictionary) {
            Gene<?> o = random.nextBoolean() ? this.dominantTraits().get(trait) : this.recessiveTraits().get(trait);
            offspring.dominantTraits().replace(trait, o);
            Gene<?> p = random.nextBoolean() ? that.dominantTraits().get(trait) : that.recessiveTraits().get(trait);
            offspring.recessiveTraits().replace(trait, p);
        }
        return offspring;
    }

    public FungusGenoma crossBreedWith(FungusGenoma species2, boolean mutagen) {
        FungusGenoma offspring;
        Random random = new Random();
        List<MutationRecipe> mutations = MutationRecipesList.getList();

        //get all the mutations between species1 and species2
        mutations = mutations.stream()
                .filter(m -> (m.species1().equals(this.dominantTraits().species()) && m.species2().equals(species2.dominantTraits().species()))
                        || (m.species1().equals(species2.dominantTraits().species()) && m.species2().equals(this.dominantTraits().species())))
                .toList();

        if (!mutations.isEmpty()) {
            int randomRecipeId = random.nextInt(mutations.size());
            MutationRecipe randomMutation = mutations.get(randomRecipeId);

            boolean shouldPerformMutation;
            if (mutagen) {
                //Triangular distribution
                float a = random.nextFloat(0f, 1f);
                float b = random.nextFloat(0f, 1f);
                shouldPerformMutation = (a + b) < (randomMutation.chance() + FabricCommonConfigs.instance().getMutagenEffectiveness());
            } else
                shouldPerformMutation = random.nextFloat(0f, 1f) < randomMutation.chance();

            if (shouldPerformMutation)
                return new FungusGenoma(FungusSpeciesList.getInstance().get(randomMutation.resultSpecies()));
        }

        offspring = this.normalCrossBreedWith(species2);
        return offspring;
    }

    public void changeRandomTraitByMutagen() {
        String[] traitsPool = new String[]{
                SPREADING,
                SPREAD_BOOST,
                LIGHT,
                HUMIDITY,
                TEMP,
                AREA,
                EFFECT
        };

        Random random = new Random();
        FungusTraits traits = random.nextBoolean() ? dominantTraits : recessiveTraits;
        String randomTrait = traitsPool[random.nextInt(traitsPool.length)];
        traits.get(randomTrait).randomMutate();
    }

    public void storeIntoItemStack(ItemStack itemStack) {
        itemStack.applyComponents(DataComponentMap.builder().set(FUNGUS_GENOMA.dataComponentType(), this).build());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FungusGenoma that)) return false;
        return Objects.equals(dominantTraits, that.dominantTraits) && Objects.equals(recessiveTraits, that.recessiveTraits);
    }
}