package com.mettsmirnov.mycology.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FungusDataCapability
{
    public static final Capability<IFungusData> INSTANCE = CapabilityManager.get(new CapabilityToken<>(){});

    @SubscribeEvent
    public static void onRegisterCapability(RegisterCapabilitiesEvent evt)
    {
        evt.register(IFungusData.class);
    }

    private FungusDataCapability(){}
}
