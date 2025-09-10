package com.simomett.mycologymod.blocks;

import net.minecraft.world.level.block.Block;

public class FabricRegisteredBlock<T extends Block> implements IRegisteredBlock<T>
{
    private final Block block;
    public FabricRegisteredBlock(Block block)
    {
        this.block = block;
    }

    @Override
    public Block get()
    {
        return null;
    }
}
