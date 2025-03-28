package com.simomett.mycologymod.recipes.breeding;

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

    public String getSpecies1()
    {
        return species1;
    }

    public String getSpecies2()
    {
        return species2;
    }

    public String getResultSpecies()
    {
        return resultSpecies;
    }

    public float getChance()
    {
        return chance;
    }
}
