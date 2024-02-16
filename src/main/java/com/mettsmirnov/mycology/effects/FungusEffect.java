package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;

public abstract class FungusEffect
{
    protected static final int numOfTicks = 100;//this value is hardcoded and should not be configurable.

    private final String effectName;
    protected FungusEffect(String effectName)
    {
        this.effectName = effectName;
        FungusEffects.registerFungusEffect(effectName, this);
    }

    public String getEffectName()
    {
        return effectName;
    }
    public abstract void applyEffectToEntity(LivingEntity entity);
    public abstract void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius);
}
