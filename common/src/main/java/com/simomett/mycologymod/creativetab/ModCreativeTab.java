package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;

public class ModCreativeTab
{
    public static CreativeModeTab tab = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup." + Constants.MOD_ID))
            .icon(Items.GOLDEN_CHESTPLATE::getDefaultInstance)
            .build();
}
