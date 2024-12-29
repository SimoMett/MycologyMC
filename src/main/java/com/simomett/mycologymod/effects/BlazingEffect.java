package com.simomett.mycologymod.effects;

import com.simomett.mycologymod.config.ModCommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Random;

public class BlazingEffect extends FungusEffect
{
    public BlazingEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity) {}

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        SmallFireball fireball = new SmallFireball(EntityType.SMALL_FIREBALL, level);
        fireball.setPos(origin.getCenter());
        level.addFreshEntity(fireball);
        Random rand = new Random();
        final float velocity = 0.8f;
        final float spread = 1f; //additive random spread
        AABB bbox = FungusEffect.getAABB(origin, radius);
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, bbox);
        if(rand.nextInt(ModCommonConfigs.EFFECT_BLAZING_HIT_ENTITY_CHANCE.get()) == 0 && !entities.isEmpty())
        {
            LivingEntity e = entities.get(rand.nextInt(entities.size()));
            double dist = e.position().distanceTo(origin.getCenter());
            fireball.shoot((e.getX() - origin.getX())/dist, (e.getY() - origin.getY())/dist, (e.getZ() - origin.getZ())/dist, velocity, 0.1f*spread);
        }
        else
            fireball.shoot(rand.nextDouble(-1, 1), rand.nextDouble(1), rand.nextDouble(-1, 1), velocity, spread);
    }
}
