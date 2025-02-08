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
        addSlot(new Slot(container, 0, 16, -12));

        int pInventoryX = 8;
        int pInventoryY = 129;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlot(
                        new Slot(inv, j + i * 9 + 9, pInventoryX + j * 18, pInventoryY + i * 18)
                );
            }
        }

        int pHotbarY = 187;
        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(inv, i1, pInventoryX + i1 * 18, pHotbarY));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i)
    {
        return null;
    }

    @Override
    public boolean stillValid(Player player)
    {
        return true;//Must be true. Otherwise, instantly closes
    }
}
