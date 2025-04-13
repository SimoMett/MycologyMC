package com.simomett.mycologymod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ColoredByStateBlock extends Block
{
    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 0xffffff);

    public ColoredByStateBlock(Properties properties)
    {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(COLOR, 0x00ffff));
    }
}
