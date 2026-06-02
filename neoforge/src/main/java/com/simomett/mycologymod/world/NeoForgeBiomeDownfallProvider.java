package com.simomett.mycologymod.world;

import com.simomett.mycologymod.genetics.IBiomeDownfallProvider;
import net.minecraft.world.level.biome.Biome;

public class NeoForgeBiomeDownfallProvider implements IBiomeDownfallProvider
{
    @Override
    public float get(Biome biome)
    {
        return biome.getModifiedClimateSettings().downfall();
    }
}
