package com.simomett.mycologymod.effects.player;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;

public class NeoForgeMobEffect<T extends MobEffect> implements IRegisteredMobEffect<T>
{
    private final DeferredHolder<MobEffect, ? extends MobEffect> deferredHolder;

    public <I extends T> NeoForgeMobEffect(DeferredHolder<MobEffect,I> effect)
    {
        this.deferredHolder = effect;
    }

    @Override
    public Holder<MobEffect> holder()
    {
        return deferredHolder;
    }
}
