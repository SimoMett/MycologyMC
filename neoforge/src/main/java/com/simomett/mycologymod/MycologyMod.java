package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.blocks.ModBlocks;
import com.simomett.mycologymod.config.NeoForgeClientConfigs;
import com.simomett.mycologymod.config.NeoForgeCommonConfigs;
import com.simomett.mycologymod.creativetab.ModCreativeTabs;
import com.simomett.mycologymod.data.FungusSpeciesLoader;
import com.simomett.mycologymod.effects.player.NeoForgeModEffects;
import com.simomett.mycologymod.entities.NeoForgeBlockEntities;
import com.simomett.mycologymod.items.ItemsDefinitions;
import com.simomett.mycologymod.items.ModItems;
import com.simomett.mycologymod.items.potions.NeoForgePotions;
import com.simomett.mycologymod.particles.ModParticles;
import com.simomett.mycologymod.recipes.breeding.MutationRecipeLoader;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import com.simomett.mycologymod.recipes.ModRecipes;
import com.simomett.mycologymod.world.features.ModFeatures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Constants.MOD_ID)
public class MycologyMod
{
    public MycologyMod(IEventBus evtBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeCommonConfigs.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, NeoForgeClientConfigs.SPEC);

        ItemsDefinitions.init();
        ModItems.ITEMS.register(evtBus);

        BlocksDefinitions.init();
        ModBlocks.BLOCKS.register(evtBus);
        
        ModCreativeTabs.CREATIVE_TABS.register(evtBus);
        //DataComponentTypes.DATA_COMPONENTS.register(evtBus);
        NeoForgeBlockEntities.ENTITIES.register(evtBus);
        //DataComponentTypes.ATTACHMENT_TYPES.register(evtBus);
        ModParticles.PARTICLES.register(evtBus);
        NeoForgePotions.POTIONS.register(evtBus);
        ModRecipes.RECIPE_SERIALIZERS.register(evtBus);
        NeoForgeModEffects.EFFECTS.register(evtBus);
        //ModMenus.MENU_TYPES.register(evtBus);
        ModFeatures.FEATURES.register(evtBus);

        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    private void reloadListener(AddReloadListenerEvent evt)
    {
        evt.addListener(FungusSpeciesLoader.INSTANCE);
        evt.addListener(FungusBrewingRecipeLoader.INSTANCE);
        evt.addListener(MutationRecipeLoader.INSTANCE);
    }
}
