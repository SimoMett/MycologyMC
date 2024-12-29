package com.simomett.mycologymod.config;


import net.neoforged.neoforge.common.ModConfigSpec;

public class ModCommonConfigs
{
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Integer> MAX_MUSHROOMS_IN_AREA;
    public static final ModConfigSpec.ConfigValue<Integer> BREEDING_CHANCE;
    public static final float DEFAULT_MUTATION_CHANCE = .6f;
    public static final ModConfigSpec.ConfigValue<Float> DEFAULT_MUTATION_CHANCE_CONFIG;
    public static final ModConfigSpec.ConfigValue<Integer> RADIUS_MULTIPLIER;
    public static final ModConfigSpec.ConfigValue<Integer> SPORE_PARTICLES_FREQ;
    public static final ModConfigSpec.ConfigValue<Boolean> IGNORE_AMBIENT_CONDITIONS;
    public static final ModConfigSpec.ConfigValue<Integer> EFFECT_BLAZING_HIT_ENTITY_CHANCE;
    public static final ModConfigSpec.ConfigValue<Integer> EFFECT_LIGHTNING_HIT_CREEPER_CHANCE;

    static
    {
        MAX_MUSHROOMS_IN_AREA = BUILDER.define("Max spread count of mushrooms", 5);
        BREEDING_CHANCE = BUILDER.define("Cross-breeding chance", 2);
        DEFAULT_MUTATION_CHANCE_CONFIG = BUILDER.define("Default mutation chance", DEFAULT_MUTATION_CHANCE);
        RADIUS_MULTIPLIER = BUILDER.define("Radius multiplier", 2);
        SPORE_PARTICLES_FREQ = BUILDER.define("Spore particles spawn frequency", 1);
        IGNORE_AMBIENT_CONDITIONS = BUILDER.define("Ignore ambient conditions for sporing", true);//FIXME false in final release (or totally removed)
        EFFECT_BLAZING_HIT_ENTITY_CHANCE = BUILDER.define("Chance of Blazing effect to hit an entity", 3);
        EFFECT_LIGHTNING_HIT_CREEPER_CHANCE = BUILDER.define("Chance of Lightning effect to hit a creeper", 3);
        SPEC = BUILDER.build();
    }
}
