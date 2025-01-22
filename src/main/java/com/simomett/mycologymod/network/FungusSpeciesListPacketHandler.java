package com.simomett.mycologymod.network;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class FungusSpeciesListPacketHandler
{
    public static final StreamCodec<FriendlyByteBuf, FungusSpeciesColorsMap> COLORS_STREAM_CODEC = StreamCodec.ofMember(FungusSpeciesColorsMap::encode, FungusSpeciesColorsMap::fromByteBuf);
    public static final StreamCodec<FriendlyByteBuf, FungusSpeciesList> SPECIES_STREAMS_CODEC = StreamCodec.ofMember(FungusSpeciesList::encode, FungusSpeciesList::fromByteBuf);

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
