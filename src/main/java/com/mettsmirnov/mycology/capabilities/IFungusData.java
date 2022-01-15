package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFungusData extends INBTSerializable<CompoundTag>
{
    enum GeneType
    {
        DOMINANT,
        RECESSIVE
    }

    public Object getField(String key, GeneType type);
    public int[] getColors();
    public void setColors(int [] colors);
}
