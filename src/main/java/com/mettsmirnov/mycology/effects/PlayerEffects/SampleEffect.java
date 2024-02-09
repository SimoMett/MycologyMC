package com.mettsmirnov.mycology.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.awt.*;

public class SampleEffect extends MobEffect
{
    public static SampleEffect create()
    {
        return new SampleEffect();
    }

    protected SampleEffect()
    {
        super(MobEffectCategory.NEUTRAL, Color.CYAN.hashCode());
    }
}
