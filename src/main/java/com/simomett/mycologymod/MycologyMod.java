package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.FungusColorer;
import com.simomett.mycologymod.blocks.ModBlocks;
import com.simomett.mycologymod.config.ModClientConfigs;
import com.simomett.mycologymod.datacomponents.ModDataAttachmentTypes;
import com.simomett.mycologymod.datacomponents.ModDataComponentTypes;
import com.simomett.mycologymod.config.ModCommonConfigs;
import com.simomett.mycologymod.creativetab.ModCreativeTabs;
import com.simomett.mycologymod.data.FungusSpeciesLoader;
import com.simomett.mycologymod.effects.PlayerEffects.ModEffects;
import com.simomett.mycologymod.entities.ModEntities;
import com.simomett.mycologymod.items.ModItems;
import com.simomett.mycologymod.items.potions.ModPotions;
import com.simomett.mycologymod.gui.menu.ModMenus;
import com.simomett.mycologymod.particles.ModParticles;
import com.simomett.mycologymod.recipes.breeding.MutationRecipeLoader;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import com.simomett.mycologymod.recipes.cooking.ModCookingRecipes;
import com.simomett.mycologymod.world.features.ModFeatures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MycologyMod.MODID)
public class MycologyMod
{
    public static final String MODID = "mycologymod";

    public MycologyMod(IEventBus evtBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON, ModCommonConfigs.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, ModClientConfigs.SPEC);

        ModItems.ITEMS.register(evtBus);
        ModBlocks.BLOCKS.register(evtBus);
        ModCreativeTabs.CREATIVE_TABS.register(evtBus);
        ModDataComponentTypes.DATA_COMPONENTS.register(evtBus);
        ModEntities.ENTITIES.register(evtBus);
        ModDataAttachmentTypes.ATTACHMENT_TYPES.register(evtBus);
        evtBus.register(FungusColorer.class);
        ModParticles.PARTICLES.register(evtBus);
        ModPotions.POTIONS.register(evtBus);
        ModCookingRecipes.RECIPE_SERIALIZERS.register(evtBus);
        ModEffects.EFFECTS.register(evtBus);
        ModMenus.MENU_TYPES.register(evtBus);
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
