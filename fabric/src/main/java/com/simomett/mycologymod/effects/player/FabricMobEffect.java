package com.simomett.mycologymod.effects.player;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

public class FabricMobEffect<T extends MobEffect> implements IRegisteredMobEffect<T>
{
    private final Holder.Reference<MobEffect> effect;

    public FabricMobEffect(Holder.Reference<MobEffect> mobEffectReference)
    {
        this.effect = mobEffectReference;
    }

    @Override
    public Holder<MobEffect> holder()
    {
        return effect;
    }
}
