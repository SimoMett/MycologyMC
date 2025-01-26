package com.simomett.mycologymod.genetics;

import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.genetics.gene.Gene;
import com.simomett.mycologymod.network.serializable.IModSerializable;
import com.simomett.mycologymod.recipes.breeding.MutationRecipe;
import com.simomett.mycologymod.recipes.breeding.MutationRecipesList;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.io.*;
import java.util.*;

import static com.simomett.mycologymod.config.ModCommonConfigs.MUTAGEN_EFFECTIVENESS;
import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA_CODEC;
import static com.simomett.mycologymod.genetics.FungusTraits.traitsDictionary;
import static com.simomett.mycologymod.utils.Utils.parseStringOrTag;

public class FungusGenoma implements IModSerializable
{
    public static final String
            SPECIES = "species",
            SPREADING = "spreading",
            SPREAD_BOOST = "spreadboost",
            LIGHT = "light",
            TERRAIN = "terrain",
            HUMIDITY = "humidity",
            TEMP= "temp",
            AREA = "area",
            EFFECT = "effect",
            EATING_EFFECT = "eat_effect";

    private final FungusTraits dominantTraits;
    private final FungusTraits recessiveTraits;

    public FungusGenoma(FungusTraits dominant, FungusTraits recessive)
    {
        dominantTraits = new FungusTraits(dominant);
        recessiveTraits = new FungusTraits(recessive);
    }

    public FungusGenoma(FungusSpeciesList.FungusSpecies species)
    {
        this(species.defaultTraits, species.defaultTraits);
    }

    public FungusGenoma(CompoundTag genomaTag)
    {
        FungusGenoma g = FUNGUS_GENOMA_CODEC.parse(NbtOps.INSTANCE, genomaTag).getOrThrow();
        dominantTraits = g.dominantTraits;
        recessiveTraits = g.recessiveTraits;
    }

    private FungusGenoma()
    {
        dominantTraits = new FungusTraits(FungusTraits.UNINIT);
        recessiveTraits = new FungusTraits(dominantTraits);
    }

    public FungusGenoma(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] dst = new byte[byteBuf.readInt()];
            byteBuf.readBytes(dst);
            ByteArrayInputStream i = new ByteArrayInputStream(dst);
            ObjectInputStream inputStream = new ObjectInputStream(i);
            FungusGenoma genoma = (FungusGenoma) inputStream.readObject();
            this.dominantTraits = genoma.getDominantTraits();
            this.recessiveTraits = genoma.getRecessiveTraits(); //I've got the genoma correctly though...
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void encode(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] serialized = serialize();
            byteBuf.writeInt(serialized.length);
            byteBuf.writeBytes(serialized);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public FungusTraits getDominantTraits()
    {
        return dominantTraits;
    }

    public FungusTraits getRecessiveTraits()
    {
        return recessiveTraits;
    }

    public boolean matchesEnvironment(LevelReader level, BlockPos origin)
    {
        //LightLayer.SKY is the light level of a block due to other blocks obstructing skylight. 0 is in complete darkness, 15 is in plain air.
        //LightLayer.BLOCK is the light level of a block due to other sources of light (Glowstone, torches..).
        boolean matchesLight = level.getBrightness(LightLayer.SKY, origin) <= dominantTraits.light() &&
                level.getBrightness(LightLayer.BLOCK, origin) < dominantTraits.light(); // mushrooms prefer sporing in darker areas

        // getBaseTemperature() or getModifiedClimateSettings().temperature() ?
        // they seems to be the same...
        float temperature = level.getBiome(origin).value().getModifiedClimateSettings().temperature();
        float humidity = level.getBiome(origin).value().getModifiedClimateSettings().downfall();
        boolean matchesAmbient = dominantTraits.temp().equals(temperature) && dominantTraits.humidity().equals(humidity);

        return matchesLight && matchesAmbient;
    }

    public boolean matchesTerrain(BlockState terrainBlock)
    {
        return matchesTerrain(dominantTraits.terrain(), terrainBlock);
    }

    public static boolean matchesTerrain(String terrain, BlockState terrainBlock)
    {
        ResourceLocation a = parseStringOrTag(terrain);
        TagKey<Block> t = BlockTags.create(a);
        return (BuiltInRegistries.BLOCK.get(a).isPresent() && terrainBlock.is(BuiltInRegistries.BLOCK.get(a).get()))
                || terrainBlock.is(t)
                || terrainBlock.is(ModBlockTags.CAN_PLANT_ON);
    }

    public final boolean matchesEnvironmentAndTerrain(LevelReader level, BlockPos blockPos, BlockState terrainBlock)
    {
        return (matchesEnvironment(level, blockPos) && matchesTerrain(terrainBlock)) || terrainBlock.is(Blocks.MYCELIUM);
    }

    public FungusGenoma normalCrossBreedWith(FungusGenoma that)
    {
        //FIXME better implementation to consider optional fields (eg. eating effect)
        FungusGenoma offspring = new FungusGenoma();
        Random random = new Random();
        for(String trait : traitsDictionary)
        {
            Gene<?> o = random.nextBoolean() ? this.getDominantTraits().get(trait) : this.getRecessiveTraits().get(trait);
            offspring.getDominantTraits().replace(trait, o);
            Gene<?> p = random.nextBoolean() ? that.getDominantTraits().get(trait) : that.getRecessiveTraits().get(trait);
            offspring.getRecessiveTraits().replace(trait, p);
        }
        return offspring;
    }

    public FungusGenoma crossBreedWith(FungusGenoma species2, boolean mutagen)
    {
        FungusGenoma offspring;
        Random random = new Random();
        List<MutationRecipe> mutations = MutationRecipesList.getList();

        //get all the mutations between species1 and species2
        mutations = mutations.stream()
                .filter(m -> (m.getSpecies1().equals(this.getDominantTraits().species()) && m.getSpecies2().equals(species2.getDominantTraits().species()))
                        || (m.getSpecies1().equals(species2.getDominantTraits().species()) && m.getSpecies2().equals(this.getDominantTraits().species())))
                .toList();

        if (!mutations.isEmpty())
        {
            int randomRecipeId = random.nextInt(mutations.size());
            MutationRecipe randomMutation = mutations.get(randomRecipeId);

            boolean shouldPerformMutation;
            if(mutagen)
            {
                //Triangular distribution
                float a = random.nextFloat(0f, 1f);
                float b = random.nextFloat(0f, 1f);
                shouldPerformMutation = (a + b) < (randomMutation.getChance() + MUTAGEN_EFFECTIVENESS.get());
            }
            else
                shouldPerformMutation = random.nextFloat(0f, 1f) < randomMutation.getChance();

            if (shouldPerformMutation)
                return new FungusGenoma(FungusSpeciesList.INSTANCE.get(randomMutation.getResultSpecies()));
        }

        offspring = this.normalCrossBreedWith(species2);
        return offspring;
    }

    public void changeRandomTraitByMutagen()
    {
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
        FungusTraits traits = random.nextBoolean()? dominantTraits : recessiveTraits;
        String randomTrait = traitsPool[random.nextInt(traitsPool.length)];
        traits.get(randomTrait).randomMutate();
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof FungusGenoma that)) return false;
        return Objects.equals(dominantTraits, that.dominantTraits) && Objects.equals(recessiveTraits, that.recessiveTraits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dominantTraits, recessiveTraits);
    }
}