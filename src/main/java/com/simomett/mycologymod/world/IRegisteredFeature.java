package com.simomett.mycologymod.world;

import net.minecraft.world.level.levelgen.feature.Feature;

public interface IRegisteredFeature<T extends Feature<?>>
{
    T get();
}
