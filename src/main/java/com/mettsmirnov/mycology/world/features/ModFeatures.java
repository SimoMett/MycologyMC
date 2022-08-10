package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> MOD_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MycologyMod.MODID);
}
