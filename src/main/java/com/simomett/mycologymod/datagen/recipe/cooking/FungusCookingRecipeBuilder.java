package com.simomett.mycologymod.datagen.recipe.cooking;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

public class FungusCookingRecipeBuilder implements RecipeBuilder
{
    protected final String speciesIngredient;
    protected final ItemStack result;
    protected final float exp;
    protected final int cookingTime;

    public FungusCookingRecipeBuilder(String speciesIngredient, ItemStack result, float experience, int cookingTime)
    {
        this.speciesIngredient = speciesIngredient;
        this.result = result;
        this.exp = experience;
        this.cookingTime = cookingTime;
    }

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion)
    {
        return this;
    }

    @Override
    public FungusCookingRecipeBuilder group(@Nullable String s)
    {
        return this;
    }

    @Override
    public Item getResult()
    {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resKey)
    {
        output.accept(
                ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(
                        MycologyMod.MODID,
                        speciesIngredient.toLowerCase().replace(" ", "_"))),
                new FungusCookingRecipe(speciesIngredient, result, exp, cookingTime),
                null);
    }
}
