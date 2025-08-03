package com.simomett.mycologymod.config;

public interface IModCommonConfigs
{
    float DEFAULT_MUTATION_CHANCE = .6f;

    int getMaxMushroomInArea();
    float getBreedingChance();
    float getDefaultMutationChance();
    double getMutagenEffectiveness();
    int getMinSpreadingSpeed();
    float getMaxSpreadBoost();
    int getRadiusMultiplier();
    int getEffectBlazingHitEntityChance();
    int getEffectLightningHitCreeperChance();
}
