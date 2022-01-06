package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.blocks.ColoredFungusBlock;
import com.mettsmirnov.mycology.data.FungusTraits;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import com.mettsmirnov.mycology.items.ColoredFungusItem;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FungusDataAttacher
{
    private static class FungusDataProvider implements ICapabilitySerializable<CompoundTag>
    {
        public static final ResourceLocation IDENTIFIER = new ResourceLocation(MycologyMod.MODID,"fungus_data");

        private final IFungusData backend;//FIXME
        private final LazyOptional<IFungusData> optionalData;

        public FungusDataProvider()
        {
            backend = new FungusData();
            optionalData = LazyOptional.of(()->backend);
        }

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side)
        {
            return FungusDataCapability.INSTANCE.orEmpty(cap,this.optionalData);
        }

        void invalidate()
        {
            this.optionalData.invalidate();
        }

        @Override
        public CompoundTag serializeNBT() {
            return this.backend.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.backend.deserializeNBT(nbt);
        }
    }

    @SubscribeEvent
    public static void onAttachToItemStack(AttachCapabilitiesEvent<ItemStack> evt)
    {
        if(evt.getObject().getItem() instanceof ColoredFungusItem)
        {
            final FungusDataProvider provider = new FungusDataProvider();
            evt.addCapability(FungusDataProvider.IDENTIFIER, provider);
        }
    }

    @SubscribeEvent
    public static void onAttachToBlockEntity(AttachCapabilitiesEvent<BlockEntity> evt)
    {
        if(evt.getObject() instanceof ColoredFungusBlockEntity)
        {
            final FungusDataProvider provider = new FungusDataProvider();
            evt.addCapability(FungusDataProvider.IDENTIFIER, provider);
        }
    }

}
