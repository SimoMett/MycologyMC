package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransmuteBlockEffect extends FungusEffect
{
    private final MobEffect mobEffect;
    //FIXME is there a better way?
    // I'd like to convert a Block into a TagKey<Block>
    private final Block originBlock;
    private final TagKey<Block> originalBlocks;
    private final Block targetBlock;

    public TransmuteBlockEffect(String effectName, Block originalBlock, Block targetBlock)
    {
        super(effectName);
        this.mobEffect = null;
        this.originBlock = originalBlock;
        this.originalBlocks = null;
        this.targetBlock = targetBlock;
    }

    public TransmuteBlockEffect(String effectName, MobEffect mobEffect, Block originalBlock, Block targetBlock)
    {
        super(effectName);
        this.mobEffect = mobEffect;
        this.originBlock = originalBlock;
        this.originalBlocks = null;
        this.targetBlock = targetBlock;
    }

    public TransmuteBlockEffect(String effectName, TagKey<Block> originalBlocks, Block targetBlock)
    {
        super(effectName);
        this.mobEffect = null;
        this.originBlock = null;
        this.originalBlocks = originalBlocks;
        this.targetBlock = targetBlock;
    }

    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffect != null)
            entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
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

        List <BlockPos> pList2;
        if(originBlock != null)
        {
            pList2 = pList.stream()
                    .filter(p -> p.distSqr(origin) <= radius)
                    .filter(p -> level.getBlockState(p).is(originBlock))
                    .toList();
        }
        else
        {
            pList2 = pList.stream()
                    .filter(p -> p.distSqr(origin) <= radius)
                    .filter(p -> level.getBlockState(p).is(originalBlocks))
                    .toList();
        }
        if (!pList2.isEmpty())
        {
            BlockPos randomPos = pList2.get(new Random().nextInt(pList2.size()));
            level.setBlock(randomPos, targetBlock.defaultBlockState(), 2);
        }
    }
}
