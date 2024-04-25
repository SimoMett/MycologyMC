
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.mettsmirnov.mycology.gui;

import com.mettsmirnov.mycology.menu.MagnifyingGlassMenu;
import com.mettsmirnov.mycology.menu.ModMenus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens
{
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event)
	{
		event.enqueueWork(() -> {
			MenuScreens.register(ModMenus.MAGNIFYING_GLASS_MENU.get(), MagnifyingGlassScreen::new);
		});
	}
}
