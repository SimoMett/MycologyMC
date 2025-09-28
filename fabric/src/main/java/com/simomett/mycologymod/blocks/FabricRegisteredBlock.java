package com.simomett.mycologymod.blocks;

import net.minecraft.world.level.block.Block;

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
}
