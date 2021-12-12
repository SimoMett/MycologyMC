package com.mettsmirnov.mycology;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mycologymod")
public class MycologyMod
{
    public static final Logger MOD_LOGGER= LogManager.getLogger();

    public MycologyMod()
    {
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::);
        MinecraftForge.EVENT_BUS.register(this);
    }

    //private void enqueueIMC(final InterModEnqueueEvent event)
    //private void processIMC(final InterModProcessEvent event)
}
