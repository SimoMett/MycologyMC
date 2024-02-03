package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import org.jline.utils.Log;

import java.util.ArrayList;
import java.util.Random;

public class RandomFungusFeatureConfiguration extends Feature<SimpleBlockConfiguration>
{
    //FIXME command "/place feature" doesn't work
    public RandomFungusFeatureConfiguration()
    {
        super(SimpleBlockConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> placeContext)
    {
        ArrayList<FungusSpeciesList.FungusSpecies> speciesList = FungusSpeciesList.INSTANCE.getSpeciesList();
        if(!speciesList.isEmpty())
        {
            BlockPos origin = placeContext.origin();
            String biomeName = placeContext.level().registryAccess().registryOrThrow(Registries.BIOME).getKey(placeContext.level().getBiome(origin).get()).toString();
            float biomeTemp = placeContext.level().getBiome(origin).get().getModifiedClimateSettings().temperature();
            float biomeDownfall = placeContext.level().getBiome(origin).get().getModifiedClimateSettings().downfall();

            //get random species
            Random random = new Random();
            FungusSpeciesList.FungusSpecies randomSpecies = speciesList
                    .get(random.nextInt(FungusSpeciesList.INSTANCE.getSpeciesList().size()));

            //spawn fungus with the correct type
            if (randomSpecies.fungusType.equals("colored_crimson_fungus")) //FIXME I don't like this plain string, it's better to use a const
                placeContext.level().setBlock(origin, ModBlocks.COLORED_CRIMSON_FUNGUS.get().defaultBlockState(), 0); //WTF is the third parameter??
            else
                placeContext.level().setBlock(origin, ModBlocks.COLORED_WARPED_FUNGUS.get().defaultBlockState(), 0);

            //edit its block entity
            BlockEntity blockEntity = placeContext.level().getBlockEntity(origin);
            if (blockEntity instanceof ColoredFungusBlockEntity coloredFungusBlockEntity)
            {
                //FIXME these two line below are no good. I want to call one method only
                coloredFungusBlockEntity.getFungusData().setColors(randomSpecies.colors);
                coloredFungusBlockEntity.getFungusData().loadFrom(randomSpecies.defaultTraits, randomSpecies.defaultTraits);
            } else {
                Log.error("WHY THIS BLOCKENTITY ISN'T A COLORED FUNGUS?");
                return false;
            }
            return true;
        }
        else
            return false;
    }
}
