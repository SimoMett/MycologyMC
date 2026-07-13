package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.items.FungusTintSource;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class NeoForgeFungusColorer extends FungusColorer
{
    public NeoForgeFungusColorer(int tintIndex) {
        super(tintIndex);
    }

    @SubscribeEvent
    public static void registerBlockColorsEvent(RegisterColorHandlersEvent.BlockTintSources evt)
    {
        evt.register(List.of(
                        new NeoForgeFungusColorer(OVERLAY_STELUM),
                        new NeoForgeFungusColorer(OVERLAY_HEAD),
                        new NeoForgeFungusColorer(OVERLAY_DETAILS),
                        new NeoForgeFungusColorer(OVERLAY_DETAILS2)
                        ),
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
