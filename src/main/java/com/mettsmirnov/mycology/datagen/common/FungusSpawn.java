package com.mettsmirnov.mycology.datagen.common;

public class FungusSpawn
{
    public static final FungusSpawn NO_SPAWN = null;
    public static final FungusSpawn ANY_BIOME = new FungusSpawn("",.5f);
    public static final FungusSpawn FOREST = new FungusSpawn("minecraft:forest", .5f);
    public static final FungusSpawn DARK_FOREST = new FungusSpawn("minecraft:dark_forest", .5f);
    public static final FungusSpawn BIRCH_FOREST = new FungusSpawn("minecraft:birch_forest", .5f);
    public static final FungusSpawn OLD_GROWTH_BIRCH_FOREST = new FungusSpawn("minecraft:old_growth_birch_forest", .5f);
    public static final FungusSpawn OLD_GROWTH_SPRUCE_TAIGA = new FungusSpawn("minecraft:old_growth_spruce_taiga", .5f);
    public static final FungusSpawn OLD_GROWTH_PINE_TAIGA = new FungusSpawn("minecraft:old_growth_pine_taiga", .5f);
    public static final FungusSpawn MEADOW = new FungusSpawn("minecraft:meadow", .5f);
    public static final FungusSpawn SWAMP = new FungusSpawn("minecraft:swamp", .5f);
    public static final FungusSpawn JUNGLE = new FungusSpawn("minecraft:jungle", .5f);
    public static final FungusSpawn MUSHROOM_FIELDS = new FungusSpawn("minecraft:mushroom_fields", .5f);

    public String biomes;
    public float chance;

    public FungusSpawn(String biomes, float chance)
    {
        this.biomes = biomes;
        this.chance = chance;
    }
}