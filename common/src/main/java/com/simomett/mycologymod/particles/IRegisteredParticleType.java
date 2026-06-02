package com.simomett.mycologymod.particles;

import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public interface IRegisteredParticleType
{
    SimpleParticleType particleType();
    Supplier<SimpleParticleType> particleTypeSupplier();
}
