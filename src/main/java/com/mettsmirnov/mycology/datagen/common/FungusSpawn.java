package com.mettsmirnov.mycology.datagen.common;

public class FungusSpawn
{
    public static final FungusSpawn DEFAULT = new FungusSpawn("",.5f);
    public static final FungusSpawn DARK_FOREST = new FungusSpawn("dark_forest", .5f);

    public String biomes;
    public float chance;

    public FungusSpawn(String biomes, float chance)
    {
        this.biomes = biomes;
        this.chance = chance;
    }
}