package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.blocks.FungusColorer;
import com.simomett.mycologymod.items.FungusTintSource;
import com.simomett.mycologymod.items.ItemsDefinitions;
import com.simomett.mycologymod.particles.MutantSporeParticles;
import com.simomett.mycologymod.particles.ParticlesDefinitions;
import com.simomett.mycologymod.particles.SporeParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class MycologyModClient implements ClientModInitializer
{
    //overlay indexes
    public static final int OVERLAY_STELUM = 0;
    public static final int OVERLAY_HEAD = 1;
    public static final int OVERLAY_DETAILS = 2;
    public static final int OVERLAY_DETAILS2 = 3;
    //

    public static final FungusColorer fungusColorer = new FungusColorer();

    @Override
    public void onInitializeClient()
    {
        BlockRenderLayerMap.putBlock(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksDefinitions.POTTED_COLORED_CRIMSON.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksDefinitions.POTTED_COLORED_WARPED.get(), ChunkSectionLayer.CUTOUT);

        ColorProviderRegistry.BLOCK.register(fungusColorer,
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                BlocksDefinitions.COLORED_WARPED_FUNGUS.get(),
                BlocksDefinitions.POTTED_COLORED_CRIMSON.get(),
                BlocksDefinitions.POTTED_COLORED_WARPED.get());

        ItemTintSources.ID_MAPPER.put(
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungus_color"),
                FungusTintSource.MAP_CODEC
        );

        ParticleFactoryRegistry.getInstance().register(ParticlesDefinitions.SPORE_PARTICLES.particleType(), SporeParticles.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ParticlesDefinitions.MUTANT_SPORE_PARTICLES.particleType(), MutantSporeParticles.Provider::new);
    }
}
