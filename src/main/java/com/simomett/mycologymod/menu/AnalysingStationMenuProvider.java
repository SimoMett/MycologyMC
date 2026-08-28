package com.simomett.mycologymod.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class AnalysingStationMenuProvider implements MenuProvider
{
    private BlockPos blockPos;
    public AnalysingStationMenuProvider(BlockPos pos)
    {
        this.blockPos = pos;
    }

    @Override
    public Component getDisplayName()
    {
        return Component.translatable("block.mycologymod.analysing_station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player)
    {
        AnalysingStationMenu analysingStationMenu = new AnalysingStationMenu(containerId, inventory);
        analysingStationMenu.setOrigin(blockPos);
        return analysingStationMenu;
    }
}
