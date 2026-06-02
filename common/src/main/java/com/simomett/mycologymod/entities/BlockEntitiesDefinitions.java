package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.platform.Services;

public class BlockEntitiesDefinitions
{
    public static final IRegisteredBlockEntityType<ColoredFungusBlockEntity> COLORED_FUNGUS_BLOCK_ENTITY = Services.PLATFORM.registerBlockEntityType("colored_fungus",
            ColoredFungusBlockEntity::new,
            BlocksDefinitions.COLORED_CRIMSON_FUNGUS,
            BlocksDefinitions.COLORED_WARPED_FUNGUS,
            BlocksDefinitions.FUNGUS_POT,
            BlocksDefinitions.POTTED_COLORED_CRIMSON,
            BlocksDefinitions.POTTED_COLORED_WARPED
    );

    public static void init(){}
}
