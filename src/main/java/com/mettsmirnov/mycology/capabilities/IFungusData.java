package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFungusData extends INBTSerializable<CompoundTag>
{
    public int[] getColors();
}
