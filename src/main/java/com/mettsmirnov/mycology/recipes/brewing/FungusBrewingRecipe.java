package com.mettsmirnov.mycology.recipes.brewing;

import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
    public boolean isIngredient(ItemStack ingredient)
    {
        return ingredient.is(ModItems.COLORED_CRIMSON_FUNGUS.get());
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        ItemStack result = super.getOutput(input, ingredient);
        return new ItemStack(Items.ANDESITE,potionLevel);
    }
}
