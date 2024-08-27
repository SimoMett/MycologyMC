package com.mettsmirnov.mycology.menu;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus
{
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MycologyMod.MODID);

    public static final RegistryObject<MenuType<MagnifyingGlassMenu>> MAGNIFYING_GLASS_MENU = MENU_TYPES.register("magnifying_glass_menu", () -> new MenuType(MagnifyingGlassMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
