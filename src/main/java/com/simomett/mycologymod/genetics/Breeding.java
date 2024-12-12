package com.simomett.mycologymod.genetics;


import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.recipes.breeding.MutationRecipe;
import com.simomett.mycologymod.recipes.breeding.MutationRecipesList;

import java.util.List;
import java.util.Random;

import static com.simomett.mycologymod.genetics.FungusTraits.traitsDictionary;

public class Breeding
{
    //TODO move into FungusGenoma
    public static FungusGenoma crossBreed(FungusGenoma species1, FungusGenoma species2)
    {
        FungusGenoma offspring = new FungusGenoma();
        Random random = new Random();
        List<MutationRecipe> mutations = MutationRecipesList.getList();

        //get all the mutations between species1 and species2
        mutations = mutations.stream()
                .filter(m -> (m.getSpecies1().equals(species1.getField(FungusGenoma.SPECIES)) && m.getSpecies2().equals(species2.getField(FungusGenoma.SPECIES)))
                            || (m.getSpecies1().equals(species2.getField(FungusGenoma.SPECIES)) && m.getSpecies2().equals(species1.getField(FungusGenoma.SPECIES))))
                .toList();

        if (!mutations.isEmpty())
        {
            int randomRecipeId = random.nextInt(mutations.size());
            MutationRecipe randomMutation = mutations.get(randomRecipeId);
            boolean performMutation = random.nextFloat(0f, 1f) < randomMutation.getChance();
            if (performMutation)
            {
                offspring = new FungusGenoma(FungusSpeciesList.INSTANCE.get(randomMutation.getResultSpecies()));
                return offspring;
            }
        }
        //otherwise normal crossbreeding
        for(String trait : traitsDictionary)
        {
            String o = random.nextBoolean() ? species1.getField(trait) : species1.getField(trait, FungusGenoma.GeneType.RECESSIVE);
            offspring.setField(trait, FungusGenoma.GeneType.DOMINANT, o);
            String p = random.nextBoolean() ? species2.getField(trait) : species2.getField(trait, FungusGenoma.GeneType.RECESSIVE);
            offspring.setField(trait, FungusGenoma.GeneType.RECESSIVE, p);
        }
        return offspring;
    }
}