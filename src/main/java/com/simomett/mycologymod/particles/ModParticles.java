package com.simomett.mycologymod.particles;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticles
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MycologyMod.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPORE_PARTICLES = PARTICLES.register("spore", () -> new SimpleParticleType(true));
}
