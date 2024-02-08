package com.mettsmirnov.mycology.particles;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MycologyMod.MODID);

    public static final RegistryObject<SimpleParticleType> SPORE_PARTICLES = PARTICLES.register("spore", () -> new SimpleParticleType(true));
}
