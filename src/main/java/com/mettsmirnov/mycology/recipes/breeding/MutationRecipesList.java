package com.mettsmirnov.mycology.recipes.breeding;

import java.util.ArrayList;
import java.util.List;

public class MutationRecipesList
{
    private static final List<MutationRecipe> recipes = new ArrayList<>();

    public static void addRecipe(MutationRecipe recipe)
    {
        recipes.add(recipe);
    }
}
