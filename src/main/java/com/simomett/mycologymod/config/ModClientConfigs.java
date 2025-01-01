package com.simomett.mycologymod.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModClientConfigs
{
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Integer> SPORE_PARTICLES_FREQ;

    static
    {
        SPORE_PARTICLES_FREQ = BUILDER.define("Spore particles spawn frequency", 1);
        SPEC = BUILDER.build();
    }
}
