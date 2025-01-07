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
import static com.simomett.mycologymod.items.ModItems.COOKED_CRIMSON_FUNGUS;
import static com.simomett.mycologymod.items.ModItems.COOKED_WARPED_FUNGUS;

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
        addDefaultSmeltingRecipe(POLYPORUS_LIGNEUS, COOKED_WARPED_FUNGUS.get());

        // Colors
        addSmeltingRecipe(YELLOW_FUNGUS, Items.YELLOW_DYE, 2, 0, 200);
        addSmeltingRecipe(ORANGE_FUNGUS, Items.ORANGE_DYE, 2, 0, 200);
        addSmeltingRecipe(AMANITA_RUBRA, Items.RED_DYE, 2, 0, 200);
        addSmeltingRecipe(OVULUS_VIOLACEUS, Items.PURPLE_DYE, 2, 0, 200);
        addSmeltingRecipe(CYAN_FUNGUS, Items.CYAN_DYE, 2, 0, 200);
        addSmeltingRecipe(BLUE_FUNGUS, Items.BLUE_DYE, 2, 0, 200);
        addSmeltingRecipe(LACTARIUS_VIRENS, Items.GREEN_DYE, 2, 0, 200);
        addSmeltingRecipe(WHITE_FUNGUS, Items.WHITE_DYE, 2, 0, 200);
        addSmeltingRecipe(GREY_FUNGUS, Items.GRAY_DYE, 2, 0, 200);
        addSmeltingRecipe(LIME_FUNGUS, Items.LIME_DYE, 2, 0, 200);
        addSmeltingRecipe(LIGHTGREY_FUNGUS, Items.LIGHT_GRAY_DYE, 2, 0, 200);
        addSmeltingRecipe(BLACK_FUNGUS, Items.BLACK_DYE, 2, 0, 200);
        addSmeltingRecipe(LIGHTBLUE_FUNGUS, Items.LIGHT_BLUE_DYE, 2, 0, 200);
        addSmeltingRecipe(PINK_FUNGUS, Items.PINK_DYE, 2, 0, 200);
        addSmeltingRecipe(MAGENTA_FUNGUS, Items.MAGENTA_DYE, 2, 0, 200);

        // Minerals
        addSmeltingRecipe(RUSSULA_LAZULA, Items.LAPIS_LAZULI, 0f, 200);
        addSmeltingRecipe(GALERINA_AURATA, Items.GOLD_NUGGET, 2, 0f, 200);
        addSmeltingRecipe(XEROCOMUS_FERRUGINEUS, Items.IRON_NUGGET, 2, 0, 200);
        addSmeltingRecipe(AMANITA_CUPREA, Items.RAW_COPPER, 0, 400);
        addSmeltingRecipe(DIAMOND_FUNGUS, Items.DIAMOND, 0, 400);
        addSmeltingRecipe(BOLBITIUS_SILEX, Items.QUARTZ, 0, 200);
    }

    private void addDefaultSmeltingRecipe(String ingredientSpecies, Item resultItem)
    {
        addSmeltingRecipe(ingredientSpecies, resultItem, .35f, 200);
    }

    /*private void addDefaultSmeltingRecipe(String ingredientSpecies, String fungusType)
    {
        ResourceLocation resLoc = ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, fungusType.replace("colored", "cooked"));
        addSmeltingRecipe(ingredientSpecies, BuiltInRegistries.ITEM.get(resLoc).orElseThrow().value(),.35f, 200);
    }*/

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
