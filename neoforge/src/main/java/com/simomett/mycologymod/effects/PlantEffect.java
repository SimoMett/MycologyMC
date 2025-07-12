package com.simomett.mycologymod.effects;

import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
            Random rand = new Random();
            BlockPos randomPos = pList2.get(rand.nextInt(pList2.size()));
            // using a custom loot table ?
            Optional<HolderSet.Named<Block>> plants = BuiltInRegistries.BLOCK.get(ModBlockTags.FUNGUS_PLANTABLE);
            BlockState randomPlant = plants.get().get(rand.nextInt(plants.get().size())).value().defaultBlockState();
            if(randomPlant.hasProperty(CropBlock.AGE))
                randomPlant.setValue(CropBlock.AGE, 0);
            level.setBlock(randomPos, randomPlant, 2);
        }
    }
}
