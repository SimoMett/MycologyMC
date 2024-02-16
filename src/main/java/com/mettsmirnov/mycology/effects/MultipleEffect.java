package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class MultipleEffect extends FungusEffect
{
    private final List<MobEffect> mobEffects;
    public MultipleEffect(String effectName, List<MobEffect> mobEffectList)
    {
        super(effectName);
        this.mobEffects = mobEffectList;
    }

    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffects != null)
        {
            for(MobEffect mobEffect : mobEffects)
                entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
        }
    }

    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {

    }
}
