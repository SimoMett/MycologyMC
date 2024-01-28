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
        mutations = mutations.stream()
                .filter(m -> (m.getSpecies1().equals(species1.getField(FungusDataModel.SPECIES)) && m.getSpecies2().equals(species2.getField(FungusDataModel.SPECIES)))
                            || (m.getSpecies1().equals(species2.getField(FungusDataModel.SPECIES)) && m.getSpecies2().equals(species1.getField(FungusDataModel.SPECIES))))
                .toList();

        if (mutations.isEmpty())
        {
            //normal crossbreeding
            for(String trait : traitsDictionary)
            {
                Object o = random.nextBoolean() ? species1.getField(trait) : species1.getField(trait, IFungusData.GeneType.RECESSIVE);
                offspring.setField(trait, IFungusData.GeneType.DOMINANT, o);
                Object p = random.nextBoolean() ? species2.getField(trait) : species2.getField(trait, IFungusData.GeneType.RECESSIVE);
                offspring.setField(trait, IFungusData.GeneType.RECESSIVE, p);
            }
        }
        else
        {
            //pick one (or the only one) mutation and create FungusDataModel of it
            //TODO create a probability distribution with the 'chance' parameter of each mutation recipe
            MutationRecipe mutationRecipe = mutations.get(random.nextInt(mutations.size()));
            offspring = new FungusDataModel();
            offspring.loadFrom(FungusSpeciesList.INSTANCE.get(mutationRecipe.getResultSpecies()));
        }
        return offspring;
    }
}
