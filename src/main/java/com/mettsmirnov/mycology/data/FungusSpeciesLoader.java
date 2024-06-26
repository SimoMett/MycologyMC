package com.mettsmirnov.mycology.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import com.mettsmirnov.mycology.genetics.FungusTraits;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Collection;
import java.util.Map;

public class FungusSpeciesLoader extends SimpleJsonResourceReloadListener
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final FungusSpeciesLoader INSTANCE = new FungusSpeciesLoader();

    private FungusSpeciesLoader()
    {
        super(GSON, "fungi");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager, ProfilerFiller p_10795_)
    {
        FungusSpeciesList.INSTANCE.clearList();
        Collection<JsonElement> collection = map.values();
        for(JsonElement e : collection)
        {
            loadFungusSpecies(e.getAsJsonObject());
        }
    }

    private void loadFungusSpecies(JsonObject obj)
    {
        FungusTraits defaultTraits = new FungusTraits();
        defaultTraits.species=obj.get("species").getAsString();
        defaultTraits.spreading=obj.get("spreading").getAsInt();
        defaultTraits.spreadboost=obj.get("spreadboost").getAsFloat();
        defaultTraits.light=obj.get("light").getAsInt();
        defaultTraits.terrain=obj.get("terrain").getAsString();
        defaultTraits.humidity=obj.get("humidity").getAsFloat();
        defaultTraits.temp=obj.get("temperature").getAsFloat();
        defaultTraits.area=obj.get("area").getAsInt();
        defaultTraits.effect=obj.get("effect").getAsString();
        if(obj.get("eat_effect") != null)
            defaultTraits.eatingEffect=obj.get("eat_effect").getAsString();

        int [] colors = new int[4];
        for (int i = 0; i<colors.length; i++)
            colors[i]=obj.get("colors").getAsJsonArray().get(i).getAsInt();

        String fungusType = obj.get("type").getAsString();

        FungusSpawn spawnType = null;
        JsonObject spawnRoot = obj.getAsJsonObject("spawn");
        if(!spawnRoot.isEmpty())
        {
            String spawnBiomes = obj.getAsJsonObject("spawn").get("biomes").getAsString();
            float spawnChance = obj.getAsJsonObject("spawn").get("chance").getAsFloat();
            spawnType = new FungusSpawn(spawnBiomes, spawnChance);
        }

        FungusSpeciesList.INSTANCE.put(defaultTraits,colors,fungusType, spawnType);
    }

}
