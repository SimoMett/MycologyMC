package com.simomett.mycologymod.menu;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
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

        container.startOpen(inventory.player);

        this.addSlot(new Slot(this.container, 0, 27, 47));
        this.addSlot(new Slot(this.container, 1, 76, 47));
        this.addSlot(new Slot(this.container, 2, 134, 47));

        this.addStandardInventorySlots(inventory, INVENTORY_START_X, INVENTORY_START_Y);
    }

    public AnalysingStationMenu(final int containerId, final Inventory inventory)
    {
        this(containerId, inventory, new SimpleContainer(3));
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
        if(player instanceof ServerPlayer serverPlayer)
        {
            serverPlayer.addItem(this.container.getItem(0));
            serverPlayer.addItem(this.container.getItem(1));
            serverPlayer.addItem(this.container.getItem(2));
        }
        this.container.stopOpen(player);
    }
}
