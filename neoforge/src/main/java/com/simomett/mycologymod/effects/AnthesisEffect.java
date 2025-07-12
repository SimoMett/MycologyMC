package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Random;

public class AnthesisEffect extends FungusEffect
{
    protected AnthesisEffect(String effectName) {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity) {

    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        AABB box = getAABB(origin, radius);

        final List<BlockPos> jungleLogsPos = getBlocksInAABBMatchingType(box, level, Blocks.JUNGLE_LOG);

        if (!jungleLogsPos.isEmpty())
            plantRandomCocoaBean(level, jungleLogsPos);
    }

    private static void plantRandomCocoaBean(ServerLevel level, List<BlockPos> pList)
    {
        BlockPos randomJungleLog = pList.get(new Random().nextInt(pList.size()));

        int xOffset = new Random().nextInt(3)-1;
        int zOffset = 0;
        if(xOffset==0)
            zOffset = new Random().nextBoolean()? 1 : -1;
        BlockPos randomPos = randomJungleLog.offset(xOffset, 0, zOffset);

        if(level.getBlockState(randomPos).isAir())
        {
            BlockState cocoaBlockState = Blocks.COCOA.defaultBlockState();
            if (zOffset == -1)
                cocoaBlockState = cocoaBlockState.rotate(level, randomPos, Rotation.CLOCKWISE_180);
            if(xOffset != 0)
                cocoaBlockState = cocoaBlockState.rotate(level, randomPos, xOffset==-1? Rotation.CLOCKWISE_90 : Rotation.COUNTERCLOCKWISE_90);
            level.setBlock(randomPos, cocoaBlockState, 2);

        }
    }
}
