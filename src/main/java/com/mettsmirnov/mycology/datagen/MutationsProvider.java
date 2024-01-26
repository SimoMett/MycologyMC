package com.mettsmirnov.mycology.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class MutationsProvider implements DataProvider
{
    private final DataGenerator generator;
    public MutationsProvider(DataGenerator dataGenerator)
    {
        this.generator = dataGenerator;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput)
    {
        addMutation("WHITE_FUNGUS", "Green lactarius", "LIME_FUNGUS", cachedOutput);
        return CompletableFuture.allOf();
    }

    private void addMutation(String species1, String species2, String result, CachedOutput cache)
    {
        JsonObject mutationJson = new JsonObject();
        mutationJson.addProperty("species1", species1);
        mutationJson.addProperty("species2", species2);
        mutationJson.addProperty("result", result);

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = result.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "fungi_breeding", jsonFileName));

        DataProvider.saveStable(cache, mutationJson, jsonLocation);
    }

    @Override
    public String getName() { return "Mutations"; }
}
