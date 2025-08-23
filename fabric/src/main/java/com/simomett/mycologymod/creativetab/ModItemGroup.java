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

import static com.simomett.mycologymod.creativetab.MycologyCreativeTab.CREATIVE_TAB_BUILDER;

public final class ModItemGroup
{
    public static final CreativeModeTab FABRIC_CREATIVE_TAB = CREATIVE_TAB_BUILDER.apply(FabricItemGroup.builder()).build();

    public static void initialize()
    {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "creativetab"),
                FABRIC_CREATIVE_TAB
        );
    }
}
