package com.simomett.mycologymod.world.features;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Constants.MOD_ID);
}
