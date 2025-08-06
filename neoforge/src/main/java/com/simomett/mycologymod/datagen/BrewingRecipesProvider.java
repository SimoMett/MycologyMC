package com.simomett.mycologymod.datagen;

import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.items.potions.Potions;
import net.minecraft.core.Holder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.alchemy.Potion;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.*;


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
        addBrewingRecipe(STRENGTH_FUNGUS, Potions.HASTE, cachedOutput);
        addBrewingRecipe(ANESTHETIC_FUNGUS, Potions.ANESTHETIC, cachedOutput);
        addBrewingRecipe(ILLUCINATING_FUNGUS, Potions.ILLUCINATING, cachedOutput);
        addBrewingRecipe(BLINDING_FUNGUS, Potions.BLINDING, cachedOutput);
        addBrewingRecipe(SENSING_FUNGUS, Potions.SENSING, cachedOutput);
        addBrewingRecipe(WITHERING_FUNGUS, Potions.WITHERING, cachedOutput);
        addBrewingRecipe(TELEPORTING_FUNGUS, Potions.TELEPORTING, cachedOutput);
        addBrewingRecipe(SPEED_FUNGUS, net.minecraft.world.item.alchemy.Potions.SWIFTNESS, cachedOutput);
        addBrewingRecipe(GOODCHANCE_FUNGUS, net.minecraft.world.item.alchemy.Potions.LUCK, cachedOutput);

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    private void addBrewingRecipe(String ingredientSpecies, Holder<Potion> potion, CachedOutput cache)
    {
        JsonObject mutationJson = new JsonObject();
        mutationJson.addProperty("species", ingredientSpecies);
        mutationJson.addProperty("result", potion.getKey().location().toString());

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = ingredientSpecies.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), Constants.MOD_ID, "fungi_brewing", jsonFileName));

        list.add(DataProvider.saveStable(cache, mutationJson, jsonLocation));
    }

    @Override
    public String getName() {
        return "Mycology Brewing recipes";
    }
}
