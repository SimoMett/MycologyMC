package com.simomett.mycologymod.datacomponents;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.*;

public class NeoForgeDataComponents
{
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Constants.MOD_ID);

    public static final Supplier<DataComponentType<FungusGenoma>> FUNGUS_GENOMA = DATA_COMPONENTS.registerComponentType(GENOMA_DATA_COMPONENT_NAME,
            builder ->
                    builder
                            .persistent(FUNGUS_GENOMA_CODEC)
                            .networkSynchronized(FUNGUS_GENOMA_STREAM_CODEC)
    );
}
