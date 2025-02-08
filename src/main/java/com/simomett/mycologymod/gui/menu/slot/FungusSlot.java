package com.simomett.mycologymod.gui.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import static com.simomett.mycologymod.items.ModItems.isFungus;

public class FungusSlot extends Slot
{
    public FungusSlot(Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return isFungus(stack);
    }
}
