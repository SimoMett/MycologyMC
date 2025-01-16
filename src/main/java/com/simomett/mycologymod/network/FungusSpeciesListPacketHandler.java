package com.simomett.mycologymod.network;

import com.simomett.mycologymod.data.FungusSpeciesList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class FungusSpeciesListPacketHandler
{
    public static final StreamCodec<FriendlyByteBuf, FungusSpeciesList> STREAM_CODEC = StreamCodec.ofMember(FungusSpeciesList::encode, FungusSpeciesList::fromByteBuf);

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent evt)
    {
        PayloadRegistrar registrar = evt.registrar("1");
        registrar.playToClient(FungusSpeciesList.TYPE, STREAM_CODEC, new MainThreadPayloadHandler<>(FungusSpeciesListPacketHandler.ClientPayloadHandler::handleData));
    }

    public static class ClientPayloadHandler
    {
        public static void handleData(FungusSpeciesList fungusSpeciesList, IPayloadContext context) {}
    }
}
