package com.mettsmirnov.mycology.items;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
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
        CompoundTag testTag = new CompoundTag();
        testTag.putString("species","Alea");
        ItemStack e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
        e.setTag(testTag);
        itemStacks.add(e);
        super.fillItemList(itemStacks);
    }
}
