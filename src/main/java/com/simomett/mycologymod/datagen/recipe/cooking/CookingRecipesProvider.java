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

        // Colors
        addDefaultSmeltingRecipe(YELLOW_FUNGUS, Items.YELLOW_DYE, 2);
        addDefaultSmeltingRecipe(ORANGE_FUNGUS, Items.ORANGE_DYE, 2);
        addDefaultSmeltingRecipe(AMANITA_RUBRA, Items.RED_DYE, 2);
        addDefaultSmeltingRecipe(OVULUS_VIOLACEUS, Items.PURPLE_DYE, 2);
        addDefaultSmeltingRecipe(CYAN_FUNGUS, Items.CYAN_DYE, 2);
        addDefaultSmeltingRecipe(BLUE_FUNGUS, Items.BLUE_DYE, 2);
        addDefaultSmeltingRecipe(LACTARIUS_VIRENS, Items.GREEN_DYE, 2);
        addDefaultSmeltingRecipe(WHITE_FUNGUS, Items.WHITE_DYE, 2);
        addDefaultSmeltingRecipe(GREY_FUNGUS, Items.GRAY_DYE, 2);
        addDefaultSmeltingRecipe(LIME_FUNGUS, Items.LIME_DYE, 2);
        addDefaultSmeltingRecipe(LIGHTGREY_FUNGUS, Items.LIGHT_GRAY_DYE, 2);
        addDefaultSmeltingRecipe(BLACK_FUNGUS, Items.BLACK_DYE, 2);
        addDefaultSmeltingRecipe(LIGHTBLUE_FUNGUS, Items.LIGHT_BLUE_DYE, 2);
        addDefaultSmeltingRecipe(PINK_FUNGUS, Items.PINK_DYE, 2);
        addDefaultSmeltingRecipe(MAGENTA_FUNGUS, Items.MAGENTA_DYE, 2);
        addDefaultSmeltingRecipe(BROWN_FUNGUS, Items.BROWN_DYE, 2);

        // Materials
        addDefaultSmeltingRecipe(POLYPORUS_LIGNEUS, Items.CHARCOAL);
        addDefaultSmeltingRecipe(COAL_FUNGUS, Items.COAL);
        addDefaultSmeltingRecipe(BONEBLOCK_FUNGUS, Items.BONE_MEAL, 2);
        addDefaultSmeltingRecipe(SLIME_FUNGUS, Items.SLIME_BALL);
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
