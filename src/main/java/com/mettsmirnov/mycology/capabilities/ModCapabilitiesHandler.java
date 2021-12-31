package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModCapabilitiesHandler
{
    public static final ResourceLocation GENOMA_CAPABILITY_RES = new ResourceLocation(MycologyMod.MODID,"fungus_genoma");

    @SubscribeEvent
    //TODO
    public void attachCapability(AttachCapabilitiesEvent<ItemStack> evt)
    {

    }
}
