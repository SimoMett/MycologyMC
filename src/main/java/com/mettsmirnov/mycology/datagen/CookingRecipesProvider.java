package com.mettsmirnov.mycology.datagen;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.recipes.cooking.FungusCookingRecipe;
import com.mettsmirnov.mycology.recipes.cooking.FungusCookingRecipeSerializer;
import com.mettsmirnov.mycology.recipes.cooking.ModCookingRecipes;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class CookingRecipesProvider implements DataProvider
{
    private final DataGenerator generator;
    private final ArrayList<CompletableFuture<?>> list = new ArrayList<>();
    public CookingRecipesProvider(DataGenerator dataGenerator)
    {
        this.generator = dataGenerator;
    }
    @Override
    public @NotNull CompletableFuture<?> run(CachedOutput cache)
    {
        addSmeltingRecipes("Amanita rubra", Items.RED_DYE, 0, 200, cache);
        addSmeltingRecipes("Russula lazula", Items.LAPIS_LAZULI, 0f, 200, cache);
        addSmeltingRecipes("Galerina aurata", Items.GOLD_NUGGET, 2, 0f, 200, cache);

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }
    private void addSmeltingRecipes(String ingredientSpecies, Item resultItem, float exp, int cookingTime, CachedOutput cache)
    {
        addSmeltingRecipes(ingredientSpecies, resultItem, 1, exp, cookingTime, cache);
    }

    private void addSmeltingRecipes(String ingredientSpecies, Item resultItem, int stackSize, float exp, int cookingTime, CachedOutput cache)
    {
        JsonObject mutationJson = new JsonObject();
        String type = ModCookingRecipes.FUNGUS_COOKING_RECIPE_SERIALIZER.getKey().location().toString();
        mutationJson.addProperty("type",type);
        mutationJson.addProperty("ingredient", ingredientSpecies);
        String result = ForgeRegistries.ITEMS.getDelegate(resultItem).get().key().location().toString();
        mutationJson.addProperty("result", result);
        mutationJson.addProperty("count", stackSize);
        mutationJson.addProperty("experience", exp);
        mutationJson.addProperty("cookingtime", cookingTime);

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = "cooked_"+ingredientSpecies.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "recipes", jsonFileName));

        list.add(DataProvider.saveStable(cache, mutationJson, jsonLocation));
    }

    @Override
    public String getName() {
        return "Mycology Cooking recipes";
    }
}
