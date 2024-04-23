package com.mettsmirnov.mycology.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jline.utils.Log;

public class MagnifyingGlassItem extends Item
{
    public MagnifyingGlassItem()
    {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player p_41433_, InteractionHand p_41434_)
    {
        if(level.isClientSide())
            Log.info("CLIENT ITEM USED");
        return super.use(level, p_41433_, p_41434_);
    }
}
