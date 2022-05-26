package com.mettsmirnov.mycology.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import org.jline.utils.Log;

import java.awt.*;

public class SpeciesProvider implements DataProvider
{
    private DataGenerator generator;
    public SpeciesProvider(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(HashCache p_123925_)
    {
        createSpecies("Red amanita",
                "colored_crimson_fungus",
                new Color[]{new Color(16777164),new Color(16724736), new Color(15921906), new Color(15921906)},
                25,
                1.0f,
                15,
                "grass",
                0.8f,
                0.25f,
                3,
                "none",
                new FungusSpawn("",0.5f)
        );
    }

    private static class FungusSpawn
    {
        public String biomes;
        public float chance;

        public FungusSpawn(String biomes, float chance)
        {
            this.biomes = biomes;
            this.chance = chance;
        }
    }

    private static void createSpecies(String name, String type, Color[] colors, float spreading, float spreadBoost, int light, String terrain, float humidity, float temperature, int area, String effect, FungusSpawn spawnType)
    {

    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
