package com.simomett.mycologymod.effects.fungus;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;

import java.util.List;
import java.util.Random;

public class SpawnExperienceEffect extends SpawnEntityEffect
{
    protected SpawnExperienceEffect(String effectName)
    {
        super(effectName, null);
    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        Random rand = new Random();
        if(rand.nextFloat(1) < chance)
        {
            List<BlockPos> pList2 = getPositionsForSpawningEntity(level, origin, radius);
            if (!pList2.isEmpty())
            {
                BlockPos p = pList2.get(new Random().nextInt(pList2.size()));
                Entity entity = new ExperienceOrb(level,p.getX() + rand.nextFloat(.5f), p.getY(), p.getZ() + rand.nextFloat(.5f), 1);
                level.addFreshEntity(entity);
            }
        }
    }
}
