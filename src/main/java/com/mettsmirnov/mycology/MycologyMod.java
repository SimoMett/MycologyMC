package com.mettsmirnov.mycology;

import com.mettsmirnov.mycology.blocks.FungusBlockColorer;
import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.capabilities.FungusDataAttacher;
import com.mettsmirnov.mycology.capabilities.ModCapabilitiesHandler;
import com.mettsmirnov.mycology.config.ModCommonConfigs;
import com.mettsmirnov.mycology.creativetab.ModCreativeTabs;
import com.mettsmirnov.mycology.data.FungusSpeciesLoader;
import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import com.mettsmirnov.mycology.entities.ModEntities;
import com.mettsmirnov.mycology.items.FungusItemColorer;
import com.mettsmirnov.mycology.items.ModItems;
import com.mettsmirnov.mycology.items.potions.ModPotions;
import com.mettsmirnov.mycology.menu.ModMenus;
import com.mettsmirnov.mycology.particles.ModParticles;
import com.mettsmirnov.mycology.recipes.breeding.MutationRecipeLoader;
import com.mettsmirnov.mycology.recipes.brewing.FungusBrewingRecipeLoader;
import com.mettsmirnov.mycology.recipes.cooking.ModCookingRecipes;
import com.mettsmirnov.mycology.world.features.ModFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MycologyMod.MODID)
public class MycologyMod
{
    public static final String MODID = "mycologymod";

    public MycologyMod()
    {
        IEventBus evtBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfigs.SPEC, MODID+"-common.toml");
        ModItems.ITEMS.register(evtBus);
        ModPotions.POTIONS.register(evtBus);
        ModCreativeTabs.CREATIVE_TABS.register(evtBus);
        ModBlocks.BLOCKS.register(evtBus);
        ModEntities.ENTITIES.register(evtBus);
        evtBus.register(FungusItemColorer.class);
        evtBus.register(FungusBlockColorer.class);
        ModCapabilitiesHandler.registerCapabilities(evtBus);
        ModCookingRecipes.RECIPE_SERIALIZERS.register(evtBus);
        ModFeatures.FEATURES.register(evtBus);
        ModParticles.PARTICLES.register(evtBus);
        ModEffects.EFFECTS.register(evtBus);
        ModMenus.MENU_TYPES.register(evtBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(FungusDataAttacher.class);
        MinecraftForge.EVENT_BUS.addListener(this::reloadListener);
    }

    private void reloadListener(AddReloadListenerEvent evt)
    {
        evt.addListener(FungusSpeciesLoader.INSTANCE);
        evt.addListener(FungusBrewingRecipeLoader.INSTANCE);
        evt.addListener(MutationRecipeLoader.INSTANCE);
    }
    //private void enqueueIMC(final InterModEnqueueEvent event)
    //private void processIMC(final InterModProcessEvent event)
}
