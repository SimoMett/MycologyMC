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

    public static final Supplier<ColoredFungusBlock> COLORED_CRIMSON_FUNGUS = () ->
            new ColoredFungusBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BROWN_MUSHROOM)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, COLORED_CRIMSON_STRING)))
    );

    public static final Supplier<ColoredFungusBlock> COLORED_WARPED_FUNGUS = () ->
            new ColoredFungusBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BROWN_MUSHROOM)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, COLORED_WARPED_STRING)))
    );

    /*public static final DeferredBlock<FungusAnalysingStationBlock> FUNGUS_ANALYSING_STATION = BLOCKS.register("fungus_analysing_station", r ->
            new FungusAnalysingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)
                    .setId(ResourceKey.create(Registries.BLOCK, r))));

    public static final DeferredBlock<FungusPotBlock> FUNGUS_POT = BLOCKS.register("fungus_pot",
            (r) -> new FungusPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                    .setId(ResourceKey.create(Registries.BLOCK, r))));

    public static final DeferredBlock<FungusPotBlock> POTTED_COLORED_CRIMSON = BLOCKS.register("potted_colored_crimson",
            (r) -> {
                FungusPotBlock b = new FungusPotBlock(COLORED_CRIMSON_FUNGUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                        .setId(ResourceKey.create(Registries.BLOCK, r)));
                FUNGUS_POT.get().addPlant(COLORED_CRIMSON_FUNGUS.getId(), ()->b);
                return b;
            });

    public static final DeferredBlock<FungusPotBlock> POTTED_COLORED_WARPED = BLOCKS.register("potted_colored_warped",
            (r) -> {
                FungusPotBlock b = new FungusPotBlock(COLORED_WARPED_FUNGUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                        .setId(ResourceKey.create(Registries.BLOCK, r)));
                FUNGUS_POT.get().addPlant(COLORED_WARPED_FUNGUS.getId(), ()->b);
                return b;
            });
*/
    public static final Block CHROMIUM_ORE = Services.PLATFORM.registerBlock("chromium_ore", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DEEPSLATE_LAPIS_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_ore")))
                    .requiresCorrectToolForDrops())
    );
    public static final Block CHROMIUM_BLOCK = Services.PLATFORM.registerBlock("chromium_block", () ->
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
}
