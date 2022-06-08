package com.mettsmirnov.mycology.datagen;

import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedInts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import org.jline.utils.Log;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.JsonObjectBuilder;
import java.awt.*;
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
    public void run(HashCache p_123925_)
    {
        createSpecies("amanita", "rubra",
                "colored_crimson_fungus",
                new Color[]{
                        new Color(16777164),
                        new Color(16724736),
                        new Color(15921906),
                        new Color(15921906)
                },
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

    private static void createSpecies(String genusName, String speciesName, String type, @Nonnull Color[] colors, float spreading,
                                      float spreadBoost, int light, String terrain, float humidity, float temperature,
                                      int area, String effect, @Nullable FungusSpawn spawnType)
    {
        String name = genusName.substring(0,1).toUpperCase() + genusName.substring(1) + " " + speciesName.toLowerCase();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("species",name);
        jsonObject.addProperty("type",type);
        //TODO save colors array in jsonObject
        //UnsignedInteger[] colorsAsInt = {colors[0].hashCode(),colors[1].hashCode(),colors[2].hashCode(),colors[3].hashCode()};
        //jsonObject.addProperty("colors", Arrays.toString(colorsAsInt));
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
