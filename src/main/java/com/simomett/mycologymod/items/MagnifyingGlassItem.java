package com.simomett.mycologymod.items;

import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.gui.menu.MagnifyingGlassMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class MagnifyingGlassItem extends Item
{
    public MagnifyingGlassItem()
    {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        if(!context.getLevel().isClientSide())
        {
            BlockPos pos = context.getClickedPos();
            if (context.getLevel().getBlockEntity(pos) instanceof ColoredFungusBlockEntity coloredFungusBlockEntity)
            {
                FungusGenoma fungusGenoma = coloredFungusBlockEntity.getFungusGenoma();
                context.getPlayer().openMenu(new MagnifyingGlassMenuProvider(fungusGenoma), fungusGenoma::encode);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
