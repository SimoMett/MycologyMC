package com.mettsmirnov.mycology.datagen.common;

public class FungusSpawn
{
    public static final FungusSpawn NO_SPAWN = null;
    public static final FungusSpawn ANY_BIOME = new FungusSpawn("",.5f);
    public static final FungusSpawn DARK_FOREST = new FungusSpawn("minecraft:dark_forest", .5f);
    public static final FungusSpawn SWAMP = new FungusSpawn("minecraft:swamp", .5f);

    public String biomes;
    public float chance;

    public FungusSpawn(String biomes, float chance)
    {
        this.biomes = biomes;
        this.chance = chance;
    }
}