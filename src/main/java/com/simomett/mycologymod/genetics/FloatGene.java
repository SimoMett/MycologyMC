package com.simomett.mycologymod.genetics;

import java.util.Random;

public class FloatGene extends AbstractGene<Float>
{
    private final Float minVal, maxVal;
    public FloatGene(Float value, Float minVal, Float maxVal)
    {
        super(value);
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    @Override
    public final void randomMutate()
    {
        if((value - minVal) < 1)
            value+=1;
        else if ((maxVal - value)<1)
            value-=1;
        else
            value += new Random().nextBoolean()? 1: -1;
    }
}
