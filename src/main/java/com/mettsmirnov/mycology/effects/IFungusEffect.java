package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;

public interface IFungusEffect {
    void applyEffectToEntity(LivingEntity entity);

    void applyEffectToLevel(LevelReader level, BlockPos origin, int radius);
}
