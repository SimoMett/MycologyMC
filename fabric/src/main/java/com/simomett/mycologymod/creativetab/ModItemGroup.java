package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;

public final class ModItemGroup
{
    public static final CreativeModeTab MAIN_CREATIVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "main_item_group"),
            FabricItemGroup.builder()
                .icon(Items.GOLD_ORE::getDefaultInstance)
                .title(Component.translatable("itemGroup.mycologymod.main"))
                .displayItems((enabledFlags, populator) -> {
                    populator.accept(ModItems.TEST_ITEM);
                })
                .build()
    );

    public static void initialize() {}
}
