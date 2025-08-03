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

    /*public static final DeferredBlock<FungusAnalysingStationBlock> FUNGUS_ANALYSING_STATION = BLOCKS.register("fungus_analysing_station", r ->
            new FungusAnalysingStationBlock(BlockBehaviour.Properties.ofFullCopy(BlockDefinitions.CAULDRON)
                    .setId(ResourceKey.create(Registries.BLOCK, r))));

    public static final DeferredBlock<FungusPotBlock> FUNGUS_POT = BLOCKS.register("fungus_pot",
            (r) -> new FungusPotBlock(BlockBehaviour.Properties.ofFullCopy(BlockDefinitions.FLOWER_POT)
                    .setId(ResourceKey.create(Registries.BLOCK, r))));

    public static final DeferredBlock<FungusPotBlock> POTTED_COLORED_CRIMSON = BLOCKS.register("potted_colored_crimson",
            (r) -> {
                    FungusPotBlock b = new FungusPotBlock(COLORED_CRIMSON_FUNGUS, BlockBehaviour.Properties.ofFullCopy(BlockDefinitions.FLOWER_POT)
                                    .setId(ResourceKey.create(Registries.BLOCK, r)));
                    FUNGUS_POT.get().addPlant(COLORED_CRIMSON_FUNGUS.getId(), ()->b);
                    return b;
    });

    public static final DeferredBlock<FungusPotBlock> POTTED_COLORED_WARPED = BLOCKS.register("potted_colored_warped",
            (r) -> {
                FungusPotBlock b = new FungusPotBlock(COLORED_WARPED_FUNGUS, BlockBehaviour.Properties.ofFullCopy(BlockDefinitions.FLOWER_POT)
                        .setId(ResourceKey.create(Registries.BLOCK, r)));
                FUNGUS_POT.get().addPlant(COLORED_WARPED_FUNGUS.getId(), ()->b);
                return b;
            });*/

    public static final DeferredBlock<Block> CHROMIUM_ORE = BLOCKS.register("chromium_ore", BlocksDefinitions.CHROMIUM_ORE);
    public static final DeferredBlock<Block> CHROMIUM_BLOCK = BLOCKS.register("chromium_block", BlocksDefinitions.CHROMIUM_BLOCK);
}
