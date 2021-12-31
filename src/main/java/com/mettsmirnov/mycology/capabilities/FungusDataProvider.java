package com.mettsmirnov.mycology.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FungusDataProvider implements ICapabilityProvider
{

    public static Capability<IFungusData> INSTANCE = CapabilityManager.get(new CapabilityToken<IFungusData>() {});

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return null;
    }

}
