package com.simomett.mycologymod.genetics;

public abstract class AbstractGene<T>
{
    protected T value;

    public AbstractGene(T value)
    {
        this.value = value;
    }

    public T value()
    {
        return this.value;
    }

    public abstract void randomMutate();
}