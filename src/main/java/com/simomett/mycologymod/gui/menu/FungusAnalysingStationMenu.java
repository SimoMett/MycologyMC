package com.simomett.mycologymod.gui.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FungusAnalysingStationMenu extends AbstractContainerMenu
{
    private final Container container = new SimpleContainer(1);

    public FungusAnalysingStationMenu(int containerId, Inventory inv)
    {
        super(ModMenus.FUNGUS_ANALYSING_STATION_MENU.get(), containerId);
        inv.startOpen(inv.player);
        addSlot(new Slot(container, 0, 0, 0));
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
