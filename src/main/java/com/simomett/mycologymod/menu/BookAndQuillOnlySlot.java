package com.simomett.mycologymod.menu;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class BookAndQuillOnlySlot extends Slot
{
    public BookAndQuillOnlySlot(Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack)
    {
        return itemStack.is(Items.WRITABLE_BOOK);
    }
}
