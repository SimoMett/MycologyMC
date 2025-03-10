package com.simomett.mycologymod.genetics.gene;

import java.util.Random;

public class FloatGene extends Gene<Float>
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
        if((value - minVal) < .1)
            value+=.1f;
        else if ((maxVal - value) < .1)
            value-=.1f;
        else
            value += new Random().nextBoolean()? .1f: -0.1f;
    }
}
