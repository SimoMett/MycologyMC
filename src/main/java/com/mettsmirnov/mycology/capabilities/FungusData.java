package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;

public class FungusData implements IFungusData
{
    @Override
    public int[] getColors() {
        return new int[4];
    }

    @Override
    public CompoundTag serializeNBT()
    {

        return new CompoundTag();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {

    }

}