package com.simomett.mycologymod.gui.menu.slot;

import com.simomett.mycologymod.datacomponents.ModDataComponentTypes;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;
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

    public FungusGenoma getGenoma()
    {
        return getItem().has(FUNGUS_GENOMA)? getItem().get(FUNGUS_GENOMA) : null;
    }
}
