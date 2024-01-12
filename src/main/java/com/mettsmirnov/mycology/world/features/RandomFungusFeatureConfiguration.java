package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

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
        BlockPos origin = placeContext.origin();
        Random coin = new Random();
        boolean shouldSpawnCrimson = (coin.nextInt() % 2) == 1;
        if(shouldSpawnCrimson)
            placeContext.level().setBlock(origin, ModBlocks.COLORED_CRIMSON_FUNGUS.get().defaultBlockState(), 0); //WTF is the third parameter??
        else
            placeContext.level().setBlock(origin, ModBlocks.COLORED_WARPED_FUNGUS.get().defaultBlockState(), 0);
        return true;
    }
}
