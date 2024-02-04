package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;

public interface IFungusEffect
{
    final int numOfTicks = 100; //this value is hardcoded and should not be configurable.

    String getEffectName();
    void applyEffectToEntity(LivingEntity entity);
    void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius);
}
