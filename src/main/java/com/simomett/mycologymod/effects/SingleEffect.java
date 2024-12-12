package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.function.TriConsumer;

public class SingleEffect extends FungusEffect
{
    private final Holder<MobEffect> mobEffect;
    private final TriConsumer<ServerLevel, BlockPos, AABB> consumer;

    public SingleEffect(String effectName)
    {
        this(effectName, null, null);
    }

    public SingleEffect(String effectName, Holder<MobEffect> mobEffect)
    {
        this(effectName, mobEffect, null);
    }

    public SingleEffect(String effectName, Holder<MobEffect> mobEffect, TriConsumer<ServerLevel, BlockPos, AABB> consumer)
    {
        super(effectName);
        this.mobEffect = mobEffect;
        this.consumer = consumer;
    }

    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffect != null)
            entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
    }

    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        if (consumer != null)
            consumer.accept(level, origin, getAABB(origin, radius));
    }
}