package com.simomett.mycologymod.genetics;

import net.minecraft.world.level.biome.Biome;

public interface IBiomeInfoGetter
{
    default float getBaseTemperature(Biome biome)
    {
        return biome.getBaseTemperature();
    }

    float getDownfall(Biome biome);
}
