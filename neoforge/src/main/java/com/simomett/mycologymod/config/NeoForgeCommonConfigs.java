package com.simomett.mycologymod.config;


import net.neoforged.neoforge.common.ModConfigSpec;

import static com.simomett.mycologymod.datagen.common.SpeciesBuilder.DEFAULT_SPREADBOOST;

public final class NeoForgeCommonConfigs implements IModCommonConfigs
{
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    private static final ModConfigSpec.ConfigValue<Integer> MAX_MUSHROOMS_IN_AREA;
    private static final ModConfigSpec.ConfigValue<Float> BREEDING_CHANCE;
    private static final float DEFAULT_MUTATION_CHANCE = .6f;
    private static final ModConfigSpec.ConfigValue<Float> DEFAULT_MUTATION_CHANCE_CONFIG;
    private static final ModConfigSpec.DoubleValue MUTAGEN_EFFECTIVENESS;
    private static final ModConfigSpec.IntValue MIN_SPREADING_SPEED;
    private static final ModConfigSpec.ConfigValue<Float> MAX_SPREAD_BOOST;
    private static final ModConfigSpec.ConfigValue<Integer> RADIUS_MULTIPLIER;
    private static final ModConfigSpec.ConfigValue<Integer> EFFECT_BLAZING_HIT_ENTITY_CHANCE;
    private static final ModConfigSpec.ConfigValue<Integer> EFFECT_LIGHTNING_HIT_CREEPER_CHANCE;

    static
    {
        MAX_MUSHROOMS_IN_AREA = BUILDER.define("Max spread count of mushrooms", 4); // I don't want mushrooms spamming all over the biomes
        BREEDING_CHANCE = BUILDER.define("Cross-breeding chance", .6f);
        DEFAULT_MUTATION_CHANCE_CONFIG = BUILDER.define("Default mutation chance", DEFAULT_MUTATION_CHANCE);
        MUTAGEN_EFFECTIVENESS = BUILDER.defineInRange("Mutagen effectiveness", .9f, 0f, 1f);
        MIN_SPREADING_SPEED = BUILDER.defineInRange("Minimum spreading speed", 25, 2, 25);
        MAX_SPREAD_BOOST = BUILDER.define("Maximum spreading boost", DEFAULT_SPREADBOOST*3);
        RADIUS_MULTIPLIER = BUILDER.define("Radius multiplier", 2);
        EFFECT_BLAZING_HIT_ENTITY_CHANCE = BUILDER.define("Chance of Blazing effect to hit an entity", 3);
        EFFECT_LIGHTNING_HIT_CREEPER_CHANCE = BUILDER.define("Chance of Lightning effect to hit a creeper", 3);
        SPEC = BUILDER.build();
    }

    @Override
    public int getMaxMushroomInArea() {
        return MAX_MUSHROOMS_IN_AREA.get();
    }

    @Override
    public float getBreedingChance() {
        return BREEDING_CHANCE.get();
    }

    @Override
    public float getDefaultMutationChance() {
        return DEFAULT_MUTATION_CHANCE_CONFIG.get();
    }

    @Override
    public double getMutagenEffectiveness()
    {
        return MUTAGEN_EFFECTIVENESS.get();
    }

    @Override
    public int getMinSpreadingSpeed()
    {
        return MIN_SPREADING_SPEED.get();
    }

    @Override
    public float getMaxSpreadBoost()
    {
        return MAX_SPREAD_BOOST.get();
    }

    @Override
    public int getRadiusMultiplier() {
        return RADIUS_MULTIPLIER.get();
    }

    @Override
    public int getEffectBlazingHitEntityChance() {
        return EFFECT_BLAZING_HIT_ENTITY_CHANCE.get();
    }

    @Override
    public int getEffectLightningHitCreeperChance() {
        return EFFECT_LIGHTNING_HIT_CREEPER_CHANCE.get();
    }
}
