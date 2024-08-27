package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

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

    protected static AABB getAABB(Vec3i origin, int radius)
    {
        return new AABB(
                origin.getX() - radius,
                origin.getY() - radius,
                origin.getZ() - radius,
                origin.getX() + radius,
                origin.getY() + radius,
                origin.getZ() + radius
        );
    }
}
