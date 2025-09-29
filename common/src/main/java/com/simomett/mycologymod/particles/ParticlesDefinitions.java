package com.simomett.mycologymod.particles;

import com.simomett.mycologymod.platform.Services;

public class ParticlesDefinitions
{
    public static final IRegisteredParticleType SPORE_PARTICLES = Services.PLATFORM.registerSimpleParticleType("spore");
    public static final IRegisteredParticleType MUTANT_SPORE_PARTICLES = Services.PLATFORM.registerSimpleParticleType("mutant_spore");

    public static void init(){}
}
