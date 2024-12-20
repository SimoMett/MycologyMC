package com.simomett.mycologymod.datagen.common;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class FungusSpawn
{
    public static final FungusSpawn NO_SPAWN = null;
    public static final FungusSpawn ANY_BIOME = new FungusSpawn("#any",.5f);
    public static final FungusSpawn PLAINS = new FungusSpawn("minecraft:plains", .5f);
    public static final FungusSpawn SUNFLOWER_PLAINS = new FungusSpawn(Biomes.SUNFLOWER_PLAINS, .5f);
    public static final FungusSpawn FOREST = new FungusSpawn("minecraft:forest", .5f);
    public static final FungusSpawn FLOWER_FOREST = new FungusSpawn(Biomes.FLOWER_FOREST, .5f);
    public static final FungusSpawn DARK_FOREST = new FungusSpawn(Biomes.DARK_FOREST, .5f);
    public static final FungusSpawn BIRCH_FOREST = new FungusSpawn("minecraft:birch_forest", .5f);
    public static final FungusSpawn SNOWY_TAIGA = new FungusSpawn(Biomes.SNOWY_TAIGA, .5f);
    public static final FungusSpawn OLD_GROWTH_BIRCH_FOREST = new FungusSpawn("minecraft:old_growth_birch_forest", .5f);
    public static final FungusSpawn OLD_GROWTH_SPRUCE_TAIGA = new FungusSpawn("minecraft:old_growth_spruce_taiga", .5f);
    public static final FungusSpawn OLD_GROWTH_PINE_TAIGA = new FungusSpawn("minecraft:old_growth_pine_taiga", .5f);
    public static final FungusSpawn MEADOW = new FungusSpawn("minecraft:meadow", .5f);
    public static final FungusSpawn SWAMP = new FungusSpawn(Biomes.SWAMP, .5f);
    public static final FungusSpawn JUNGLE = new FungusSpawn(Biomes.JUNGLE, .5f);
    public static final FungusSpawn MUSHROOM_FIELDS = new FungusSpawn(Biomes.MUSHROOM_FIELDS, .5f);
    public static final FungusSpawn CAVES = new FungusSpawn("#caves", .5f);
    public static final FungusSpawn NETHER_WASTES = new FungusSpawn(Biomes.NETHER_WASTES, .5f);
    public static final FungusSpawn SOUL_SAND_VALLEY = new FungusSpawn(Biomes.SOUL_SAND_VALLEY, .5f);
    public static final FungusSpawn END = new FungusSpawn(Biomes.THE_END, .5f);
    public static final FungusSpawn END_MIDLANDS = new FungusSpawn(Biomes.END_HIGHLANDS, .5f);
    public static final FungusSpawn END_HIGHLANDS = new FungusSpawn(Biomes.END_HIGHLANDS, .5f);
    public static final FungusSpawn VERY_RARE = new FungusSpawn("#any",.1f);//FIXME to adjust

    private String biomes;
    public final float chance;

    public FungusSpawn(String biomes, float chance)
    {
        this.biomes = biomes;
        this.chance = chance;
    }

    public FungusSpawn(ResourceKey<Biome> biomeResourceKey, float chance)
    {
        this.biomes = biomeResourceKey.location().toString();
        this.chance = chance;
    }

    public String getBiomes()
    {
        return this.biomes;
    }

    public FungusSpawn withBiomes(ResourceKey<Biome> biomeResourceKey)
    {
        return new FungusSpawn(biomeResourceKey, this.chance);
    }

    public FungusSpawn chance(float chance)
    {
        return new FungusSpawn(this.biomes, chance);
    }

    public boolean equals(FungusSpawn obj)
    {
        return biomes.equals(obj.biomes) && chance == obj.chance;
    }
}