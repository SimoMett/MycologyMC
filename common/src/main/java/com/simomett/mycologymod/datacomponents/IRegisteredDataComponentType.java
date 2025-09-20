package com.simomett.mycologymod.datacomponents;

import net.minecraft.core.component.DataComponentType;

public interface IRegisteredDataComponentType<T>
{
    DataComponentType<T> dataComponentType();
}
