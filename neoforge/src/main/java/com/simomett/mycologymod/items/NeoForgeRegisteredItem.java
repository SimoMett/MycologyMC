package com.simomett.mycologymod.items;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class NeoForgeRegisteredItem<T extends Item> implements IRegisteredItem<T>
{
    private final DeferredItem<T> deferredItem;
    public NeoForgeRegisteredItem(DeferredItem<T> deferredItem)
    {
        this.deferredItem = deferredItem;
    }

    @Override
    public Item get()
    {
        return deferredItem.get();
    }
}
