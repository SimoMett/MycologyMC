package com.mettsmirnov.mycology.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.VanillaBrewingRecipe;

public class FungusBrewingRecipe extends VanillaBrewingRecipe
{
    @Override
    public boolean isInput(ItemStack input)
    {
        return false;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient)
    {
        return false;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        return null;
    }
}
