package com.mettsmirnov.mycology.items;

import net.minecraft.server.level.ServerPlayer;
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
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_)
    {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer)
        {
            Log.info("CLIENT ITEM USED");
            //FIXME apparently from forge 47.999.1 there's no more NetworkHooks
            //NetworkHooks.openScreen(serverPlayer, state.getMenuProvider(level, pos));
        }

        return super.use(level, player, p_41434_);
    }
}
