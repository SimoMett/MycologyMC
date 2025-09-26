package com.simomett.mycologymod.world;

import com.simomett.mycologymod.genetics.IBiomeDownfallProvider;
import com.simomett.mycologymod.mixins.IBiomeDownfallGetter;
import net.minecraft.world.level.biome.*;

public class FabricBiomeDownfallProvider implements IBiomeDownfallProvider
{
    @Override
    public float get(Biome biome)
    {
        return ((IBiomeDownfallGetter) ((Object) (biome))).getDownfall();
    }
}
