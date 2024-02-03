package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.apache.commons.lang3.function.TriConsumer;

public class SingleEffect implements IFungusEffect
{
    private final String effectName;

    private MobEffect mobEffect;
    private final TriConsumer<LevelAccessor, BlockPos, Integer> consumer;

    public SingleEffect(String effectName)
    {
        this(effectName, null, null);
    }

    public SingleEffect(String effectName, MobEffect mobEffect)
    {
        this(effectName, mobEffect, null);
    }

    public SingleEffect(String effectName, MobEffect mobEffect, TriConsumer<LevelAccessor, BlockPos, Integer> consumer)
    {
        this.effectName = effectName;
        this.mobEffect = mobEffect;
        this.consumer = consumer;
        FungusEffects.registerFungusEffect(effectName, this);
    }

    public String getEffectName()
    {
        return effectName;
    }

    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffect != null)
            entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
    }

    public void applyEffectToLevel(LevelAccessor level, BlockPos origin, int radius)
    {
        if (consumer != null)
            consumer.accept(level, origin, radius);
    }
}