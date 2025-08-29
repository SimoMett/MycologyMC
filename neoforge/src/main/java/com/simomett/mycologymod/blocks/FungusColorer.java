package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.items.ItemsDefinitions;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class FungusColorer extends AbstractFungusColorer
{
    @SubscribeEvent
    public static void registerBlockColorsEvent(RegisterColorHandlersEvent.Block evt)
    {
        evt.register(new AbstractFungusColorer(),
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS,
                BlocksDefinitions.COLORED_WARPED_FUNGUS
                /*BlockNames.POTTED_COLORED_CRIMSON.get(),
                BlockNames.POTTED_COLORED_WARPED.get()*/);
    }

    @SubscribeEvent
    public static void registerItemColorsEvent(RegisterColorHandlersEvent.Item evt)
    {
        evt.register(new AbstractFungusColorer(), ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get(), ItemsDefinitions.COLORED_WARPED_FUNGUS.get());
    }
}
