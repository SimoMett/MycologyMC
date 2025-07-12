package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
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

    public static final DeferredBlock<FungusAnalysingStationBlock> FUNGUS_ANALYSING_STATION = BLOCKS.register("fungus_analysing_station", r ->
            new FungusAnalysingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)
                    .setId(ResourceKey.create(Registries.BLOCK, r))));

    public static final DeferredBlock<FungusPotBlock> FUNGUS_POT = BLOCKS.register("fungus_pot",
            (r) -> new FungusPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                    .setId(ResourceKey.create(Registries.BLOCK, r))));

    public static final DeferredBlock<FungusPotBlock> POTTED_COLORED_CRIMSON = BLOCKS.register("potted_colored_crimson",
            (r) -> {
                    FungusPotBlock b = new FungusPotBlock(ModBlocks.COLORED_CRIMSON_FUNGUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                                    .setId(ResourceKey.create(Registries.BLOCK, r)));
                    FUNGUS_POT.get().addPlant(COLORED_CRIMSON_FUNGUS.getId(), ()->b);
                    return b;
    });

    public static final DeferredBlock<FungusPotBlock> POTTED_COLORED_WARPED = BLOCKS.register("potted_colored_warped",
            (r) -> {
                FungusPotBlock b = new FungusPotBlock(ModBlocks.COLORED_WARPED_FUNGUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                        .setId(ResourceKey.create(Registries.BLOCK, r)));
                FUNGUS_POT.get().addPlant(COLORED_WARPED_FUNGUS.getId(), ()->b);
                return b;
            });

    public static final DeferredBlock<Block> CHROMIUM_ORE = BLOCKS.registerSimpleBlock("chromium_ore",
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> CHROMIUM_BLOCK = BLOCKS.registerSimpleBlock("chromium_block",
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE).requiresCorrectToolForDrops());

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
