package com.simomett.mycologymod.particles;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeParticles
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Constants.MOD_ID);
}
