package com.simomett.mycologymod.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class NeoForgeClientConfigs implements IModClientConfigs
{
    public static final NeoForgeClientConfigs INSTANCE = new NeoForgeClientConfigs();

    public final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public final ModConfigSpec SPEC;

    public final ModConfigSpec.ConfigValue<Integer> SPORE_PARTICLES_FREQ;

    private NeoForgeClientConfigs()
    {
        SPORE_PARTICLES_FREQ = BUILDER.define("Spore particles spawn frequency", 1);
        SPEC = BUILDER.build();
    }

    @Override
    public int getSporeParticlesFreq()
    {
        return SPORE_PARTICLES_FREQ.get();
    }
}
