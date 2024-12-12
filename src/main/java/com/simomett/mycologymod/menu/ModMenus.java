package com.simomett.mycologymod.menu;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus
{
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, MycologyMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<MagnifyingGlassMenu>> MAGNIFYING_GLASS_MENU = MENU_TYPES.register("magnifying_glass_menu", () -> new MenuType(MagnifyingGlassMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
