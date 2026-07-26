package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class FabricRegisteredBlock<T extends Block> implements IRegisteredBlock<T>
{
    private final T block;
    public FabricRegisteredBlock(T block)
    {
        this.block = block;
    }

    @Override
    public T get()
    {
        return block;
    }

    public static <T extends Block> IRegisteredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties)
    {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, name));
        Function<BlockBehaviour.Properties, Block> castFactory = factory::apply;
        return new FabricRegisteredBlock(Blocks.register(key, castFactory,
                properties.setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Constants.MOD_ID, name)))));
    }
}