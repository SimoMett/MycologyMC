package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModCapabilitiesHandler
{
    public static void registerCapabilities(IEventBus modBus)
    {
        modBus.register(FungusDataCapability.class);
    }
}
