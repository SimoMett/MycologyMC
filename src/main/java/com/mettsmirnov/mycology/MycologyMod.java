package com.mettsmirnov.mycology;

import com.mettsmirnov.mycology.items.FungusItemColorer;
import com.mettsmirnov.mycology.items.ModItemGroup;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MycologyMod.MODID)
public class MycologyMod
{
    public static final String MODID = "mycologymod";
    public static final ModItemGroup MOD_ITEM_GROUP = new ModItemGroup(MODID);

    public MycologyMod()
    {
        IEventBus evtBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(evtBus);
        evtBus.register(FungusItemColorer.class);

        MinecraftForge.EVENT_BUS.register(this);
    }

    //private void enqueueIMC(final InterModEnqueueEvent event)
    //private void processIMC(final InterModProcessEvent event)
}
