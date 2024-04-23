package com.mettsmirnov.mycology.creativetab;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MycologyMod.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN_CREATIVE_TAB = CREATIVE_TABS.register("", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MycologyMod.MODID))
            .icon(() -> FungusSpeciesList.INSTANCE.getCreativeTabIcon())
            .displayItems((enabledFlags, populator) -> {
                populator.acceptAll(FungusSpeciesList.INSTANCE.getAllSpeciesCollection());
                populator.accept(ModItems.MAGNIFYING_GLASS.get());
            })
            .build()
    );
}
