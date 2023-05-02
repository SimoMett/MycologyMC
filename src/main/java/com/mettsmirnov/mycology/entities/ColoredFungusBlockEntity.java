package com.mettsmirnov.mycology.entities;

import com.mettsmirnov.mycology.capabilities.FungusData;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

import java.util.List;

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
        /*TODO
        * find first all entities inside a boxArea that is bigger then testRadius
        * then for each entity check if distance is less then testRadius
        * */
        float testRadius = 3f;
        Level level = this.getLevel();
        BlockPos pos = this.getBlockPos();
        BlockState blockState = this.getBlockState();
        AABB boxArea = new AABB(
                pos.getX() - (testRadius+1),
                pos.getY() - (testRadius+1),
                pos.getZ() - (testRadius+1),
                pos.getX() + testRadius,
                pos.getY() + testRadius,
                pos.getZ() + testRadius
        );
        List<LivingEntity> entityList = level.getEntitiesOfClass(LivingEntity.class, boxArea);
        for(LivingEntity entity : entityList)
        {
            Log.info(entity.distanceToSqr(pos.getCenter()));
        }
    }
}
