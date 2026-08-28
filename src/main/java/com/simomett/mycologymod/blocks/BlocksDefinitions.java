package com.simomett.mycologymod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import static com.simomett.mycologymod.blocks.FabricRegisteredBlock.registerBlock;

public class BlocksDefinitions
{
    public static final String COLORED_CRIMSON_STRING = "colored_crimson_fungus";
    public static final String COLORED_WARPED_STRING = "colored_warped_fungus";

    public static final IRegisteredBlock<ColoredFungusBlock> COLORED_CRIMSON_FUNGUS = registerBlock(
            COLORED_CRIMSON_STRING,
            ColoredFungusBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
    );

    public static final IRegisteredBlock<ColoredFungusBlock> COLORED_WARPED_FUNGUS = registerBlock(
            COLORED_WARPED_STRING,
            ColoredFungusBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
    );

    public static final IRegisteredBlock<FungusPotBlock> FUNGUS_POT = registerBlock(
            "fungus_pot",
            FungusPotBlock::new,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
    );

    public static final IRegisteredBlock<FungusPotBlock> POTTED_COLORED_CRIMSON = registerBlock(
            "potted_colored_crimson",
            FungusPotBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
    );

    public static final IRegisteredBlock<FungusPotBlock> POTTED_COLORED_WARPED = registerBlock(
            "potted_colored_warped",
            FungusPotBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
    );

    public static final IRegisteredBlock<Block> CHROMIUM_ORE = registerBlock(
            "chromium_ore",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE).requiresCorrectToolForDrops()
    );
    public static final IRegisteredBlock<Block> CHROMIUM_BLOCK = registerBlock(
            "chromium_block",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE).requiresCorrectToolForDrops()
    );

    public static final IRegisteredBlock<StairBlock> CHROMIUM_STAIRS = registerBlock("chromium_stairs",
            (p) -> new StairBlock(CHROMIUM_BLOCK.get().defaultBlockState(), p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_STAIRS)
    );

    public static final IRegisteredBlock<FungusAnalysingStationBlock> ANALYSING_STATION = registerBlock("analysing_station",
            FungusAnalysingStationBlock::new,
            BlockBehaviour.Properties.ofFullCopy(BlocksDefinitions.CHROMIUM_BLOCK.get()));

    public static BlockState getDefaultBlockStateFromFungusType(String fungusType)
    {
        BlockState blockState;
        if(fungusType.equals(COLORED_CRIMSON_STRING))
            blockState = COLORED_CRIMSON_FUNGUS.get().defaultBlockState();
        else
            blockState = COLORED_WARPED_FUNGUS.get().defaultBlockState();
        return blockState;
    }

    public static void init() {}
}
