package com.mettsmirnov.mycology.items;

import com.ibm.icu.impl.CollectionSet;
import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Collection;

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
        itemStacks.addAll(FungusSpeciesList.INSTANCE.getCollection());
    }
}
