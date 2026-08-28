package com.simomett.mycologymod.client;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.client.particles.MutantSporeParticles;
import com.simomett.mycologymod.client.particles.SporeParticles;
import com.simomett.mycologymod.client.screen.AnalysingStationScreen;
import com.simomett.mycologymod.client.tints.FungusColorer;
import com.simomett.mycologymod.client.tints.FungusTintSource;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.menu.MenuTypesDefinitions;
import com.simomett.mycologymod.particles.ParticlesDefinitions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.Identifier;

import java.util.List;

import static com.simomett.mycologymod.client.tints.FungusColorer.*;


@Environment(EnvType.CLIENT)
public class MycologyModClient implements ClientModInitializer
{
    public static final FungusColorer fungusStelumColorer = new FungusColorer(OVERLAY_STELUM);
    public static final FungusColorer fungusHeadColorer = new FungusColorer(OVERLAY_HEAD);
    public static final FungusColorer fungusDetailsColorer = new FungusColorer(OVERLAY_DETAILS);
    public static final FungusColorer fungusDetails2Colorer = new FungusColorer(OVERLAY_DETAILS2);

    @Override
    public void onInitializeClient()
    {
        BlockColorRegistry.register(List.of(fungusStelumColorer, fungusHeadColorer, fungusDetailsColorer, fungusDetails2Colorer),
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                BlocksDefinitions.COLORED_WARPED_FUNGUS.get(),
                BlocksDefinitions.POTTED_COLORED_CRIMSON.get(),
                BlocksDefinitions.POTTED_COLORED_WARPED.get());

        ItemTintSources.ID_MAPPER.put(
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fungus_color"),
                FungusTintSource.MAP_CODEC
        );

        ParticleProviderRegistry.getInstance().register(ParticlesDefinitions.SPORE_PARTICLES.particleType(), SporeParticles.Provider::new);
        ParticleProviderRegistry.getInstance().register(ParticlesDefinitions.MUTANT_SPORE_PARTICLES.particleType(), MutantSporeParticles.Provider::new);

        MenuScreens.register(MenuTypesDefinitions.ANALYSING_STATION_MENU_TYPE, AnalysingStationScreen::new);
    }
}
