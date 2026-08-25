package com.simomett.mycologymod.menu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.ItemStack;

public class AnalysingStationSlotListener implements ContainerListener
{
    private AnalysingStationResultSlot resultSlot;
    public AnalysingStationSlotListener(AnalysingStationResultSlot resultSlot)
    {
        this.resultSlot = resultSlot;
    }

    @Override
    public void slotChanged(AbstractContainerMenu containerMenu, int slotIndex, ItemStack itemStack)
    {
        if(slotIndex == 0 || slotIndex == 1)
            resultSlot.updateOutput();
    }

    @Override
    public void dataChanged(AbstractContainerMenu container, int id, int value)
    {
        //Log.info(LogCategory.GENERAL, "data changed");
    }
}
