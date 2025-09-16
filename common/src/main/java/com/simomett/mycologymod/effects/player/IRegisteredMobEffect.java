package com.simomett.mycologymod.effects.player;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

public interface IRegisteredMobEffect<T extends MobEffect>
{
    Holder<MobEffect> holder();
}
