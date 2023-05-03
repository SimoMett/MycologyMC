package com.mettsmirnov.mycology.datagen;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.effects.FungusEffect;
import com.mettsmirnov.mycology.datagen.common.BiomesSpecs;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SpeciesBuilder
{
    private SpeciesBuilder(){}
    private static final SpeciesBuilder builderInstance = new SpeciesBuilder();

    public static SpeciesBuilder getInstance()
    {
        return builderInstance;
    }

    //Traits
    private String speciesName;
    private String type;
    private int[] colors;
    private int spreading;
    private float spreadBoost;
    private int light;
    private String terrain;
    private BiomesSpecs biomesSpecs;
    private FungusEffect areaEffect;
    private FungusSpawn spawnType;

    //Methods chaining
    public SpeciesBuilder createSpecies(String speciesName)
    {
        this.speciesName = speciesName;
        return this;
    }

    public SpeciesBuilder createDefaultSpecies(String speciesName)
    {
        this.speciesName = speciesName;
        this.spreading = 25;
        this.spreadBoost = 1.0f;
        this.light = 15;
        this.terrain = "mycologymod:grass";
        this.biomesSpecs = BiomesSpecs.FOREST;
        this.areaEffect = FungusEffect.NO_EFFECT;
        this.spawnType = FungusSpawn.DEFAULT_SPAWN;
        return this;
    }

    public SpeciesBuilder type(String type)
    {
        this.type = type;
        return this;
    }

    public SpeciesBuilder colors(int[] colors)
    {
        this.colors = colors;
        return this;
    }

    public SpeciesBuilder spreading(int spreading)
    {
        this.spreading = spreading;
        return this;
    }

    public SpeciesBuilder spreadBoost(float spreadBoost)
    {
        this.spreadBoost = spreadBoost;
        return this;
    }

    public SpeciesBuilder light(int light)
    {
        this.light = light;
        return this;
    }

    public SpeciesBuilder terrain(String terrain)
    {
        this.terrain = terrain;
        return this;
    }

    public SpeciesBuilder biomesSpecs(BiomesSpecs biomesSpecs)
    {
        this.biomesSpecs = biomesSpecs;
        return this;
    }

    public SpeciesBuilder areaEffect(FungusEffect areaEffect)
    {
        this.areaEffect = areaEffect;
        return this;
    }

    public SpeciesBuilder spawnType(FungusSpawn spawnType)
    {
        this.spawnType = spawnType;
        return this;
    }

    public void buildAndAddToList(DataGenerator generator, CachedOutput hashCache, List<CompletableFuture<?>> list)
    {
        //IMPORTANT TODO: sanitize speciesName string
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
        fungusJson.addProperty("humidity",biomesSpecs.humidity);
        fungusJson.addProperty("temperature",biomesSpecs.temperature);
        fungusJson.addProperty("area",areaEffect.getAreaRadius());
        fungusJson.addProperty("effect",areaEffect.getEffect());
        if(spawnType!=null)
        {
            JsonObject spawnJson = new JsonObject();
            spawnJson.addProperty("biomes", spawnType.biomes);
            spawnJson.addProperty("chance",spawnType.chance);
            fungusJson.add("spawn", spawnJson);
        }

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = speciesName.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "fungi", jsonFileName));

        list.add(DataProvider.saveStable(hashCache,fungusJson,jsonLocation));
    }

}
