package com.simomett.mycologymod.blocks;

import net.minecraft.world.level.block.Block;

public interface IRegisteredBlock<T extends Block>
{
    T get();
}
