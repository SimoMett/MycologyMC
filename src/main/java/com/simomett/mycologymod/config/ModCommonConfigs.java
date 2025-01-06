package com.simomett.mycologymod.config;


import net.neoforged.neoforge.common.ModConfigSpec;

import static com.simomett.mycologymod.datagen.common.SpeciesBuilder.DEFAULT_SPREADBOOST;

public class ModCommonConfigs
{
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Integer> MAX_MUSHROOMS_IN_AREA;
    public static final ModConfigSpec.ConfigValue<Integer> BREEDING_CHANCE;
    public static final float DEFAULT_MUTATION_CHANCE = .6f;
    public static final ModConfigSpec.ConfigValue<Float> DEFAULT_MUTATION_CHANCE_CONFIG;
    public static final ModConfigSpec.DoubleValue MUTAGEN_EFFECTIVENESS;
    public static final ModConfigSpec.IntValue MIN_SPREADING_SPEED;
    public static final ModConfigSpec.ConfigValue<Float> MAX_SPREAD_BOOST;
    public static final ModConfigSpec.ConfigValue<Integer> RADIUS_MULTIPLIER;
    public static final ModConfigSpec.ConfigValue<Boolean> IGNORE_AMBIENT_CONDITIONS;
    public static final ModConfigSpec.ConfigValue<Integer> EFFECT_BLAZING_HIT_ENTITY_CHANCE;
    public static final ModConfigSpec.ConfigValue<Integer> EFFECT_LIGHTNING_HIT_CREEPER_CHANCE;

    static
    {
        MAX_MUSHROOMS_IN_AREA = BUILDER.define("Max spread count of mushrooms", 4); // I don't want mushrooms spamming all over the biomes
        BREEDING_CHANCE = BUILDER.define("Cross-breeding chance", 2);
        DEFAULT_MUTATION_CHANCE_CONFIG = BUILDER.define("Default mutation chance", DEFAULT_MUTATION_CHANCE);
        MUTAGEN_EFFECTIVENESS = BUILDER.defineInRange("Mutagen effectiveness", 1f, 0f, 1f);
        MIN_SPREADING_SPEED = BUILDER.defineInRange("Minimum spreading speed", 25, 2, 25);
        MAX_SPREAD_BOOST = BUILDER.define("Maximum spreading boost", DEFAULT_SPREADBOOST*3);
        RADIUS_MULTIPLIER = BUILDER.define("Radius multiplier", 2);
        IGNORE_AMBIENT_CONDITIONS = BUILDER.define("Ignore ambient conditions for sporing", true);//FIXME false in final release (or totally removed)
        EFFECT_BLAZING_HIT_ENTITY_CHANCE = BUILDER.define("Chance of Blazing effect to hit an entity", 3);
        EFFECT_LIGHTNING_HIT_CREEPER_CHANCE = BUILDER.define("Chance of Lightning effect to hit a creeper", 3);
        SPEC = BUILDER.build();
    }
}
