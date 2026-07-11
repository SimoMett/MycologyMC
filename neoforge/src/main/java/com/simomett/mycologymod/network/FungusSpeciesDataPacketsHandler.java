package com.simomett.mycologymod.network;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import static com.simomett.mycologymod.data.FungusSpeciesColorsMap.COLORS_STREAM_CODEC;
import static com.simomett.mycologymod.data.FungusSpeciesList.SPECIES_STREAMS_CODEC;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class FungusSpeciesDataPacketsHandler
{
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent evt)
    {
        PayloadRegistrar registrar = evt.registrar("1");
        registrar.playToClient(FungusSpeciesColorsMap.TYPE, COLORS_STREAM_CODEC, new MainThreadPayloadHandler<>(ClientPayloadHandler::handleData));
        registrar.playToClient(FungusSpeciesList.TYPE, SPECIES_STREAMS_CODEC, new MainThreadPayloadHandler<>(ClientPayloadHandler::handleData));
    }

    public static class ClientPayloadHandler
    {
        public static void handleData(FungusSpeciesList fungusSpeciesList, IPayloadContext context) {}
        public static void handleData(FungusSpeciesColorsMap fungusSpeciesColorsMap, IPayloadContext context) {}
    }
}
