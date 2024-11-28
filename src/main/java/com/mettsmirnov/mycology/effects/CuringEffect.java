package com.mettsmirnov.mycology.effects;

import com.mettsmirnov.mycology.mixins.IZombieVillagerMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ZombieVillager;

import java.util.Random;

public class CuringEffect extends FungusEffect
{
    public CuringEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {
        if(entity instanceof ZombieVillager zombieVillager && !zombieVillager.isConverting())
            ((IZombieVillagerMixin) zombieVillager).invokeStartConverting(null, new Random().nextInt(2401) + 3600);
    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius) {

    }
}
