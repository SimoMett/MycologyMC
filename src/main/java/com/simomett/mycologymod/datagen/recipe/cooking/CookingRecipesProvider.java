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
import static com.simomett.mycologymod.items.ModItems.*;

public class CookingRecipesProvider extends RecipeProvider
{
    protected CookingRecipesProvider(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @Override
    protected void buildRecipes()
    {
        // Default recipes
        addDefaultSmeltingRecipe(BOLETUS_EDULIS, COOKED_CRIMSON_FUNGUS.get());
        addDefaultSmeltingRecipe(AGARICUS_CAMPESTRIS, COOKED_WARPED_FUNGUS.get());
        addDefaultSmeltingRecipe(AMANITA_MUSCARIA, COOKED_POISONOUS_WARPED_FUNGUS.get());
        addDefaultSmeltingRecipe(LACTARIUS_PROLEFERENS, COOKED_WARPED_FUNGUS.get());
        addDefaultSmeltingRecipe(LECCINUM_VERSIPELLE, COOKED_WARPED_FUNGUS.get());
        addDefaultSmeltingRecipe(SUILLUS_GRANULATUS, COOKED_WARPED_FUNGUS.get());
        addDefaultSmeltingRecipe(FERTILIZING_FUNGUS, COOKED_WARPED_FUNGUS.get());
        addDefaultSmeltingRecipe(CHALCIPORUS_PIPERATUS, COOKED_CRIMSON_FUNGUS.get());
        addDefaultSmeltingRecipe(AMANITA_PHALLOIDES, COOKED_POISONOUS_CRIMSON_FUNGUS.get());
        addDefaultSmeltingRecipe(HYGROPHORUS_NIVEUS, COOKED_CRIMSON_FUNGUS.get());

        // Materials
        addDefaultSmeltingRecipe(POLYPORUS_LIGNEUS, Items.CHARCOAL);
        addDefaultSmeltingRecipe(COAL_FUNGUS, Items.COAL);
    }

    private void addDefaultSmeltingRecipe(String ingredientSpecies, Item resultItem)
    {
        addDefaultSmeltingRecipe(ingredientSpecies, resultItem, 1);
    }

    private void addDefaultSmeltingRecipe(String ingredientSpecies, Item resultItem, int stackSize)
    {
        addSmeltingRecipe(ingredientSpecies, resultItem, stackSize, .35f, 200);
    }

    private void addSmeltingRecipe(String ingredientSpecies, Item resultItem, int stackSize, float exp, int cookingTime)
    {
        new FungusCookingRecipeBuilder(ingredientSpecies, new ItemStack(resultItem, stackSize), exp, cookingTime)
                .save(this.output);
    }

    private void addSmeltingRecipe(String ingredientSpecies, Item resultItem, float exp, int cookingTime)
    {
        addSmeltingRecipe(ingredientSpecies, resultItem, 1, exp, cookingTime);
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
