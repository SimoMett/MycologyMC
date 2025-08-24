package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.simomett.mycologymod.blocks.BlocksDefinitions.COLORED_CRIMSON_STRING;
import static com.simomett.mycologymod.blocks.BlocksDefinitions.COLORED_WARPED_STRING;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    public static final DeferredBlock<ColoredFungusBlock> COLORED_CRIMSON_FUNGUS = BLOCKS.register(COLORED_CRIMSON_STRING, BlocksDefinitions.COLORED_CRIMSON_FUNGUS);
    public static final DeferredBlock<ColoredFungusBlock> COLORED_WARPED_FUNGUS = BLOCKS.register(COLORED_WARPED_STRING, BlocksDefinitions.COLORED_WARPED_FUNGUS);
}
