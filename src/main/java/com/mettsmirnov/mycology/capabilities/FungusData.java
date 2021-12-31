package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class FungusData implements IFungusData, INBTSerializable<CompoundTag>
{
    @Override
    public int[] getColors() {
        return new int[4];
    }

    @Override
    public CompoundTag serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }

}