package com.mettsmirnov.mycology.datagen.common;

public class FungusSpawn
{
    public static final FungusSpawn DEFAULT_SPAWN = new FungusSpawn("",0.5f);

    public String biomes;
    public float chance;

    public FungusSpawn(String biomes, float chance)
    {
        this.biomes = biomes;
        this.chance = chance;
    }
}