package com.mettsmirnov.mycology.effects.PlayerEffects;

import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

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

    @Override
    public boolean isInstantenous()
    {
        SoundEvents.TOTEM_USE
        return false;
    }
}
