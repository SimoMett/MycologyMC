package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.datacomponents.DataComponentTypes;
import com.simomett.mycologymod.effects.player.EffectsDefinitions;
import com.simomett.mycologymod.entities.BlockEntitiesDefinitions;
import com.simomett.mycologymod.items.ItemsDefinitions;
import com.simomett.mycologymod.items.potions.Potions;
import com.simomett.mycologymod.world.FeaturesDefinitions;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class CommonClass
{

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init()
    {
        EffectsDefinitions.init();
        Potions.init();
        DataComponentTypes.init();
        BlocksDefinitions.init();
        ItemsDefinitions.init();
        BlockEntitiesDefinitions.init();
        FeaturesDefinitions.init();
    }
}
