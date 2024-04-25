package com.mettsmirnov.mycology.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class MagnifyingGlassMenu extends AbstractContainerMenu
{
    //Client constructor
    public MagnifyingGlassMenu(int containerId, Inventory inventory, FriendlyByteBuf extraData)
    {
        super(ModMenus.MAGNIFYING_GLASS_MENU.get(), containerId);

    }
    //Server constructor
    public MagnifyingGlassMenu(int containerId, Inventory inventory)
    {
        super(ModMenus.MAGNIFYING_GLASS_MENU.get(), containerId);
    }



    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
