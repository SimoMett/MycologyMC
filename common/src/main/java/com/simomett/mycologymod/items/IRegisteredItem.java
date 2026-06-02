package com.simomett.mycologymod.items;

import net.minecraft.world.item.Item;

public interface IRegisteredItem<T extends Item>
{
    Item get();
}
