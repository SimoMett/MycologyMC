package com.simomett.mycologymod.blocks;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class NeoForgeRegisteredBlock<T extends Block> implements IRegisteredBlock<T>
{
    private final DeferredBlock<Block> deferredBlock;

    public NeoForgeRegisteredBlock(DeferredBlock<Block> deferredBlock)
    {
        this.deferredBlock = deferredBlock;
    }

    public Holder<Block> holder()
    {
        return deferredBlock;
    }

    @Override
    public Block get()
    {
        return deferredBlock.get();
    }
}
