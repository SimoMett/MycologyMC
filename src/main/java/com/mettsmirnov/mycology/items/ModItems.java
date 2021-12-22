package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MycologyMod.MODID);

    public static final RegistryObject<ColoredFungusItem> COLORED_CRIMSON_FUNGUS = ITEMS.register("colored_crimson_fungus", ColoredFungusItem::createColoredCrimson);
    //all the items below..
}
