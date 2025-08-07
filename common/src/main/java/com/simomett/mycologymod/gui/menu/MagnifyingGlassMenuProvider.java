package com.simomett.mycologymod.gui.menu;

import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class MagnifyingGlassMenuProvider implements MenuProvider
{
    private final FungusGenoma fungusGenoma;
    public MagnifyingGlassMenuProvider(FungusGenoma dataModel)
    {
        this.fungusGenoma = dataModel;
    }

    @Override
    public Component getDisplayName()
    {
        return Component.literal("menu provider test");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player)
    {
        return new MagnifyingGlassMenu(i, inventory, fungusGenoma);
    }
}
