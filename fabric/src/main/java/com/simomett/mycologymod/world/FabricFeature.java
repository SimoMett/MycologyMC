package com.simomett.mycologymod.world;

import net.minecraft.world.level.levelgen.feature.Feature;

public class FabricFeature<T extends Feature<?>> implements IRegisteredFeature<T>
{
    private final T feature;
    public FabricFeature(T feature)
    {
        this.feature = feature;
    }

    @Override
    public T get()
    {
        return feature;
    }
}
