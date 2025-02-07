package com.simomett.mycologymod.gui.menu;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.blocks.FungusAnalysingStationBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus
{
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, MycologyMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<MagnifyingGlassMenu>> MAGNIFYING_GLASS_MENU = MENU_TYPES.register("magnifying_glass_menu", () -> IMenuTypeExtension.create(MagnifyingGlassMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<FungusAnalysingStationMenu>> FUNGUS_ANALYSING_STATION_MENU = MENU_TYPES.register("fungus_analysing_station", () -> IMenuTypeExtension.create(FungusAnalysingStationMenu::new));
}
