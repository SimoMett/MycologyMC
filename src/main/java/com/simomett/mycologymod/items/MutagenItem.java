package com.simomett.mycologymod.items;

import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

import static com.simomett.mycologymod.blocks.ColoredFungusBlock.applyMutagen;
import static com.simomett.mycologymod.blocks.ColoredFungusBlock.hasMutagen;

public class MutagenItem extends Item
{
    public MutagenItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        BlockState bs = context.getLevel().getBlockState(context.getClickedPos());
        if (context.getLevel() instanceof ServerLevel serverLevel)
        {
            if(bs.is(ModBlockTags.COLORED_FUNGUS_BLOCKS))
            {
                if(!hasMutagen(bs))
                {
                    applyMutagen(context.getClickedPos(), bs, serverLevel);
                    context.getItemInHand().shrink(1);
                    return InteractionResult.CONSUME;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
