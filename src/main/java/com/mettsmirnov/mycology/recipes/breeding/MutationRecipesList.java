package com.mettsmirnov.mycology.recipes.breeding;

import java.util.ArrayList;
import java.util.List;

public class MutationRecipesList
{
    private static List<MutationRecipe> recipes = new ArrayList<MutationRecipe>();

    public static void addRecipe(MutationRecipe recipe)
    {
        recipes.add(recipe);
    }
}
