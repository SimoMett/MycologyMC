package com.simomett.mycologymod.gui;


import com.simomett.mycologymod.gui.menu.ModMenus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens
{
	@SubscribeEvent
	public static void registerScreen(RegisterMenuScreensEvent event)
	{
		event.register(ModMenus.MAGNIFYING_GLASS_MENU.get(), MagnifyingGlassScreen::new);
		event.register(ModMenus.FUNGUS_ANALYSING_STATION_MENU.get(), FungusAnalysingStationScreen::new);
	}
}
