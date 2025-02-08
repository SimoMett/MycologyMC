package com.simomett.mycologymod.gui.menu;

import com.simomett.mycologymod.gui.menu.slot.FungusSlot;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jline.utils.Log;

public class FungusAnalysingStationMenu extends AbstractContainerMenu
{
    private final Container container = new SimpleContainer(1);

    public FungusAnalysingStationMenu(int containerId, Inventory inv)
    {
        this(containerId, inv, ContainerLevelAccess.NULL);
    }

    public FungusAnalysingStationMenu(int containerId, Inventory inv, ContainerLevelAccess access)
    {
        super(ModMenus.FUNGUS_ANALYSING_STATION_MENU.get(), containerId);
        inv.startOpen(inv.player);
        addSlot(new FungusSlot(container, 0, 16, -12));

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
            this.addSlot(
                    new Slot(inv, i1, pInventoryX + i1 * 18, pHotbarY)
            );
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotId)
    {
        ItemStack movedStack = ItemStack.EMPTY;
        if(player instanceof ServerPlayer)
        {
            Slot slot = this.slots.get(slotId);
            movedStack = slot.getItem().copy();
            if(slotId==0)
            {
                if(!this.moveItemStackTo(slot.getItem(),1, 36, true))
                    return ItemStack.EMPTY;
            }
            else
            {
                if(!this.moveItemStackTo(slot.getItem(),0, 1, true))
                    return ItemStack.EMPTY;
            }
        }
        return movedStack;
    }

    @Override
    public boolean stillValid(Player player)
    {
        return container.stillValid(player);
    }

    @Override
    public void removed(Player player)
    {
        super.removed(player);
        if(!container.isEmpty())
        {
            //TODO
            Log.warn("item deleted");
        }
        container.stopOpen(player);
    }
}
