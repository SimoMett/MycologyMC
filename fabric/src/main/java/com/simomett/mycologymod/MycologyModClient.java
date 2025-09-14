package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.blocks.FungusColorer;
import com.simomett.mycologymod.items.ItemsDefinitions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.RenderType;

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
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(), RenderType.cutout());

        ColorProviderRegistry.BLOCK.register(fungusColorer,
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                BlocksDefinitions.COLORED_WARPED_FUNGUS.get());

        ColorProviderRegistry.ITEM.register(fungusColorer,
                ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                ItemsDefinitions.COLORED_WARPED_FUNGUS.get());
    }
}
