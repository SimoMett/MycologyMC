package com.mettsmirnov.mycology.blocks;

import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ColoredFungusBlock extends BushBlock
{
    public ColoredFungusBlock()
    {
        super(BlockBehaviour.Properties.of(Material.PLANT)
                .sound(SoundType.GRASS)
                .noCollission()
                .randomTicks());
    }
}
