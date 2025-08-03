package com.simomett.mycologymod.network;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class FungusSpeciesListPacketHandler
{
    public static final StreamCodec<FriendlyByteBuf, AbstractFungusSpeciesColorsMap> COLORS_STREAM_CODEC = StreamCodec.ofMember(AbstractFungusSpeciesColorsMap::encode, AbstractFungusSpeciesColorsMap::fromByteBuf);
    public static final StreamCodec<FriendlyByteBuf, AbstractFungusSpeciesList> SPECIES_STREAMS_CODEC = StreamCodec.ofMember(AbstractFungusSpeciesList::encode, AbstractFungusSpeciesList::fromByteBuf);

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent evt)
    {
        PayloadRegistrar registrar = evt.registrar("1");
        registrar.playToClient(AbstractFungusSpeciesColorsMap.TYPE, COLORS_STREAM_CODEC, new MainThreadPayloadHandler<>(ClientPayloadHandler::handleData));
        registrar.playToClient(AbstractFungusSpeciesList.TYPE, SPECIES_STREAMS_CODEC, new MainThreadPayloadHandler<>(ClientPayloadHandler::handleData));
    }

    public static class ClientPayloadHandler
    {
        public static void handleData(AbstractFungusSpeciesList fungusSpeciesList, IPayloadContext context) {}
        public static void handleData(AbstractFungusSpeciesColorsMap fungusSpeciesColorsMap, IPayloadContext context) {}
    }
}
