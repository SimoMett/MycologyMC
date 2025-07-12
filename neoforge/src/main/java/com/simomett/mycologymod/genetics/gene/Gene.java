package com.simomett.mycologymod.genetics.gene;

import java.io.Serializable;

public abstract class Gene<T> implements Serializable
{
    protected T value;

    public Gene(T value)
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

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Gene<?> that))
            return false;
        return this.value.equals(that.value);
    }
}