package com.simomett.mycologymod.gui.menu;

import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class FungusAnalysingStationMenu extends AbstractContainerMenu
{
    private final FungusGenoma fungusGenoma;

    public FungusAnalysingStationMenu(int containerId, Inventory inventory, FungusGenoma fungusGenoma)
    {
        super(ModMenus.MAGNIFYING_GLASS_MENU.get(), containerId);
        this.fungusGenoma = fungusGenoma;
    }

    public FungusAnalysingStationMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf)
    {
        super(ModMenus.FUNGUS_ANALYSING_STATION_MENU.get(), containerId);
        fungusGenoma = new FungusGenoma(registryFriendlyByteBuf);
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
