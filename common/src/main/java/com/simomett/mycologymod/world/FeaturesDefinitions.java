package com.simomett.mycologymod.world;

import com.simomett.mycologymod.platform.Services;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class FeaturesDefinitions
{
    public static final IRegisteredFeature<OreFeature> ORE_CHROMIUM_SMALL = Services.PLATFORM.registerFeature("ore_chromium_small", () -> new OreFeature(OreConfiguration.CODEC));

    public static void init(){}
}
