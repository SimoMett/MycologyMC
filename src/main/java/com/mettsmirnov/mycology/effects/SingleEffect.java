package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;

public class SingleEffect implements IFungusEffect
{
    private final String effectName;

    private MobEffect mobEffect;

    @Deprecated(forRemoval = true)
    public SingleEffect(String effectName)
    {
        this.effectName = effectName;
        FungusEffects.registerFungusEffect(effectName, this);
    }

    public SingleEffect(String effectName, MobEffect mobEffect)
    {
        this.effectName = effectName;
        this.mobEffect = mobEffect;
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

    public void applyEffectToLevel(LevelReader level, BlockPos origin, int radius)
    {

    }
}