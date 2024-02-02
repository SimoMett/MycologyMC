package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public interface IFungusEffect
{
    final int numOfTicks = 100; //this value is hardcoded and should not be configurable.

    String getEffectName();
    void applyEffectToEntity(LivingEntity entity);
    void applyEffectToLevel(LevelAccessor level, BlockPos origin, int radius);
}
