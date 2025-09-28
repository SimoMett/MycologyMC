package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class BlocksDefinitions
{
    public static final String COLORED_CRIMSON_STRING = "colored_crimson_fungus";
    public static final String COLORED_WARPED_STRING = "colored_warped_fungus";

    public static final IRegisteredBlock<ColoredFungusBlock> COLORED_CRIMSON_FUNGUS = Services.PLATFORM.registerBlock(COLORED_CRIMSON_STRING, (p) ->
            new ColoredFungusBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, COLORED_CRIMSON_STRING))))
    );

    public static final IRegisteredBlock<ColoredFungusBlock> COLORED_WARPED_FUNGUS = Services.PLATFORM.registerBlock(COLORED_WARPED_STRING, (p) ->
            new ColoredFungusBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BROWN_MUSHROOM)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, COLORED_WARPED_STRING))))
    );

    public static final IRegisteredBlock<FungusAnalysingStationBlock> FUNGUS_ANALYSING_STATION = Services.PLATFORM.registerBlock("fungus_analysing_station", p ->
            new FungusAnalysingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungus_analysing_station")))));

    public static final IRegisteredBlock<FungusPotBlock> FUNGUS_POT = Services.PLATFORM.registerBlock("fungus_pot", (p) ->
            new FungusPotBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.FLOWER_POT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungus_pot"))))
    );

    public static final IRegisteredBlock<FungusPotBlock> POTTED_COLORED_CRIMSON = Services.PLATFORM.registerBlock("potted_colored_crimson",
            (p) -> {
                FungusPotBlock b = new FungusPotBlock(COLORED_CRIMSON_FUNGUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                        .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "potted_colored_crimson"))));
                return b;
            });

    public static final IRegisteredBlock<FungusPotBlock> POTTED_COLORED_WARPED = Services.PLATFORM.registerBlock("potted_colored_warped",
            (p) -> {
                FungusPotBlock b = new FungusPotBlock(COLORED_WARPED_FUNGUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                        .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "potted_colored_warped"))));
                return b;
            });

    public static final IRegisteredBlock<Block> CHROMIUM_ORE = Services.PLATFORM.registerBlock("chromium_ore", (p) ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_ore")))
                    .requiresCorrectToolForDrops())
    );
    public static final IRegisteredBlock<Block> CHROMIUM_BLOCK = Services.PLATFORM.registerBlock("chromium_block", (p) ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_block")))
                    .requiresCorrectToolForDrops())
    );


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
