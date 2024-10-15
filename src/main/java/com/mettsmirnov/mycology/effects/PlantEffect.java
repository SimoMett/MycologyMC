package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlantEffect extends FungusEffect
{
    public PlantEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {

    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        AABB box = getAABB(origin, radius);

        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> pList.add(new BlockPos(p)));
        pList.remove(origin.below());

        List <BlockPos> pList2;
        pList2 = pList.stream()
                .filter(p -> p.distSqr(origin) <= radius)
                .filter(p -> level.getBlockState(p).is(Blocks.AIR) && level.getBlockState(p.below()).is(Blocks.FARMLAND))
                .toList();

        if (!pList2.isEmpty())
        {
            BlockPos randomPos = pList2.get(new Random().nextInt(pList2.size()));
            //TODO change wheat crop with a random distribution of crops (loot table?)
            level.setBlock(randomPos, Blocks.WHEAT.defaultBlockState(), 2);
        }
    }
}
