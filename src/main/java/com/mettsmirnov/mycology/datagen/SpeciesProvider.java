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
import java.awt.geom.Area;
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
        createSpecies("Amanita rubra",
                "colored_crimson_fungus",
                new int[]{ 16777164, 16724736, 15921906, 15921906 },
                25,
                1.0f,
                15,
                "mycologymod:grass",
                new BiomeSpecs(0.8f, 0.25f),
                AreaEffect.NO_EFFECT,
                FungusSpawn.DEFAULT_SPAWN,
                generator,
                hashCache
        );

        createSpecies("Noble boletus squisitus",
                "colored_crimson_fungus",
                new int[]{ 0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd },
                25,
                1.0f,
                15,
                "mycologymod:grass",
                new BiomeSpecs(0.8f, 0.25f),
                AreaEffect.NO_EFFECT,
                FungusSpawn.DEFAULT_SPAWN,
                generator,
                hashCache
        );
    }

    private static class AreaEffect
    {
        public static final AreaEffect NO_EFFECT = new AreaEffect(3, "none");
        public int areaRadius;
        public String effect;

        public AreaEffect(int areaRadius, String effect)
        {
            this.areaRadius = areaRadius;
            this.effect = effect;
        }
    }

    private static class FungusSpawn
    {
        public static final FungusSpawn DEFAULT_SPAWN = new FungusSpawn("",0.5f);

        public String biomes;
        public float chance;

        public FungusSpawn(String biomes, float chance)
        {
            this.biomes = biomes;
            this.chance = chance;
        }
    }

    private static class BiomeSpecs
    {
        public float humidity;
        public float temperature;

        public BiomeSpecs(float humidity, float temperature)
        {
            this.humidity = humidity;
            this.temperature = temperature;
        }
    }

    //ugly code: too many parameters. I'll find a solution one day
    //TODO refactoring
    private static void createSpecies(String speciesName, String type, @Nonnull int[] colors, float spreading, float spreadBoost,
                                      int light, String terrain, BiomeSpecs biomeSpecs, AreaEffect areaEffect,
                                      @Nullable FungusSpawn spawnType, DataGenerator generator, CachedOutput hashCache)
    {
        JsonObject fungusJson = new JsonObject();
        fungusJson.addProperty("species",speciesName);
        fungusJson.addProperty("type",type);
        JsonArray jsonColors = new JsonArray();
        for(int i = 0; i<4; i++)
            jsonColors.add(colors[i]);
        fungusJson.add("colors", jsonColors);
        fungusJson.addProperty("spreading",spreading);
        fungusJson.addProperty("spreadboost",spreadBoost);
        fungusJson.addProperty("light",light);
        fungusJson.addProperty("terrain",terrain);
        fungusJson.addProperty("humidity",biomeSpecs.humidity);
        fungusJson.addProperty("temperature",biomeSpecs.temperature);
        fungusJson.addProperty("area",areaEffect.areaRadius);
        fungusJson.addProperty("effect",areaEffect.effect);
        if(spawnType!=null)
        {
            JsonObject spawnJson = new JsonObject();
            spawnJson.addProperty("biomes", spawnType.biomes);
            spawnJson.addProperty("chance",spawnType.chance);
            fungusJson.add("spawn", spawnJson);
        }

        Path path = generator.getOutputFolder();
        String jsonFileName = speciesName.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "fungi", jsonFileName));
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
