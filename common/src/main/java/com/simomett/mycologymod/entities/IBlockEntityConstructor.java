package com.simomett.mycologymod.entities;

public interface IBlockEntityConstructor<T, U, R>
{
    R apply(T var1, U var2);
}
