package com.simomett.mycologymod.items;

import com.simomett.mycologymod.MycologyMod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MycologyMod.MODID);

    public static final DeferredItem<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = ITEMS.register("colored_crimson_fungus", ColoredFungusBlockItem::createColoredCrimson);
    public static final DeferredItem<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = ITEMS.register("colored_warped_fungus", ColoredFungusBlockItem::createColoredWarped);

    //all the items below...
    public static final DeferredItem<MagnifyingGlassItem> MAGNIFYING_GLASS = ITEMS.register("magnifying_glass", MagnifyingGlassItem::new);
}
