package com.simomett.mycologymod.effects.PlayerEffects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.awt.*;

public class GainXPEffect extends MobEffect
{
    public static GainXPEffect instance()
    {
        return new GainXPEffect();
    }

    protected GainXPEffect()
    {
        super(MobEffectCategory.NEUTRAL, Color.GREEN.hashCode());
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier)
    {
        if(entity instanceof Player player)
            player.giveExperiencePoints(amplifier+1);

        return true;
    }

    @Override
    public boolean isInstantenous()
    {
        return false;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int remainingTicks, int level)
    {
        return remainingTicks % 3 == 0;
    }
}
