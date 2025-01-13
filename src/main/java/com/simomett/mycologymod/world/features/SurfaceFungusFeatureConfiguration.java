package com.simomett.mycologymod.world.features;

import com.simomett.mycologymod.blocks.ModBlocks;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.datagen.common.FungusSpawn;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

import java.util.List;
import java.util.Random;

import static com.simomett.mycologymod.utils.Utils.parseStringOrTag;

public class SurfaceFungusFeatureConfiguration extends Feature<SimpleBlockConfiguration>
{
    //command "/place feature" doesn't work (I don't care)
    public SurfaceFungusFeatureConfiguration()
    {
        super(SimpleBlockConfiguration.CODEC);
    }

    private static boolean matchesBiome(String biomeTag, Holder<Biome> biome)
    {
        ResourceLocation a = parseStringOrTag(biomeTag);
        TagKey<Biome> t = TagKey.create(Registries.BIOME, a);
        return biome.is(t) || biome.is(a) || biomeTag.equals(FungusSpawn.ANY_BIOME.getBiomes());
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> placeContext)
    {
        List<FungusSpeciesList.FungusSpecies> speciesList = FungusSpeciesList.INSTANCE.getSpeciesList();
        BlockPos origin = placeContext.origin();
        final Holder<Biome> biome = placeContext.level().getBiome(origin);
        speciesList = speciesList.stream().filter(s -> s.spawnInfo != null && matchesBiome(s.spawnInfo.getBiomes(), biome)).toList();
        if(!speciesList.isEmpty())
        {
            //get random species
            Random random = new Random();
            FungusSpeciesList.FungusSpecies randomSpecies = speciesList.get(random.nextInt(speciesList.size()));

            if (random.nextFloat(0f, 1f) <= randomSpecies.spawnInfo.chance)
            {
                //spawn fungus with the correct type
                BlockState blockState = ModBlocks.getDefaultBlockStateFromFungusType(randomSpecies.fungusType);
                placeContext.level().setBlock(origin, blockState, 0); //Block.UPDATE_CLIENTS?

                //edit its block entity
                ColoredFungusBlockEntity blockEntity = (ColoredFungusBlockEntity) placeContext.level().getBlockEntity(origin);
                blockEntity.applyGenoma(new FungusGenoma(randomSpecies));
            }
            return true;
        }
        else
            return false;
    }
}
