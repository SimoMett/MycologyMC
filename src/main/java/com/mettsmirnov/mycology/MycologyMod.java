package com.mettsmirnov.mycology;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.capabilities.FungusDataAttacher;
import com.mettsmirnov.mycology.capabilities.ModCapabilitiesHandler;
import com.mettsmirnov.mycology.items.FungusItemColorer;
import com.mettsmirnov.mycology.items.ModBlockItems;
import com.mettsmirnov.mycology.items.ModItemGroup;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jline.utils.Log;

@Mod(MycologyMod.MODID)
public class MycologyMod
{
    public static final String MODID = "mycologymod";
    public static final ModItemGroup MOD_ITEM_GROUP = new ModItemGroup(MODID);

    public MycologyMod()
    {
        IEventBus evtBus = FMLJavaModLoadingContext.get().getModEventBus();

        evtBus.addListener(this::clientSetup);

        ModItems.ITEMS.register(evtBus);
        ModBlockItems.BLOCK_ITEMS.register(evtBus);
        ModBlocks.BLOCKS.register(evtBus);
        evtBus.register(FungusItemColorer.class);
        ModCapabilitiesHandler.registerCapabilities(evtBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(FungusDataAttacher.class);
    }

    private void clientSetup(FMLClientSetupEvent event)
    {
        Log.info("TEST CLIENT SETUP");

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COLORED_CRIMSON_FUNGUS.get(), RenderType.cutout());
    }
    //private void enqueueIMC(final InterModEnqueueEvent event)
    //private void processIMC(final InterModProcessEvent event)
}
