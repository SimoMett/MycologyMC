package com.mettsmirnov.mycology.recipes.brewing;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.VanillaBrewingRecipe;

public class FungusBrewingRecipe extends VanillaBrewingRecipe
{
    String species;//FIXME should be private (testing only)
    private String resultPotion;
    private int potionLevel;

    public FungusBrewingRecipe(String species, String resultPotion, int level)
    {
        this.species=species;
        this.resultPotion=resultPotion;
        potionLevel=level;
    }

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
