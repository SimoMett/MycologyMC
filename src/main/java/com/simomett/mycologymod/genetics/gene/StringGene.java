package com.simomett.mycologymod.genetics.gene;

public class StringGene extends Gene<String>
{

    public StringGene(String value) {
        super(value);
    }

    @Override
    public final void randomMutate() {}
}
