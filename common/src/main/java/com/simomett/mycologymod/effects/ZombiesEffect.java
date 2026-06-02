package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;

import java.util.List;
import java.util.Random;

import static com.simomett.mycologymod.effects.SpawnEntityEffect.getPositionsForSpawningEntity;

public class ZombiesEffect extends FungusEffect
{
    public ZombiesEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {
        if(entity instanceof Zombie zombie && entity.level() instanceof ServerLevel serverLevel)
            zombie.kill(serverLevel);
    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        List<BlockPos> pList2 = getPositionsForSpawningEntity(level, origin, radius);
        if (!pList2.isEmpty())
        {
            BlockPos p = pList2.get(new Random().nextInt(pList2.size()));
            Zombie zombie = new Zombie(level);
            zombie.setHealth(1);
            zombie.setPos(p.getX(), p.getY(), p.getZ());
            zombie.skipDropExperience();
            level.addFreshEntity(zombie);
        }
    }
}
