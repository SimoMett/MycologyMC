package com.simomett.mycologymod.datacomponents;

import net.minecraft.core.component.DataComponentType;

public class FabricDataComponent<T> implements IRegisteredDataComponentType<T>
{
    private final DataComponentType<T> dataComponentType;

    public FabricDataComponent(DataComponentType<T> dataComponentType)
    {
        this.dataComponentType = dataComponentType;
    }

    @Override
    public DataComponentType<T> dataComponentType()
    {
        return dataComponentType;
    }
}
