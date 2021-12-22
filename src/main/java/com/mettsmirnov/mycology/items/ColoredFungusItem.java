package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.item.Item;

public class ColoredFungusItem extends Item
{
    public static ColoredFungusItem createColoredCrimson()
    {
        return new ColoredFungusItem();
    }

    public ColoredFungusItem()
    {
        super(new Properties().tab(MycologyMod.MOD_ITEM_GROUP));
    }
}
