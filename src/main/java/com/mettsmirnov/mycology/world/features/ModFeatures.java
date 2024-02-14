package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MycologyMod.MODID);

    public static final RegistryObject<RandomFungusFeatureConfiguration> CONFIGURED_FUNGUS = FEATURES.register("simple_fungus", RandomFungusFeatureConfiguration::new);
}
