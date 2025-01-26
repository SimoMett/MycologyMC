package com.simomett.mycologymod.datagen.recipe.crafting;

import com.simomett.mycologymod.datagen.recipe.cooking.FungusCookingRecipeBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.*;

public class FungusShapelessRecipesProvider extends RecipeProvider
{

    protected FungusShapelessRecipesProvider(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @Override
    protected void buildRecipes()
    {
        addCraftingRecipe(SLIME_FUNGUS, Items.SLIME_BALL, 2);
        addCraftingRecipe(XEROCOMUS_FERRUGINEUS, Items.BONE_MEAL);
    }

    private void addCraftingRecipe(String ingredientSpecies, Item resultItem, int stackSize)
    {
        //FIXME stackSize is not saved
        new FungusShapelessRecipeBuilder(ingredientSpecies, new ItemStack(resultItem, stackSize))
                .save(this.output);
    }

    private void addCraftingRecipe(String ingredientSpecies, Item resultItem)
    {
        addCraftingRecipe(ingredientSpecies, resultItem, 1);
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
            return new FungusShapelessRecipesProvider(provider, recipeOutput);
        }


        @Override
        public String getName()
        {
            return "Mycology Crafting recipes";
        }
    }
}
