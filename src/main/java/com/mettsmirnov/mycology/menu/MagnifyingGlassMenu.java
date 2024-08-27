package com.mettsmirnov.mycology.menu;

import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class MagnifyingGlassMenu extends AbstractContainerMenu
{
    public FungusDataModel fungusDataModel;

    //Client constructor
    public MagnifyingGlassMenu(int containerId, Inventory inventory, FungusDataModel fungusDataModel)
    {
        super(ModMenus.MAGNIFYING_GLASS_MENU.get(), containerId);
        this.fungusDataModel = fungusDataModel;

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
    public boolean stillValid(Player player)
    {
        return true;//Must be true. Otherwise, instantly closes
    }
}
