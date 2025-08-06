package com.simomett.mycologymod.data;

import com.simomett.mycologymod.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class FungusSpeciesList extends AbstractFungusSpeciesList
{
    @SubscribeEvent
    public static void syncEvent(OnDatapackSyncEvent evt)
    {
        if(null != evt.getPlayer())
            PacketDistributor.sendToPlayer(evt.getPlayer(), AbstractFungusSpeciesList.getInstance());
        else
            PacketDistributor.sendToAllPlayers(AbstractFungusSpeciesList.getInstance());
    }
}
