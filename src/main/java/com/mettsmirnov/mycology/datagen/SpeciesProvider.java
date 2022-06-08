package com.mettsmirnov.mycology.datagen;

import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedInts;
import com.google.gson.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import org.jline.utils.Log;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.JsonObjectBuilder;
import java.awt.*;
import java.nio.file.Path;
import java.util.Arrays;

public class SpeciesProvider implements DataProvider
{
    private final DataGenerator generator;
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    public SpeciesProvider(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(HashCache hashCache)
    {
        Path path = this.generator.getOutputFolder();

        createSpecies("amanita", "rubra",
                "colored_crimson_fungus",
                new int[]{
                        16777164,
                        16724736,
                        15921906,
                        15921906
                },
                25,
                1.0f,
                15,
                "grass",
                0.8f,
                0.25f,
                3,
                "none",
                new FungusSpawn("",0.5f),
                hashCache
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

    //ugly code: too many parameters. I'll find a solution one day
    private static void createSpecies(String genusName, String speciesName, String type, @Nonnull int[] colors,
                                      float spreading, float spreadBoost, int light, String terrain, float humidity,
                                      float temperature, int area, String effect, @Nullable FungusSpawn spawnType,
                                      HashCache hashCache)
    {
        String name = genusName.substring(0,1).toUpperCase() + genusName.substring(1) + " " + speciesName.toLowerCase();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("species",name);
        jsonObject.addProperty("type",type);
        UnsignedInteger[] colorsAsInt = new UnsignedInteger[] {
                UnsignedInteger.valueOf(colors[0]),
                UnsignedInteger.valueOf(colors[1]),
                UnsignedInteger.valueOf(colors[2]),
                UnsignedInteger.valueOf(colors[3])
        };
        jsonObject.addProperty("colors", Arrays.toString(colorsAsInt));
        jsonObject.addProperty("spreading",spreading);
        jsonObject.addProperty("spreadboost",spreadBoost);
        jsonObject.addProperty("light",light);
        jsonObject.addProperty("terrain",terrain);
        jsonObject.addProperty("humidity",humidity);
        jsonObject.addProperty("temperature",temperature);
        jsonObject.addProperty("area",area);
        jsonObject.addProperty("effect",effect);
        if(spawnType!=null)
        {
            //TODO need testing
            JsonObject spawnJson = new JsonObject();
            spawnJson.addProperty("biomes", spawnType.biomes);
            spawnJson.addProperty("chance",spawnType.chance);
            jsonObject.add("spawn", spawnJson);
        }
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
