package com.simomett.mycologymod.menu;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

public class MenuTypesDefinitions
{
    public static final MenuType<AnalysingStationMenu> ANALYSING_STATION_MENU_TYPE = Registry.register(BuiltInRegistries.MENU, "analysing_station",
            new MenuType<>(AnalysingStationMenu::new, FeatureFlagSet.of()));
}
