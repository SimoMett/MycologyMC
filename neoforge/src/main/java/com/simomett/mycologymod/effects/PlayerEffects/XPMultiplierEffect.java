package com.simomett.mycologymod.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.awt.*;

public class XPMultiplierEffect extends MobEffect
{
    public static XPMultiplierEffect create()
    {
        return new XPMultiplierEffect();
    }

    protected XPMultiplierEffect()
    {
        super(MobEffectCategory.NEUTRAL, Color.GREEN.hashCode());
    }

    /*@Override
    public void applyEffectTick(LivingEntity entity, int level)
    {
        if(entity instanceof Player player)
        {
            player.giveExperiencePoints(level+1);
        }
    }*/

    @Override
    public boolean isInstantenous()
    {
        return false;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int remaningTicks, int level)
    {
        return true;
    }
}
