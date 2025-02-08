package com.simomett.mycologymod.gui.menu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class FungusAnalysingStationMenuProvider implements MenuProvider
{

    @Override
    public Component getDisplayName()
    {
        return Component.translatable("gui.fungus_analysing_station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player)
    {
        return new FungusAnalysingStationMenu(i, inventory);
    }
}
