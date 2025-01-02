package com.simomett.mycologymod.genetics;

import java.io.Serializable;

public abstract class AbstractGene<T> implements Serializable
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

    @Override
    public String toString()
    {
        return value.toString();
    }
}