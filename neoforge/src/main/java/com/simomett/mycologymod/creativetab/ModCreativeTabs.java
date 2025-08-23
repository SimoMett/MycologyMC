package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.simomett.mycologymod.creativetab.MycologyCreativeTab.CREATIVE_TAB_BUILDER;

public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_CREATIVE_TAB =
            CREATIVE_TABS.register("", () -> CREATIVE_TAB_BUILDER.apply(CreativeModeTab.builder()).build()
    );
}
