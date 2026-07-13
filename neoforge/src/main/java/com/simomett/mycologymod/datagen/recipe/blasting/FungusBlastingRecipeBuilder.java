package com.simomett.mycologymod.datagen.recipe.blasting;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.datagen.recipe.cooking.FungusCookingRecipeBuilder;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

public class FungusBlastingRecipeBuilder extends FungusCookingRecipeBuilder
{
    public FungusBlastingRecipeBuilder(String speciesIngredient, ItemStack result, float experience, int cookingTime)
    {
        super(speciesIngredient, result, experience, cookingTime);
    }

    @Override
    public FungusBlastingRecipeBuilder group(@Nullable String s)
    {
        return this;
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resKey)
    {
        output.accept(
                ResourceKey.create(Registries.RECIPE,
                        Identifier.fromNamespaceAndPath(Constants.MOD_ID, "blasting_"+speciesIngredient.toLowerCase().replace(" ", "_"))),
                        new FungusBlastingRecipe(speciesIngredient, new Recipe.CommonInfo(true), new AbstractCookingRecipe.CookingBookInfo(CookingBookCategory.MISC, ""), result, exp, cookingTime),
                null);
    }
}
