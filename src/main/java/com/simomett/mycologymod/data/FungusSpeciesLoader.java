package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.datagen.common.FungusSpawn;
import com.simomett.mycologymod.genetics.FungusTraits;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Collection;
import java.util.Map;

import static com.simomett.mycologymod.genetics.FungusGenoma.*;

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
        FungusTraits defaultTraits = new FungusTraits(
        obj.get(SPECIES).getAsString(),
        obj.get(SPREADING).getAsInt(),
        obj.get(SPREAD_BOOST).getAsFloat(),
        obj.get(LIGHT).getAsInt(),
        obj.get(TERRAIN).getAsString(),
        obj.get(HUMIDITY).getAsFloat(),
        obj.get(TEMP).getAsFloat(),
        obj.get(AREA).getAsInt(),
        obj.get(EFFECT).getAsString(),
        obj.get(EATING_EFFECT) != null ? obj.get(EATING_EFFECT).getAsString() : null);

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
