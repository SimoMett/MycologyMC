package com.mettsmirnov.mycology.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroup extends CreativeModeTab
{
    public ModItemGroup(String label)
    {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return Items.CRIMSON_FUNGUS.getDefaultInstance();
    }
}
