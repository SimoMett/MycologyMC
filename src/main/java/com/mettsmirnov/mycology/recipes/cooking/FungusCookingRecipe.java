package com.mettsmirnov.mycology.recipes.cooking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class FungusCookingRecipe implements Recipe<Container>
{
    public String speciesIngredient;
    public float experience;
    public int cookingTime;
    public ItemStack result;

    public FungusCookingRecipe(String speciesIngredient, float experience, int cookingTime, ItemStack result)
    {
        this.speciesIngredient = speciesIngredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.result = result;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        return false;
    }

    @Override
    public ItemStack assemble(Container p_44001_) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_)
    {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return null;
    }

    @Override
    public ResourceLocation getId()
    {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModCookingRecipes.FUNGUS_COOKING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType()
    {
        return RecipeType.SMELTING;
    }
}
