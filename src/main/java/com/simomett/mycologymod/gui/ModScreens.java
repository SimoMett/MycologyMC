package com.simomett.mycologymod.gui;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens
{
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event)
	{
		//event.enqueueWork(() -> MenuScreens.register(ModMenus.MAGNIFYING_GLASS_MENU.get(), MagnifyingGlassScreen::new));
	}
}
