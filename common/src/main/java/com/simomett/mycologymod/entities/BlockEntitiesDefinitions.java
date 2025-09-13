package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.platform.Services;

public class BlockEntitiesDefinitions
{
    public static final IRegisteredBlockEntityType<ColoredFungusBlockEntity> COLORED_FUNGUS_BLOCK_ENTITY = Services.PLATFORM.registerBlockEntityType("colored_fungus",
            ColoredFungusBlockEntity::new,
            BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
            BlocksDefinitions.COLORED_WARPED_FUNGUS.get()
            /*BlockNames.FUNGUS_POT.get(),
            BlockNames.POTTED_COLORED_CRIMSON.get(),
            BlockNames.POTTED_COLORED_WARPED.get()*/
    );

    public static void init(){}
}
