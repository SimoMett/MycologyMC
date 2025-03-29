package com.simomett.mycologymod.items;

import com.simomett.mycologymod.datacomponents.ModDataAttachmentTypes;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;


public class SpeedyzerItem extends Item
{
    public SpeedyzerItem(Properties properties)
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
                ColoredFungusBlockEntity blockEntity = (ColoredFungusBlockEntity) serverLevel.getBlockEntity(context.getClickedPos());
                FungusGenoma genoma = blockEntity.getFungusGenoma();
                FungusTraits t = new FungusTraits(genoma.getDominantTraits().species(),
                        1,
                        genoma.getDominantTraits().spreadboost(),
                        genoma.getDominantTraits().light(),
                        genoma.getDominantTraits().terrain(),
                        genoma.getDominantTraits().humidity(),
                        genoma.getDominantTraits().temp(),
                        genoma.getDominantTraits().area(),
                        genoma.getDominantTraits().effect(), Optional.empty());
                blockEntity.applyGenoma(new FungusGenoma(t, t));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
