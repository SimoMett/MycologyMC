package com.simomett.mycologymod.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.awt.*;

public class LastChanceEffect extends MobEffect
{
    public static LastChanceEffect instance()
    {
        return new LastChanceEffect();
    }

    protected LastChanceEffect()
    {
        super(MobEffectCategory.BENEFICIAL, Color.YELLOW.hashCode());
    }
}
