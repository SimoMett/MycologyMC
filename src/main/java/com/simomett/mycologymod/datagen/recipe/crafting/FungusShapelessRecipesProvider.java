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
        // Colors
        addCraftingRecipe(YELLOW_FUNGUS, Items.YELLOW_DYE, 2);
        addCraftingRecipe(ORANGE_FUNGUS, Items.ORANGE_DYE, 2);
        addCraftingRecipe(AMANITA_RUBRA, Items.RED_DYE, 2);
        addCraftingRecipe(OVULUS_VIOLACEUS, Items.PURPLE_DYE, 2);
        addCraftingRecipe(CYAN_FUNGUS, Items.CYAN_DYE, 2);
        addCraftingRecipe(BLUE_FUNGUS, Items.BLUE_DYE, 2);
        addCraftingRecipe(LACTARIUS_VIRENS, Items.GREEN_DYE, 2);
        addCraftingRecipe(WHITE_FUNGUS, Items.WHITE_DYE, 2);
        addCraftingRecipe(GREY_FUNGUS, Items.GRAY_DYE, 2);
        addCraftingRecipe(LIME_FUNGUS, Items.LIME_DYE, 2);
        addCraftingRecipe(LIGHTGREY_FUNGUS, Items.LIGHT_GRAY_DYE, 2);
        addCraftingRecipe(BLACK_FUNGUS, Items.BLACK_DYE, 2);
        addCraftingRecipe(LIGHTBLUE_FUNGUS, Items.LIGHT_BLUE_DYE, 2);
        addCraftingRecipe(PINK_FUNGUS, Items.PINK_DYE, 2);
        addCraftingRecipe(MAGENTA_FUNGUS, Items.MAGENTA_DYE, 2);
        addCraftingRecipe(BROWN_FUNGUS, Items.BROWN_DYE, 2);

        // Materials
        addCraftingRecipe(SLIME_FUNGUS, Items.SLIME_BALL);
        addCraftingRecipe(XEROCOMUS_FERRUGINEUS, Items.BONE_MEAL);
    }

    private void addCraftingRecipe(String ingredientSpecies, Item resultItem, int stackSize)
    {
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
