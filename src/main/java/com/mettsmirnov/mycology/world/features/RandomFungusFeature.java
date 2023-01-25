package com.mettsmirnov.mycology.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import org.jline.utils.Log;

public class RandomFungusFeature extends Feature<SimpleBlockConfiguration>
{

    public RandomFungusFeature(Codec<SimpleBlockConfiguration> configurationCodec)
    {
        super(configurationCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context)
    {
        Log.debug("PLACING");
        return false;
    }
}
