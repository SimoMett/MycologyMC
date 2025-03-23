package com.simomett.mycologymod.compatibility.rei;

import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.brewing.DefaultBrewingDisplay;

public class PotionsDisplay extends DefaultBrewingDisplay
{
    public PotionsDisplay(FungusBrewingRecipe recipe)
    {
        super(getInput(recipe), getReactant(recipe), getOutput(recipe));
    }

    private static EntryIngredient getOutput(FungusBrewingRecipe recipe)
    {
        return EntryIngredients.of(recipe.result);
    }

    private static EntryIngredient getReactant(FungusBrewingRecipe recipe)
    {
        return EntryIngredients.of(FungusSpeciesList.INSTANCE.get(recipe.speciesName).defaultItemStack());
    }

    private static EntryIngredient getInput(FungusBrewingRecipe recipe)
    {
        return EntryIngredients.of(recipe.inputItem);
    }
}
