package com.simomett.mycologymod.datacomponents;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class NeoForgeDataComponentType<T> implements IRegisteredDataComponentType<T>
{
    private final Supplier<DataComponentType<T>> supplier;
    public NeoForgeDataComponentType(DeferredHolder<DataComponentType<?>, DataComponentType<T>> t)
    {
        this.supplier = t;
    }

    public DataComponentType<T> dataComponentType()
    {
        return supplier.get();
    }
}
