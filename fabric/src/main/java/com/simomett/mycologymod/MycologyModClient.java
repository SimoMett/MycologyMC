package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.blocks.FungusColorer;
import com.simomett.mycologymod.items.FungusTintSource;
import com.simomett.mycologymod.particles.MutantSporeParticles;
import com.simomett.mycologymod.particles.ParticlesDefinitions;
import com.simomett.mycologymod.particles.SporeParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.Identifier;

import java.util.List;

import static com.simomett.mycologymod.blocks.FungusColorer.*;

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
        /*BlockRenderLayerMap.putBlock(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksDefinitions.POTTED_COLORED_CRIMSON.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksDefinitions.POTTED_COLORED_WARPED.get(), ChunkSectionLayer.CUTOUT);*/

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
    }
}
