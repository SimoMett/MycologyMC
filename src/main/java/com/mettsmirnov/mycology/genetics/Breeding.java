package com.mettsmirnov.mycology.genetics;

import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.recipes.breeding.MutationRecipe;
import com.mettsmirnov.mycology.recipes.breeding.MutationRecipesList;
import org.jline.utils.Log;

import java.util.List;
import java.util.Random;

import static com.mettsmirnov.mycology.genetics.FungusTraits.traitsDictionary;

public class Breeding
{
    public static FungusDataModel crossBreed(FungusDataModel species1, FungusDataModel species2)
    {
        FungusDataModel offspring = new FungusDataModel();
        Random random = new Random();
        List<MutationRecipe> mutations = MutationRecipesList.getList();

        //get all the mutations between species1 and species2
        mutations = mutations.stream()
                .filter(m -> (m.getSpecies1().equals(species1.getField(FungusDataModel.SPECIES)) && m.getSpecies2().equals(species2.getField(FungusDataModel.SPECIES)))
                            || (m.getSpecies1().equals(species2.getField(FungusDataModel.SPECIES)) && m.getSpecies2().equals(species1.getField(FungusDataModel.SPECIES))))
                .toList();

        if (!mutations.isEmpty())
        {
            int randomRecipeId = random.nextInt(mutations.size());
            MutationRecipe randomMutation = mutations.get(randomRecipeId);
            boolean performMutation = random.nextFloat(0f, 1f) < randomMutation.getChance();
            if (performMutation)
            {
                offspring = new FungusDataModel();
                offspring.loadFrom(FungusSpeciesList.INSTANCE.get(randomMutation.getResultSpecies()));
                return offspring;
            }
        }
        //otherwise normal crossbreeding
        for(String trait : traitsDictionary)
        {
            Object o = random.nextBoolean() ? species1.getField(trait) : species1.getField(trait, IFungusData.GeneType.RECESSIVE);
            offspring.setField(trait, IFungusData.GeneType.DOMINANT, o);
            Object p = random.nextBoolean() ? species2.getField(trait) : species2.getField(trait, IFungusData.GeneType.RECESSIVE);
            offspring.setField(trait, IFungusData.GeneType.RECESSIVE, p);
        }
        return offspring;
    }
}
