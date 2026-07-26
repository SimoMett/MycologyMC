package com.simomett.mycologymod.effects.player;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.awt.*;

public class SensingEffect extends MobEffect
{
    public static SensingEffect create()
    {
        return new SensingEffect();
    }

    protected SensingEffect()
    {
        super(MobEffectCategory.BENEFICIAL, Color.WHITE.hashCode());
    }

    @Override
    public boolean isInstantenous()
    {
        return false;
    }
}
