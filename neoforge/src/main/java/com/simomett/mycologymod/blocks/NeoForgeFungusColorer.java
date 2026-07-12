package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.items.FungusTintSource;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class NeoForgeFungusColorer extends FungusColorer
{
    @SubscribeEvent
    public static void registerBlockColorsEvent(RegisterColorHandlersEvent.Block evt)
    {
        evt.register(new FungusColorer(),
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                BlocksDefinitions.COLORED_WARPED_FUNGUS.get(),
                BlocksDefinitions.POTTED_COLORED_CRIMSON.get(),
                BlocksDefinitions.POTTED_COLORED_WARPED.get());
    }

    @SubscribeEvent
    public static void registerItemColorsEvent(RegisterColorHandlersEvent.ItemTintSources evt)
    {
        evt.register(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fungus_color"), FungusTintSource.MAP_CODEC);
    }
}
