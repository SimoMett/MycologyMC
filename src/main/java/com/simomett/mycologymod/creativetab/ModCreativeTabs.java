package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MycologyMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_CREATIVE_TAB = CREATIVE_TABS.register("", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MycologyMod.MODID))
            .icon(() -> FungusSpeciesList.INSTANCE.getCreativeTabIcon())
            .displayItems((enabledFlags, populator) -> {
                populator.acceptAll(FungusSpeciesList.INSTANCE.getAllSpeciesCollection());
                populator.accept(ModItems.MAGNIFYING_GLASS.get());
                populator.accept(ModItems.TEST_TUBE);
                populator.accept(ModItems.CHROMIUM_ORE);
                populator.accept(ModItems.CHROMIUM_POWDER);
                populator.accept(ModItems.CHROMIUM_MUTAGEN);
            })
            .build()
    );
}
