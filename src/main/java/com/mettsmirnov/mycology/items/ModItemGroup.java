package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.data.FungusSpeciesHandler;
import net.minecraft.core.NonNullList;
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

    @Override
    public void fillItemList(NonNullList<ItemStack> itemStacks)
    {
        itemStacks.clear();
        itemStacks.addAll(FungusSpeciesHandler.INSTANCE.getCollection());
    }
}
