package com.simomett.mycologymod.recipes.breeding;

import java.util.ArrayList;
import java.util.List;

public class MutationRecipesList
{
    private static final List<MutationRecipe> recipes = new ArrayList<>();

    public static void addRecipe(MutationRecipe recipe)
    {
        recipes.add(recipe);
    }

    public static ArrayList<MutationRecipe> getList()
    {
        return new ArrayList<>(recipes);
    }
}
