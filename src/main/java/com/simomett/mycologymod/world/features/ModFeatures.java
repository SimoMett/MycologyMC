package com.simomett.mycologymod.world.features;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, MycologyMod.MODID);

    public static final DeferredHolder<Feature<?>, SurfaceFungusFeatureConfiguration> SURFACE_FUNGUS = FEATURES.register("simple_fungus", SurfaceFungusFeatureConfiguration::new);
    public static final DeferredHolder<Feature<?>, UndergroundFungusFeatureConfiguration> UNDERGROUND_FUNGUS = FEATURES.register("underground_fungus", UndergroundFungusFeatureConfiguration::new);
}
