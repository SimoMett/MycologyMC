package com.simomett.mycologymod.datagen.common;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.io.Serializable;

public class FungusSpawn implements Serializable
{
    private static final float DEFAULT_SPAWN_CHANCE = .4f;
    public static final FungusSpawn NO_SPAWN = null;
    public static final FungusSpawn ANY_BIOME = new FungusSpawn("#any", DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn PLAINS = new FungusSpawn(Biomes.PLAINS, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn SUNFLOWER_PLAINS = new FungusSpawn(Biomes.SUNFLOWER_PLAINS, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn FOREST = new FungusSpawn(Biomes.FOREST, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn FLOWER_FOREST = new FungusSpawn(Biomes.FLOWER_FOREST, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn DARK_FOREST = new FungusSpawn(Biomes.DARK_FOREST, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn BIRCH_FOREST = new FungusSpawn(Biomes.BIRCH_FOREST, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn SNOWY_TAIGA = new FungusSpawn(Biomes.SNOWY_TAIGA, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn OLD_GROWTH_BIRCH_FOREST = new FungusSpawn(Biomes.OLD_GROWTH_BIRCH_FOREST, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn OLD_GROWTH_SPRUCE_TAIGA = new FungusSpawn(Biomes.OLD_GROWTH_SPRUCE_TAIGA, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn OLD_GROWTH_PINE_TAIGA = new FungusSpawn(Biomes.OLD_GROWTH_PINE_TAIGA, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn MEADOW = new FungusSpawn(Biomes.MEADOW, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn SWAMP = new FungusSpawn(Biomes.SWAMP, 1f);
    public static final FungusSpawn JUNGLES = new FungusSpawn(BiomeTags.IS_JUNGLE, .7f);
    public static final FungusSpawn MUSHROOM_FIELDS = new FungusSpawn(Biomes.MUSHROOM_FIELDS, 1f);
    public static final FungusSpawn CAVES = new FungusSpawn("#caves", DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn NETHER_WASTES = new FungusSpawn(Biomes.NETHER_WASTES, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn SOUL_SAND_VALLEY = new FungusSpawn(Biomes.SOUL_SAND_VALLEY, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn END = new FungusSpawn(Biomes.THE_END, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn END_MIDLANDS = new FungusSpawn(Biomes.END_HIGHLANDS, DEFAULT_SPAWN_CHANCE);
    public static final FungusSpawn END_HIGHLANDS = new FungusSpawn(Biomes.END_HIGHLANDS, DEFAULT_SPAWN_CHANCE);
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
        this(biomeResourceKey.location().toString(), chance);
    }

    public FungusSpawn(TagKey<Biome> biomeTag, float chance)
    {
        this("#"+biomeTag.location(), chance);
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