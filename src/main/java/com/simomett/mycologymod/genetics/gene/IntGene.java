package com.simomett.mycologymod.genetics.gene;

import java.util.Random;

public class IntGene extends Gene<Integer>
{
    private final Integer minVal, maxVal;
    public IntGene(Integer value, Integer minVal, Integer maxVal)
    {
        super(value);
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    @Override
    public final void randomMutate()
    {
        if(value.equals(minVal))
            value+=1;
        else if (value.equals(maxVal))
            value-=1;
        else
            value += new Random().nextBoolean()? 1: -1;
    }
}
