package com.mettsmirnov.mycology.recipes.breeding;

import java.util.ArrayList;
import java.util.List;

public class BreedingRecipeRegistry
{
    private static List<FungusBreedingRecipe> recipes = new ArrayList<FungusBreedingRecipe>();

    public static void addRecipe(FungusBreedingRecipe recipe)
    {
        recipes.add(recipe);
    }
}
