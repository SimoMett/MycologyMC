package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransmuteBlockEffect implements IFungusEffect
{
    private final String effectName;
    private final Block originBlock;
    private final Block targetBlock;

    public TransmuteBlockEffect(String effectName, Block originBlock, Block targetBlock)
    {
        this.effectName = effectName;
        this.originBlock = originBlock;
        this.targetBlock = targetBlock;
        FungusEffects.registerFungusEffect(effectName, this);
    }

    @Override
    public String getEffectName()
    {
        return this.effectName;
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {

    }

    @Override
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

        List <BlockPos> pList2 = pList.stream()
                .filter(p -> p.distSqr(origin) < box.getSize()/2.0f)
                .filter(p -> level.getBlockState(p).is(originBlock))
                .toList();
        if (!pList2.isEmpty())//FIXME list is always empty
        {
            BlockPos randomPos = pList2.get(new Random().nextInt(pList2.size()));
            level.setBlock(randomPos, targetBlock.defaultBlockState(), 2);
        }
    }
}
