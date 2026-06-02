package com.simomett.mycologymod.world.features;

import com.simomett.mycologymod.world.IRegisteredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;

public class NeoForgeFeature<T extends Feature<?>> implements IRegisteredFeature<T>
{
    private final DeferredHolder<Feature<?>,T> deferredHolder;
    public NeoForgeFeature(DeferredHolder<Feature<?>,T> deferredHolder)
    {
        this.deferredHolder = deferredHolder;
    }

    public T get()
    {
        return deferredHolder.get();
    }
}
