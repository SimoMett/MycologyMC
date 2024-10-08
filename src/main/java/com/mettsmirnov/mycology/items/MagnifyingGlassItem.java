package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import com.mettsmirnov.mycology.gui.MagnifyingGlassScreen;
import com.mettsmirnov.mycology.menu.MagnifyingGlassMenuProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.jline.utils.Log;

public class MagnifyingGlassItem extends Item
{
    public MagnifyingGlassItem()
    {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        if(context.getLevel().isClientSide())
        {
            BlockPos pos = context.getClickedPos();
            if (context.getLevel().getBlockEntity(pos) instanceof ColoredFungusBlockEntity coloredFungusBlockEntity)
            {
                FungusDataModel fungusDataModel = coloredFungusBlockEntity.getFungusData();
                Minecraft.getInstance().setScreen(new MagnifyingGlassScreen(fungusDataModel));
            }
        }
        return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
    }
}
