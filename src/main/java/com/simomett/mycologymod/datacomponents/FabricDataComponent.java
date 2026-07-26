package com.simomett.mycologymod.datacomponents;

import net.minecraft.core.component.DataComponentType;

public record FabricDataComponent<T>(
        DataComponentType<T> dataComponentType) implements IRegisteredDataComponentType<T> {
}
