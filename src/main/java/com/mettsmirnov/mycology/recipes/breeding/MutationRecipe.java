package com.mettsmirnov.mycology.recipes.breeding;

public class MutationRecipe
{
    private final String species1;
    private final String species2;
    private final String resultSpecies;
    private final float chance;
    public MutationRecipe(String species1, String species2, String resultSpecies, float chance)
    {
        this.species1 = species1;
        this.species2 = species2;
        this.resultSpecies = resultSpecies;
        this.chance = chance;
    }
}
