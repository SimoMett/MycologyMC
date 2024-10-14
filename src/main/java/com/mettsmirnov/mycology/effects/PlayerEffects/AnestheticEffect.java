package com.mettsmirnov.mycology.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class AnestheticEffect extends MobEffect
{
    public static AnestheticEffect instance(){ return new AnestheticEffect(); }
    protected AnestheticEffect() {
        super(MobEffectCategory.NEUTRAL, 0x8F123E);
    }
}
