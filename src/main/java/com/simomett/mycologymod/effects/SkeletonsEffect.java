package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class SkeletonsEffect extends FungusEffect
{
    protected SkeletonsEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity) {}

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        AABB bbox = getAABB(origin, radius);
        List<BlockPos> blocksPositions = getBlocksInAABBMatchingType(bbox, level, Blocks.BONE_BLOCK);
        blocksPositions = blocksPositions.stream().filter( blockPos -> level.getBlockState(blockPos.above()).is(Blocks.BONE_BLOCK)).toList();
        if(!blocksPositions.isEmpty() && (level.getSkyDarken() >= 2 && level.getSkyDarken() <= 13))
        {
            BlockPos pos = blocksPositions.getLast();
            level.destroyBlock(pos, false);
            level.destroyBlock(pos.above(), false);
            Skeleton skeleton = new Skeleton(EntityType.SKELETON, level);
            level.addFreshEntity(skeleton);
            skeleton.setPos(pos.getCenter());
        }
    }
}
