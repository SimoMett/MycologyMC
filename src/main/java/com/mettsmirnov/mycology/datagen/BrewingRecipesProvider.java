package com.mettsmirnov.mycology.datagen;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.mettsmirnov.mycology.datagen.common.SpeciesDictionary.*;

public class BrewingRecipesProvider implements DataProvider
{
    private final DataGenerator generator;
    private final ArrayList<CompletableFuture<?>> list = new ArrayList<>();

    public BrewingRecipesProvider(DataGenerator generator) {
        this.generator = generator;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput)
    {
        addBrewingRecipe(AMANITA_RUBRA, new ResourceLocation("strong_poison"), cachedOutput); //Testing only

        addBrewingRecipe(TELEPORTING_FUNGUS, new ResourceLocation(MycologyMod.MODID, "teleporting"), cachedOutput);

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    private void addBrewingRecipe(String ingredientSpecies, ResourceLocation potionResult, CachedOutput cache)
    {
        JsonObject mutationJson = new JsonObject();
        mutationJson.addProperty("species", ingredientSpecies);
        mutationJson.addProperty("result", potionResult.toString());

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = ingredientSpecies.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "fungi_brewing", jsonFileName));

        list.add(DataProvider.saveStable(cache, mutationJson, jsonLocation));
    }

    @Override
    public String getName() {
        return "Mycology Brewing recipes";
    }
}
