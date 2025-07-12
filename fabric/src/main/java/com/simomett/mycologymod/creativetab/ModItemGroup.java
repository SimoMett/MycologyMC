package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.Constants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;

public final class ModItemGroup
{
    public static final CreativeModeTab TEST_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "test_group"),
            FabricItemGroup.builder()
                .icon(Items.GOLD_ORE::getDefaultInstance)
                .title(Component.literal("itemGroup.mycologymod.test_group"))
                .displayItems((enabledFlags, populator) -> {
                    populator.accept(Items.DIAMOND_AXE);
                })
                .build()
    );

    public static void initialize()
    {

    }
}
