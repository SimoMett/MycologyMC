package com.mettsmirnov.mycology.genetics;

import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import org.jline.utils.Log;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static com.mettsmirnov.mycology.genetics.FungusTraits.traitsDictionary;

public class Breeding
{
    public static FungusDataModel crossBreed(FungusDataModel species1, FungusDataModel species2)
    {
        FungusDataModel offspring = new FungusDataModel();
        ArrayList<Objects> mutations = new ArrayList<>(); //TODO find all possible mutations that can derive from species1 and species2
        if (mutations.isEmpty())
        {
            Random random = new Random();

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
            //TODO instantiate new species
            Log.info("Mutation has occurred!");
            offspring = new FungusDataModel();
        }
        return offspring;
    }
}
