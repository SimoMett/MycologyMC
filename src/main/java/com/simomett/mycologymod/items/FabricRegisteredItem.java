package com.simomett.mycologymod.items;

import net.minecraft.world.item.Item;

public class FabricRegisteredItem<T extends Item> implements IRegisteredItem<T>
{
    private final T item;
    public FabricRegisteredItem(T item)
    {
        this.item = item;
    }

    @Override
    public Item get()
    {
        return item;
    }
}
