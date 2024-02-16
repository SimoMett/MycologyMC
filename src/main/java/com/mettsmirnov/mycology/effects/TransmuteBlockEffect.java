package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransmuteBlockEffect extends FungusEffect
{
    private final Block originBlock;
    private final Block targetBlock;

    public TransmuteBlockEffect(String effectName, Block originalBlock, Block targetBlock)
    {
        super(effectName);
        this.originBlock = originalBlock;
        this.targetBlock = targetBlock;
    }

    public void applyEffectToEntity(LivingEntity entity)
    {

    }

    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        AABB box = new AABB(
                origin.getX() - radius,
                origin.getY() - radius,
                origin.getZ() - radius,
                origin.getX() + radius,
                origin.getY() + radius,
                origin.getZ() + radius
        );
        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> {
            pList.add(new BlockPos(p));
        });
        pList.remove(origin.below());

        List <BlockPos> pList2 = pList.stream()
                .filter(p -> p.distSqr(origin) <= box.getSize()/2.0f)
                .filter(p -> level.getBlockState(p).is(originBlock))
                .toList();
        if (!pList2.isEmpty())
        {
            BlockPos randomPos = pList2.get(new Random().nextInt(pList2.size()));
            level.setBlock(randomPos, targetBlock.defaultBlockState(), 2);
        }
    }
}
