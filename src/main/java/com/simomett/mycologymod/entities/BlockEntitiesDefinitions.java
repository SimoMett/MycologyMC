package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.blocks.IRegisteredBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BlockEntitiesDefinitions
{
    private static  <T extends BlockEntity> IRegisteredBlockEntityType<T> registerBlockEntityType(String name, IBlockEntityConstructor<BlockPos, BlockState, T> factory, IRegisteredBlock<?>... blocks)
    {
        // Junk to avoid cast-related crash
        Set<Block> bb = Arrays.stream(blocks).map(IRegisteredBlock::get).collect(Collectors.toSet());
        Block [] actualBlocks = new Block[bb.size()];
        bb.toArray(actualBlocks);
        //

        BlockEntityType<T> blockEntityType = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(
                        factory::apply,
                        actualBlocks
                ).build());

        return new FabricRegisteredBlockEntityType<>(blockEntityType);
    }


    public static final IRegisteredBlockEntityType<ColoredFungusBlockEntity> COLORED_FUNGUS_BLOCK_ENTITY = registerBlockEntityType("colored_fungus",
            ColoredFungusBlockEntity::new,
            BlocksDefinitions.COLORED_CRIMSON_FUNGUS,
            BlocksDefinitions.COLORED_WARPED_FUNGUS,
            BlocksDefinitions.FUNGUS_POT,
            BlocksDefinitions.POTTED_COLORED_CRIMSON,
            BlocksDefinitions.POTTED_COLORED_WARPED
    );

    public static void init(){}
}
