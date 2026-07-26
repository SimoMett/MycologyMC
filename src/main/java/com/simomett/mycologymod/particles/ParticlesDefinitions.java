package com.simomett.mycologymod.particles;


import com.simomett.mycologymod.recipes.FabricParticleType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class ParticlesDefinitions
{
    private static IRegisteredParticleType registerSimpleParticleType(String name)
    {
        IRegisteredParticleType tt = new FabricParticleType();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, name), tt.particleType());
        return tt;
    }

    public static final IRegisteredParticleType SPORE_PARTICLES = registerSimpleParticleType("spore");
    public static final IRegisteredParticleType MUTANT_SPORE_PARTICLES = registerSimpleParticleType("mutant_spore");

    public static void init(){}
}
