package com.simomett.mycologymod.items;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredItem<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = ITEMS.register(BlocksDefinitions.COLORED_CRIMSON_STRING, r ->
            ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get());
    public static final DeferredItem<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = ITEMS.register(BlocksDefinitions.COLORED_WARPED_STRING, r ->
            ItemsDefinitions.COLORED_WARPED_FUNGUS.get());

    //all the items below...
    //public static final DeferredItem<BlockItem> FUNGUS_ANALYSING_STATION = ITEMS.registerSimpleBlockItem("fungus_analysing_station", ModBlocks.FUNGUS_ANALYSING_STATION);
    /*public static final DeferredItem<BlockItem> FUNGUS_POT = ITEMS.registerSimpleBlockItem(ModBlocks.FUNGUS_POT);
    public static final DeferredItem<BlockItem> POTTED_COLORED_CRIMSON = ITEMS.registerSimpleBlockItem(ModBlocks.POTTED_COLORED_CRIMSON);
    public static final DeferredItem<BlockItem> POTTED_COLORED_WARPED = ITEMS.registerSimpleBlockItem(ModBlocks.POTTED_COLORED_WARPED);*/
}
