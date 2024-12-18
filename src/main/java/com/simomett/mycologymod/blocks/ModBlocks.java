package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MycologyMod.MODID);

    public static final String COLORED_CRIMSON_STRING = "colored_crimson_fungus";
    public static final DeferredBlock<ColoredFungusBlock> COLORED_CRIMSON_FUNGUS = BLOCKS.register(COLORED_CRIMSON_STRING, r ->
        new ColoredFungusBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                .setId(ResourceKey.create(Registries.BLOCK, r)))
    );

    public static final String COLORED_WARPED_STRING = "colored_warped_fungus";
    public static final DeferredBlock<ColoredFungusBlock> COLORED_WARPED_FUNGUS = BLOCKS.register(COLORED_WARPED_STRING, r ->
            new ColoredFungusBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                    .setId(ResourceKey.create(Registries.BLOCK, r)))
    );

    public static final DeferredBlock<Block> CHROMIUM_ORE = BLOCKS.registerSimpleBlock("chromium_ore");

    public static BlockState getDefaultBlockStateFromFungusType(String fungusType)
    {
        BlockState blockState;
        if(fungusType.equals(ModBlocks.COLORED_CRIMSON_STRING))
            blockState = ModBlocks.COLORED_CRIMSON_FUNGUS.get().defaultBlockState();
        else
            blockState = ModBlocks.COLORED_WARPED_FUNGUS.get().defaultBlockState();
        return blockState;
    }
}
