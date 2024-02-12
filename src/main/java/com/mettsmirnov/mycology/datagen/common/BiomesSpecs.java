package com.mettsmirnov.mycology.datagen.common;

public class BiomesSpecs
{
    public static final BiomesSpecs JUNGLE = new BiomesSpecs(0.9f, 0.95f);
    public static final BiomesSpecs MUSHROOM_FIELDS = new BiomesSpecs(1f, 0.9f);
    public static final BiomesSpecs PLAINS = new BiomesSpecs(0.4f, 0.8f);
    public static final BiomesSpecs SWAMP = new BiomesSpecs(0.9f, 0.8f);
    public static final BiomesSpecs FOREST = new BiomesSpecs(0.8f, 0.7f);
    public static final BiomesSpecs BIRCH_FOREST = new BiomesSpecs(0.6f, 0.6f);
    public static final BiomesSpecs MEADOW = new BiomesSpecs(0.8f, 0.5f);
    public static final BiomesSpecs LUSH_CAVES = new BiomesSpecs(0.5f, 0.5f);
    public static final BiomesSpecs TAIGA = new BiomesSpecs(0.8f, 0.25f);
    public static final BiomesSpecs OLD_GROWTH_SPRUCE_TAIGA = new BiomesSpecs(0.8f, 0.25f);
    public static final BiomesSpecs OLD_GROWTH_PINE_TAIGA = new BiomesSpecs(0.8f, .3f);
    public static final BiomesSpecs SNOWY_PLAINS = new BiomesSpecs(0.5f, 0f);
    public static final BiomesSpecs SNOWY_TAIGA = new BiomesSpecs(0.4f, -0.5f);
    public float humidity;
    public float temperature;

    public BiomesSpecs(float humidity, float temperature)
    {
        this.humidity = humidity;
        this.temperature = temperature;
    }
}