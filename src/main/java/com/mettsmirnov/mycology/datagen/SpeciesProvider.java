package com.mettsmirnov.mycology.datagen;

import com.google.gson.*;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;
import org.jline.utils.Log;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Path;

public class SpeciesProvider implements DataProvider
{
    private final DataGenerator generator;
    public SpeciesProvider(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(CachedOutput hashCache)
    {
        //TODO refactoring
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
                generator,
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
    //TODO refactoring
    private static void createSpecies(String genusName, String speciesName, String type, @Nonnull int[] colors,
                                      float spreading, float spreadBoost, int light, String terrain, float humidity,
                                      float temperature, int area, String effect, @Nullable FungusSpawn spawnType,
                                      DataGenerator generator, CachedOutput hashCache)
    {
        String name = genusName.substring(0,1).toUpperCase() + genusName.substring(1) + " " + speciesName.toLowerCase();
        JsonObject fungusJson = new JsonObject();
        fungusJson.addProperty("species",name);
        fungusJson.addProperty("type",type);
        JsonArray jsonColors = new JsonArray();
        for(int i = 0; i<4; i++)
            jsonColors.add(colors[i]);
        fungusJson.add("colors", jsonColors);
        fungusJson.addProperty("spreading",spreading);
        fungusJson.addProperty("spreadboost",spreadBoost);
        fungusJson.addProperty("light",light);
        fungusJson.addProperty("terrain",terrain);
        fungusJson.addProperty("humidity",humidity);
        fungusJson.addProperty("temperature",temperature);
        fungusJson.addProperty("area",area);
        fungusJson.addProperty("effect",effect);
        if(spawnType!=null)
        {
            JsonObject spawnJson = new JsonObject();
            spawnJson.addProperty("biomes", spawnType.biomes);
            spawnJson.addProperty("chance",spawnType.chance);
            fungusJson.add("spawn", spawnJson);
        }

        Path path = generator.getOutputFolder();
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "fungi", genusName.toLowerCase() + "_" + speciesName.toLowerCase() + ".json"));
        try
        {
            DataProvider.saveStable(hashCache,fungusJson,jsonLocation);
        }
        catch (IOException e)
        {
            Log.error(e);
        }

    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
