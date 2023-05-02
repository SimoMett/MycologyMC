package com.mettsmirnov.mycology.entities;

import com.mettsmirnov.mycology.capabilities.FungusData;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final IFungusData fungusData = new FungusData();

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_FUNGUS.get(), blockPos, blockState);
    }

    //READ PLEASE
    /*
    * According to my understanding, there's no need to override the load() and save() methods
    * because the capability seems to already load and save data itself.
    * */
    /*@Override
    public void load(CompoundTag tag)
    {
        CompoundTag capTag = tag.getCompound("ForgeCaps").getCompound(MycologyMod.MODID+":fungus_data");
        //fungusData.deserializeNBT(capTag);
        super.load(tag);
    }*/

    //Server-Client synchronization
    @Override
    public CompoundTag getUpdateTag()
    {
        return saveWithFullMetadata();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag)
    {
        load(tag);
        super.handleUpdateTag(tag);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt)
    {
        super.onDataPacket(net, pkt);
    }

    public void tick()
    {
        Level level = this.getLevel();
        BlockPos pos = this.getBlockPos();
        BlockState blockState = this.getBlockState();
        Log.info("Fungi tick");
    }
}
