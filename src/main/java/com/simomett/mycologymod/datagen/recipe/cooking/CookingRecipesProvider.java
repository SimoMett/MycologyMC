package com.simomett.mycologymod.datagen.recipe.cooking;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.*;

public class CookingRecipesProvider extends RecipeProvider
{
    protected CookingRecipesProvider(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @Override
    protected void buildRecipes()
    {
        // Colors
        addSmeltingRecipes(YELLOW_FUNGUS, Items.YELLOW_DYE, 2, 0, 200);
        addSmeltingRecipes(ORANGE_FUNGUS, Items.ORANGE_DYE, 2, 0, 200);
        addSmeltingRecipes(AMANITA_RUBRA, Items.RED_DYE, 2, 0, 200);
        addSmeltingRecipes(OVULUS_VIOLACEUS, Items.PURPLE_DYE, 2, 0, 200);
        addSmeltingRecipes(CYAN_FUNGUS, Items.CYAN_DYE, 2, 0, 200);
        addSmeltingRecipes(BLUE_FUNGUS, Items.BLUE_DYE, 2, 0, 200);
        addSmeltingRecipes(LACTARIUS_VIRENS, Items.GREEN_DYE, 2, 0, 200);
        addSmeltingRecipes(WHITE_FUNGUS, Items.WHITE_DYE, 2, 0, 200);
        addSmeltingRecipes(GREY_FUNGUS, Items.GRAY_DYE, 2, 0, 200);
        addSmeltingRecipes(LIME_FUNGUS, Items.LIME_DYE, 2, 0, 200);
        addSmeltingRecipes(LIGHTGREY_FUNGUS, Items.LIGHT_GRAY_DYE, 2, 0, 200);
        addSmeltingRecipes(BLACK_FUNGUS, Items.BLACK_DYE, 2, 0, 200);
        addSmeltingRecipes(LIGHTBLUE_FUNGUS, Items.LIGHT_BLUE_DYE, 2, 0, 200);
        addSmeltingRecipes(PINK_FUNGUS, Items.PINK_DYE, 2, 0, 200);
        addSmeltingRecipes(MAGENTA_FUNGUS, Items.MAGENTA_DYE, 2, 0, 200);

        // Minerals
        addSmeltingRecipes(RUSSULA_LAZULA, Items.LAPIS_LAZULI, 0f, 200);
        addSmeltingRecipes(GALERINA_AURATA, Items.GOLD_NUGGET, 2, 0f, 200);
        addSmeltingRecipes(XEROCOMUS_FERRUGINEUS, Items.IRON_NUGGET, 2, 0, 200);
        addSmeltingRecipes(AMANITA_CUPREA, Items.RAW_COPPER, 0, 400);
        addSmeltingRecipes(DIAMOND_FUNGUS, Items.DIAMOND, 0, 400);
        addSmeltingRecipes(BOLBITIUS_SILEX, Items.QUARTZ, 0, 200);
    }

    private void addSmeltingRecipes(String ingredientSpecies, Item resultItem, int stackSize, float exp, int cookingTime)
    {
        new FungusCookingRecipeBuilder(ingredientSpecies, new ItemStack(resultItem, stackSize), exp, cookingTime)
                .save(this.output);
    }

    private void addSmeltingRecipes(String ingredientSpecies, Item resultItem, float exp, int cookingTime)
    {
        addSmeltingRecipes(ingredientSpecies, resultItem, 1, exp, cookingTime);
    }

    public static class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
        {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput)
        {
            return new CookingRecipesProvider(provider, recipeOutput);
        }


        @Override
        public String getName()
        {
            return "Mycology Cooking recipes";
        }
    }
}
