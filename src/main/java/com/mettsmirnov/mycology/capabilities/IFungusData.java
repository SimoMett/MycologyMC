package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.data.FungusTraits;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

@AutoRegisterCapability
public interface IFungusData extends INBTSerializable<CompoundTag>
{
    enum GeneType
    {
        DOMINANT,
        RECESSIVE
    }

    public Object getField(String key, GeneType type);
    public void loadFrom(FungusTraits dominant, FungusTraits recessive);
    public int[] getColors();
    public void setColors(int [] colors);
}
