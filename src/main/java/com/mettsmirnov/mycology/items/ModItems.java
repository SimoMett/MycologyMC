package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MycologyMod.MODID);

    public static final RegistryObject<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = ITEMS.register("colored_crimson_fungus", ColoredFungusBlockItem::createColoredCrimson);
    public static final RegistryObject<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = ITEMS.register("colored_warped_fungus", ColoredFungusBlockItem::createColoredWarped);

    //all the items below..
    public static final RegistryObject<MagnifyingGlassItem> MAGNIFYING_GLASS = ITEMS.register("magnifying_glass", MagnifyingGlassItem::new);
}
