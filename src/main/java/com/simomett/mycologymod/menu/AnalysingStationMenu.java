package com.simomett.mycologymod.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public class AnalysingStationMenu extends AbstractContainerMenu
{
    private static final int CONTAINER_START_X = 62;
    private static final int CONTAINER_START_Y = 17;
    private static final int INVENTORY_START_X = 8;
    private static final int INVENTORY_START_Y = 84;

    private final Container container;

    protected AnalysingStationMenu(int containerId, Inventory inventory, Container container)
    {
        super(MenuTypesDefinitions.ANALYSING_STATION_MENU_TYPE, containerId);

        this.container = container;

        // Some containers do custom logic when opened by a player.
        container.startOpen(inventory.player);

        // Add the slots for our container in a 3x3 grid.
        //this.add3x3GridSlots();
        this.addSlot(new Slot(this.container, 0, 26, 46));
        this.addSlot(new Slot(this.container, 1, 75, 46));
        this.addSlot(new Slot(this.container, 2, 133, 46));

        // Add the player inventory slots.
        this.addStandardInventorySlots(inventory, INVENTORY_START_X, INVENTORY_START_Y);
    }

    public AnalysingStationMenu(final int containerId, final Inventory inventory)
    {
        this(containerId, inventory, new SimpleContainer(1));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex)
    {
        return null;
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
        this.container.stopOpen(player);
    }
}
