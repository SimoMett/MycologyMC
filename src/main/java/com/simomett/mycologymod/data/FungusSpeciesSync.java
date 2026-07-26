package com.simomett.mycologymod.data;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class FungusSpeciesSync
{
    public static void registerPayloads()
    {
        PayloadTypeRegistry.clientboundPlay().register(FungusSpeciesList.TYPE, FungusSpeciesList.SPECIES_STREAMS_CODEC);
        PayloadTypeRegistry.clientboundPlay().register(FungusSpeciesColorsMap.TYPE, FungusSpeciesColorsMap.COLORS_STREAM_CODEC);

        PayloadTypeRegistry.serverboundPlay().register(FungusSpeciesList.TYPE, FungusSpeciesList.SPECIES_STREAMS_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(FungusSpeciesColorsMap.TYPE, FungusSpeciesColorsMap.COLORS_STREAM_CODEC);

        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((p,b)->
            {
                ServerPlayNetworking.send(p, FungusSpeciesList.getInstance());
                ServerPlayNetworking.send(p, FungusSpeciesColorsMap.getInstance());
            });
    }
}
