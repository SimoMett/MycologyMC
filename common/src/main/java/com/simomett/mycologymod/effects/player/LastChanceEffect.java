package com.simomett.mycologymod.effects.player;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.component.DeathProtection;

import java.awt.*;

public class LastChanceEffect extends MobEffect
{
    public static DeathProtection LAST_CHANCE = new DeathProtection(DeathProtection.TOTEM_OF_UNDYING.deathEffects());
    public static LastChanceEffect instance()
    {
        return new LastChanceEffect();
    }

    protected LastChanceEffect()
    {
        super(MobEffectCategory.BENEFICIAL, Color.YELLOW.hashCode());
    }
}
