package com.simomett.mycologymod.genetics;

public class StringGene extends AbstractGene<String>
{

    public StringGene(String value) {
        super(value);
    }

    @Override
    public final void randomMutate() {}
}
