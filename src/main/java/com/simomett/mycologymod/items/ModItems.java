package com.simomett.mycologymod.items;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MycologyMod.MODID);

    public static final DeferredItem<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = ITEMS.register(ModBlocks.COLORED_CRIMSON_STRING, r ->
            new ColoredFungusBlockItem(ModBlocks.COLORED_CRIMSON_FUNGUS.get(), r));
    public static final DeferredItem<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = ITEMS.register(ModBlocks.COLORED_WARPED_STRING, r ->
            new ColoredFungusBlockItem(ModBlocks.COLORED_WARPED_FUNGUS.get(), r));

    //all the items below...
    public static final DeferredItem<MagnifyingGlassItem> MAGNIFYING_GLASS = ITEMS.register("magnifying_glass", MagnifyingGlassItem::new);
    public static final DeferredItem<Item> TEST_TUBE = ITEMS.registerSimpleItem("test_tube");
}
