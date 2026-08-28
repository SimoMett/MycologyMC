package com.simomett.mycologymod.menu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class AnalysingStationMenuProvider implements MenuProvider
{
    @Override
    public Component getDisplayName()
    {
        return Component.translatable("block.mycologymod.analysing_station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player)
    {
        return new AnalysingStationMenu(containerId, inventory);
    }
}
