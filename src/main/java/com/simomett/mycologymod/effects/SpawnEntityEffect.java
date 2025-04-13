package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class SpawnEntityEffect extends FungusEffect
{
    private final Function<ServerLevel, Entity> entitySupplier;
    protected SpawnEntityEffect(String effectName, Function<ServerLevel, Entity> entitySupplier)
    {
        super(effectName);
        this.entitySupplier = entitySupplier;
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {

    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        List <BlockPos> pList2 = getPositionsForSpawningEntity(level, origin, radius);
        if (!pList2.isEmpty())
        {
            BlockPos p = pList2.get(new Random().nextInt(pList2.size()));
            Entity entity = entitySupplier.apply(level);
            if(entity!=null)
            {
                Random rand = new Random();
                entity.setPos(p.getX()+rand.nextFloat(.5f), p.getY(), p.getZ()+rand.nextFloat(.5f));
                level.addFreshEntity(entity);
            }
        }
    }

    public static List<BlockPos> getPositionsForSpawningEntity(ServerLevel level, BlockPos origin, int radius)
    {
        AABB box = getAABB(origin, radius);

        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> {
            pList.add(new BlockPos(p));
        });

        return pList.stream()
                .filter(p -> p.distSqr(origin) < box.getSize()/2.0f)
                .filter(p -> level.getBlockState(p).isAir() && level.getBlockState(p.above()).isAir() && !level.getBlockState(p.below()).isAir())
                .toList();
    }
}
