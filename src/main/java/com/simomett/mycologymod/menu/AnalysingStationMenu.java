package com.simomett.mycologymod.menu;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class AnalysingStationMenu extends AbstractContainerMenu
{
    private static final int SLOTS_Y = 47;
    private static final int INVENTORY_START_X = 8;
    private static final int INVENTORY_START_Y = 84;

    private final Container container;

    protected AnalysingStationMenu(int containerId, Inventory inventory, Container container)
    {
        super(MenuTypesDefinitions.ANALYSING_STATION_MENU_TYPE, containerId);

        this.container = container;

        container.startOpen(inventory.player);

        FungusSlot fungusSlot = new FungusSlot(this.container, 0, 27, SLOTS_Y);
        this.addSlot(fungusSlot);

        BookAndQuillOnlySlot bookAndQuillOnlySlot = new BookAndQuillOnlySlot(this.container, 1, 76, SLOTS_Y);
        this.addSlot(bookAndQuillOnlySlot);

        AnalysingStationResultSlot analysingStationResultSlot = new AnalysingStationResultSlot(fungusSlot, bookAndQuillOnlySlot, this.container, 2, 134, SLOTS_Y);
        this.addSlot(analysingStationResultSlot);

        this.addSlotListener(new AnalysingStationSlotListener(analysingStationResultSlot));

        this.addStandardInventorySlots(inventory, INVENTORY_START_X, INVENTORY_START_Y);
    }

    public AnalysingStationMenu(final int containerId, final Inventory inventory)
    {
        this(containerId, inventory, new SimpleContainer(3));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex)
    {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player)
    {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(Player player)
    {
        super.removed(player);
        if(player instanceof ServerPlayer serverPlayer)
        {
            //FIXME book and quill can duplicate
            ItemStack itemStack0 = this.container.getItem(0);
            ItemStack itemStack1 = this.container.getItem(1);
            ItemStack itemStack2 = this.container.getItem(2);

            serverPlayer.addItem(itemStack0);
            serverPlayer.addItem(itemStack1);
            serverPlayer.addItem(itemStack2);
        }
        this.container.stopOpen(player);
    }
}
