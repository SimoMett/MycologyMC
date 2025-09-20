package com.simomett.mycologymod.world;

import com.simomett.mycologymod.platform.Services;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import com.simomett.mycologymod.world.features.OverworldFungusFeatureConfiguration;
import com.simomett.mycologymod.world.features.UndergroundFungusFeatureConfiguration;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class FeaturesDefinitions
{
    public static final IRegisteredFeature<OreFeature> ORE_CHROMIUM_SMALL = Services.PLATFORM.registerFeature("ore_chromium_small", () -> new OreFeature(OreConfiguration.CODEC), IPlatformHelper.Dimension.OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES);
    public static final IRegisteredFeature<OverworldFungusFeatureConfiguration> SURFACE_FUNGUS = Services.PLATFORM.registerFeature("simple_fungus", OverworldFungusFeatureConfiguration::new, IPlatformHelper.Dimension.OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION);
    public static final IRegisteredFeature<UndergroundFungusFeatureConfiguration> UNDERGROUND_FUNGUS = Services.PLATFORM.registerFeature("underground_fungus", UndergroundFungusFeatureConfiguration::new, IPlatformHelper.Dimension.OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION);

    public static void init(){}
}
