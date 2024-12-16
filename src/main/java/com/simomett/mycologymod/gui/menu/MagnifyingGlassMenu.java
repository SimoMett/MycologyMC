package com.simomett.mycologymod.gui.menu;

import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class MagnifyingGlassMenu extends AbstractContainerMenu
{
    public FungusGenoma fungusGenoma;

    public MagnifyingGlassMenu(int containerId, Inventory inventory, FungusGenoma fungusGenoma)
    {
        super(ModMenus.MAGNIFYING_GLASS_MENU.get(), containerId);
        this.fungusGenoma = fungusGenoma;
    }

    public MagnifyingGlassMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf)
    {
        super(ModMenus.MAGNIFYING_GLASS_MENU.get(), containerId);
        fungusGenoma = FungusGenoma.fromByteBuf(friendlyByteBuf);
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
