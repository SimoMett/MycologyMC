package com.simomett.mycologymod.datagen.recipe.blasting;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.*;
import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.BOLBITIUS_SILEX;

public class BlastingRecipesProvider extends RecipeProvider
{
    protected BlastingRecipesProvider(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @Override
    protected void buildRecipes()
    {
        // Minerals
        addBlastingRecipe(RUSSULA_LAZULA, Items.LAPIS_LAZULI, 0f, 200);
        addBlastingRecipe(GALERINA_AURATA, Items.GOLD_NUGGET, 2, 0f, 200);
        addBlastingRecipe(XEROCOMUS_FERRUGINEUS, Items.IRON_NUGGET, 2, 0, 200);
        addBlastingRecipe(AMANITA_CUPREA, Items.RAW_COPPER, 0, 400);
        addBlastingRecipe(DIAMOND_FUNGUS, Items.DIAMOND, 0, 400);
        addBlastingRecipe(BOLBITIUS_SILEX, Items.QUARTZ, 0, 200);
    }

    private void addBlastingRecipe(String ingredientSpecies, Item resultItem, int stackSize, float exp, int cookingTime)
    {
        new FungusBlastingRecipeBuilder(ingredientSpecies, new ItemStack(resultItem, stackSize), exp, cookingTime)
                .save(this.output);
    }

    private void addBlastingRecipe(String ingredientSpecies, Item resultItem, float exp, int cookingTime)
    {
        addBlastingRecipe(ingredientSpecies, resultItem, 1, exp, cookingTime);
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
            return new BlastingRecipesProvider(provider, recipeOutput);
        }


        @Override
        public String getName()
        {
            return "Mycology Blasting recipes";
        }
    }
}
