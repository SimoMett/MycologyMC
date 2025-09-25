package com.simomett.mycologymod.world;

import com.simomett.mycologymod.platform.Services;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import com.simomett.mycologymod.world.features.OverworldFungusFeature;
import com.simomett.mycologymod.world.features.UndergroundFungusFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class FeaturesDefinitions
{
    public static final IRegisteredFeature<OreFeature> ORE_CHROMIUM_SMALL = Services.PLATFORM.registerFeatureConfig("ore_chromium_small", () -> new OreFeature(OreConfiguration.CODEC), IPlatformHelper.Dimension.OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES);
    public static final IRegisteredFeature<OverworldFungusFeature> SURFACE_FUNGUS = Services.PLATFORM.registerFeatureConfig("surface_fungus", OverworldFungusFeature::new, IPlatformHelper.Dimension.OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION);
    public static final IRegisteredFeature<UndergroundFungusFeature> UNDERGROUND_FUNGUS = Services.PLATFORM.registerFeatureConfig("underground_fungus", UndergroundFungusFeature::new, IPlatformHelper.Dimension.OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION);

    public static void init(){}
}
