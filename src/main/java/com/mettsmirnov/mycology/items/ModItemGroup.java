package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
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
        ItemStack e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
        if(e.getCapability(FungusDataCapability.INSTANCE).isPresent())
        {
            //e.getCapability(FungusDataCapability.INSTANCE).resolve().get().
        }
        //itemStacks.add(e);
        super.fillItemList(itemStacks);
    }
}
