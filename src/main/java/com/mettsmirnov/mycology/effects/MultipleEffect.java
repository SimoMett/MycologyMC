package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;

import java.util.List;

public class MultipleEffect implements IFungusEffect
{

    public MultipleEffect(List<MobEffect> mobEffectList)
    {

    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {

    }

    @Override
    public void applyEffectToLevel(LevelReader level, BlockPos origin, int radius)
    {

    }
}
