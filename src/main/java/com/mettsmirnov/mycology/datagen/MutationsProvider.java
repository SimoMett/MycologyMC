package com.mettsmirnov.mycology.datagen;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;

import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.mettsmirnov.mycology.constants.Constants.DEFAULT_MUTATION_CHANCE;

public class MutationsProvider implements DataProvider
{
    private final DataGenerator generator;
    private final ArrayList<CompletableFuture<?>> list = new ArrayList<>();
    public MutationsProvider(DataGenerator dataGenerator)
    {
        this.generator = dataGenerator;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput)
    {
        addMutation("WHITE_FUNGUS", "Lactarius viridis", "LIME_FUNGUS", cachedOutput);
        addMutation("WHITE_FUNGUS", "GREY_FUNGUS", "LIGHTGREY_FUNGUS", cachedOutput);
        addMutation("WHITE_FUNGUS", "BLACK_FUNGUS", "GREY_FUNGUS", cachedOutput);
        addMutation("WHITE_FUNGUS", "BLUE_FUNGUS", "LIGHTBLUE_FUNGUS", cachedOutput);
        addMutation("WHITE_FUNGUS", "Amanita rubra", "PINK_FUNGUS", cachedOutput);
        addMutation("BLUE_FUNGUS", "Amanita rubra", "VIOLET_ovulus", cachedOutput);
        addMutation("BLUE_FUNGUS", "Lactarius viridis", "CYAN_FUNGUS", cachedOutput);
        addMutation("VIOLET_ovulus", "VIOLET_ovulus", "MAGENTA_FUNGUS", cachedOutput);
        addMutation("Amanita rubra", "YELLOW_FUNGUS", "ORANGE_FUNGUS", cachedOutput);
        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    private void addMutation(String species1, String species2, String result, CachedOutput cache)
    {
        JsonObject mutationJson = new JsonObject();
        mutationJson.addProperty("species1", species1);
        mutationJson.addProperty("species2", species2);
        mutationJson.addProperty("result", result);
        mutationJson.addProperty("chance", DEFAULT_MUTATION_CHANCE);

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = result.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "mutations", jsonFileName));

        list.add(DataProvider.saveStable(cache, mutationJson, jsonLocation));
    }

    private void addMutation2(String species1, String species2, String result, float chance, CachedOutput cache)
    {
        if (chance > 1f || chance <= 0f)
            throw new InvalidParameterException("Invalid 'chance' parameter");
        JsonObject mutationJson = new JsonObject();
        mutationJson.addProperty("species1", species1);
        mutationJson.addProperty("species2", species2);
        mutationJson.addProperty("result", result);
        mutationJson.addProperty("chance", chance);

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = result.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "mutations", jsonFileName));

        list.add(DataProvider.saveStable(cache, mutationJson, jsonLocation));
    }

    @Override
    public String getName() { return "Mutations"; }
}
