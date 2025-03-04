package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;

public class WitheringEffect extends FungusEffect
{
    protected WitheringEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {
        if(entity.level() instanceof ServerLevel serverLevel)
        {
            if (entity instanceof Skeleton skeleton)
            {
                WitherSkeleton witherSkeleton = new WitherSkeleton(EntityType.WITHER_SKELETON, entity.level());
                skeleton.remove(Entity.RemovalReason.DISCARDED);
                witherSkeleton.setPos(skeleton.position());
                witherSkeleton.setXRot(skeleton.getXRot());
                witherSkeleton.setYRot(skeleton.getYRot());
                serverLevel.addFreshEntity(witherSkeleton);
            } else
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, numOfTicks));
        }
    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius) {}
}
