package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.function.TriConsumer;

public class LevelOnlyEffect extends FungusEffect
{
    private final TriConsumer<ServerLevel, BlockPos, AABB> consumer;

    public LevelOnlyEffect(String effectName, TriConsumer<ServerLevel, BlockPos, AABB> consumer)
    {
        super(effectName);
        this.consumer = consumer;
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity) {}

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        if (consumer != null)
            consumer.accept(level, origin, getAABB(origin, radius));
    }
}
