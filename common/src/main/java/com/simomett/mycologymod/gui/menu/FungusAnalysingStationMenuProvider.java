package com.simomett.mycologymod.gui.menu;

import com.simomett.mycologymod.Constants;
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
        return Component.translatable("gui."+ Constants.MOD_ID+".fungus_analysing_station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player)
    {
        return new FungusAnalysingStationMenu(i, inventory);
    }
}
