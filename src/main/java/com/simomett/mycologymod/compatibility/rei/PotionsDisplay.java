package com.simomett.mycologymod.compatibility.rei;

import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.brewing.DefaultBrewingDisplay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

import java.util.List;

public class PotionsDisplay extends DefaultBrewingDisplay
{
    public PotionsDisplay(FungusBrewingRecipe recipe)
    {
        super(getInput(), getReactant(recipe), getOutput(recipe));
    }

    private static EntryIngredient getOutput(FungusBrewingRecipe recipe)
    {
        return EntryIngredients.of(PotionContents.createItemStack(Items.POTION, recipe.resultPotion));
    }

    private static EntryIngredient getReactant(FungusBrewingRecipe recipe)
    {
        return EntryIngredients.of(FungusSpeciesList.INSTANCE.get(recipe.species).defaultItemStack());
    }

    private static EntryIngredient getInput()
    {
        ItemStack[] items = {
                PotionContents.createItemStack(Items.POTION, Potions.AWKWARD),
                PotionContents.createItemStack(Items.SPLASH_POTION, Potions.AWKWARD),
                PotionContents.createItemStack(Items.LINGERING_POTION, Potions.AWKWARD)};
        return EntryIngredients.ofItemStacks(List.of(items));
    }
}
