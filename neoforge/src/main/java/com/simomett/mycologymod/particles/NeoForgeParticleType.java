package com.simomett.mycologymod.particles;

import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class NeoForgeParticleType implements IRegisteredParticleType
{
    private final Supplier<SimpleParticleType> supplier;
    public NeoForgeParticleType(Supplier<SimpleParticleType> supplier)
    {
        this.supplier = supplier;
    }

    @Override
    public SimpleParticleType particleType()
    {
        return supplier.get();
    }

    @Override
    public Supplier<SimpleParticleType> particleTypeSupplier()
    {
        return supplier;
    }
}
