package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.items.ModItems;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class FungusColorer extends AbstractFungusColorer
{
    @SubscribeEvent
    public static void registerBlockColorsEvent(RegisterColorHandlersEvent.Block evt)
    {
        evt.register(new AbstractFungusColorer(),
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                BlocksDefinitions.COLORED_WARPED_FUNGUS.get()
                /*BlockNames.POTTED_COLORED_CRIMSON.get(),
                BlockNames.POTTED_COLORED_WARPED.get()*/);
    }

    @SubscribeEvent
    public static void registerItemColorsEvent(RegisterColorHandlersEvent.Item evt)
    {
        evt.register(new AbstractFungusColorer(), ModItems.COLORED_CRIMSON_FUNGUS.get(), ModItems.COLORED_WARPED_FUNGUS.get());
    }
}
