package com.mettsmirnov.mycology.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class RandomFungusFeature extends Feature<SimpleBlockConfiguration>
{

    public RandomFungusFeature()
    {
        super(SimpleBlockConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> p_159749_)
    {
        return false;
    }
}
