package com.mettsmirnov.mycology.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class TeleportingEffect extends MobEffect
{
    public static TeleportingEffect instance() { return new TeleportingEffect(); }

    protected TeleportingEffect() {
        super(MobEffectCategory.NEUTRAL, 0);
    }
}
