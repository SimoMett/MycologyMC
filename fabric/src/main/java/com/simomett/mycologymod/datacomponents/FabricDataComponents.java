package com.simomett.mycologymod.datacomponents;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.*;

public class FabricDataComponents
{
    public static final DataComponentType<FungusGenoma> FUNGUS_GENOMA = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, GENOMA_DATA_COMPONENT_NAME),
            DataComponentType.<FungusGenoma>builder()
                    .persistent(FUNGUS_GENOMA_CODEC)
                    .networkSynchronized(FUNGUS_GENOMA_STREAM_CODEC)
                    .build()
    );
}
