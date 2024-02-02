package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;

import java.util.List;

public class MultipleEffect implements IFungusEffect
{
    private final String effectName;
    private final List<MobEffect> mobEffects;
    public MultipleEffect(String effectName)
    {
        this.effectName = effectName;
        this.mobEffects = null;
    }

    public MultipleEffect(String effectName, List<MobEffect> mobEffectList)
    {
        this.effectName = effectName;
        this.mobEffects = mobEffectList;
    }

    @Override
    public String getEffectName()
    {
        return effectName;
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffects != null)
        {
            for(MobEffect mobEffect : mobEffects)
                entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
        }
    }

    @Override
    public void applyEffectToLevel(LevelReader level, BlockPos origin, int radius)
    {

    }
}
