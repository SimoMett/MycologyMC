package com.mettsmirnov.mycology.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfigs
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_MUSHROOMS_IN_AREA;
    public static final ForgeConfigSpec.ConfigValue<Integer> BREEDING_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Float> DEFAULT_MUTATION_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Integer> RADIUS_MULTIPLIER;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPORE_PARTICLES_FREQ;
    public static final ForgeConfigSpec.ConfigValue<Boolean> IGNORE_AMBIENT_CONDITIONS;

    static
    {
        MAX_MUSHROOMS_IN_AREA = BUILDER.define("Max spread count of mushrooms", 5);
        BREEDING_CHANCE = BUILDER.define("Cross-breeding chance", 2);
        DEFAULT_MUTATION_CHANCE = BUILDER.define("Default mutation chance", .6f);
        RADIUS_MULTIPLIER = BUILDER.define("Radius multiplier", 2);
        SPORE_PARTICLES_FREQ = BUILDER.define("Spore particles spawn frequency", 1);
        IGNORE_AMBIENT_CONDITIONS = BUILDER.define("Ignore ambient conditions for sporing", true);//FIXME false in final release (or totally removed)
        SPEC = BUILDER.build();
    }
}
