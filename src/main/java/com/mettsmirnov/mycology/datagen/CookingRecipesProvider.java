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

import static com.mettsmirnov.mycology.datagen.SpeciesDictionary.*;

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
        // Colors
        addSmeltingRecipes(YELLOW_FUNGUS, Items.YELLOW_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(ORANGE_FUNGUS, Items.ORANGE_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(AMANITA_RUBRA, Items.RED_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(OVULUS_VIOLACEUS, Items.PURPLE_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(CYAN_FUNGUS, Items.CYAN_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(BLUE_FUNGUS, Items.BLUE_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(LACTARIUS_VIRIDIS, Items.GREEN_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(WHITE_FUNGUS, Items.WHITE_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(GREY_FUNGUS, Items.GRAY_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(LIME_FUNGUS, Items.LIME_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(LIGHTGREY_FUNGUS, Items.LIGHT_GRAY_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(BLACK_FUNGUS, Items.BLACK_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(LIGHTBLUE_FUNGUS, Items.LIGHT_BLUE_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(PINK_FUNGUS, Items.PINK_DYE, 2, 0, 200, cache);
        addSmeltingRecipes(MAGENTA_FUNGUS, Items.MAGENTA_DYE, 2, 0, 200, cache);

        // Minerals
        addSmeltingRecipes(RUSSULA_LAZULA, Items.LAPIS_LAZULI, 0f, 200, cache);
        addSmeltingRecipes(GALERINA_AURATA, Items.GOLD_NUGGET, 2, 0f, 200, cache);
        addSmeltingRecipes(XEROCOMUS_FERRUGINEUS, Items.IRON_NUGGET, 2, 0, 200, cache);
        addSmeltingRecipes(AMANITA_CUPREA, Items.RAW_COPPER, 0, 400, cache); //FIXME need copper nugget item
        addSmeltingRecipes(DIAMOND_FUNGUS, Items.DIAMOND, 0, 400, cache); //FIXME need diamond chunk item
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
