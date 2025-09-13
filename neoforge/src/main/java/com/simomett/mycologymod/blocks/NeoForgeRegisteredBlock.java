package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeRegisteredBlock<T extends Block> implements IRegisteredBlock<T>
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

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
