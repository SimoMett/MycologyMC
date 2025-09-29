package com.simomett.mycologymod.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class FabricParticleType implements IRegisteredParticleType
{
    private final SimpleParticleType particleType = FabricParticleTypes.simple();

    @Override
    public SimpleParticleType particleType() {
        return particleType;
    }

    @Override
    public Supplier<SimpleParticleType> particleTypeSupplier() {
        return FabricParticleTypes::simple;
    }
}
