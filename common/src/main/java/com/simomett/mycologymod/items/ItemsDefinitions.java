package com.simomett.mycologymod.items;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ItemsDefinitions
{
    public static final Supplier<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = () ->
            new ColoredFungusBlockItem(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, BlocksDefinitions.COLORED_CRIMSON_STRING));

    public static final Supplier<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = () ->
            new ColoredFungusBlockItem(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(),
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, BlocksDefinitions.COLORED_WARPED_STRING));

    public static boolean isFungus(ItemStack itemStack)
    {
        return itemStack.is(COLORED_WARPED_FUNGUS.get()) || itemStack.is(COLORED_CRIMSON_FUNGUS.get());
    }
}
