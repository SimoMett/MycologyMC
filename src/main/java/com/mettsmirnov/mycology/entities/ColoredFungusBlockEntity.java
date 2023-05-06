package com.mettsmirnov.mycology.entities;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.effects.MobEffectInstanceProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final FungusDataModel fungusDataModel = new FungusDataModel();

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_FUNGUS.get(), blockPos, blockState);
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        fungusDataModel.deserializeNBT(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        tag.merge(fungusDataModel.serializeNBT());
        super.saveAdditional(tag);
    }

    private static Instant lastInstant = Instant.now();
    public void tick()
    {
        Level world = this.getLevel();
        BlockPos pos = this.getBlockPos();
        IFungusData fungusData = fungusDataModel;

        // FIXME check when this occurs
        if(fungusData.getField(FungusDataModel.AREA, IFungusData.GeneType.DOMINANT)=="none")
            return;
        //

        String fungusEffect = (String) fungusData.getField(FungusDataModel.EFFECT, IFungusData.GeneType.DOMINANT);
        if(!Objects.equals(fungusEffect, "none"))
        {
            int areaRadius = (Integer) fungusData.getField(FungusDataModel.AREA, IFungusData.GeneType.DOMINANT);
            List<LivingEntity> entityList = getEntityListInAreaRadius(areaRadius);

            for (LivingEntity entity : entityList)
            {
                if (entity.distanceToSqr(pos.getCenter()) < areaRadius)
                {
                    if (Duration.between(lastInstant, Instant.now()).getSeconds() > 1)
                    {
                        applyEffectToEntity(entity, fungusEffect);
                        lastInstant = Instant.now();
                    }
                }
            }
        }
    }

    private void applyEffectToEntity(LivingEntity entity, String effectString)
    {
        final int numOfTicks = 100; //this value is hardcoded and should not be configurable.
        entity.addEffect(new MobEffectInstance(MobEffectInstanceProvider.getMobEffectByName(effectString),numOfTicks));
    }

    private List<LivingEntity> getEntityListInAreaRadius(int radius)
    {
        Level level = this.getLevel();
        BlockPos pos = this.getBlockPos();
        AABB boxArea = new AABB(
                pos.getX() - (radius+1),
                pos.getY() - (radius+1),
                pos.getZ() - (radius+1),
                pos.getX() + radius,
                pos.getY() + radius,
                pos.getZ() + radius
        );
        assert level != null;
        return level.getEntitiesOfClass(LivingEntity.class, boxArea);
    }

    public final FungusDataModel getFungusData()
    {
        return fungusDataModel;
    }

    //Server-Client synchronization
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void setChanged()
    {
        super.setChanged();
        if (this.level != null) {

            BlockState blockState = this.getBlockState();
            (this.level).sendBlockUpdated(this.getBlockPos(), blockState, blockState, 3);
        }
    }

    @Override
    public CompoundTag getUpdateTag()
    {
        CompoundTag tag = super.getUpdateTag();
        tag.merge(fungusDataModel.serializeNBT());
        return tag;
    }

    //this method automatically calls load(tag). Hence, no need to override
    /*
    @Override
    public void handleUpdateTag(CompoundTag tag){
        super.handleUpdateTag(tag);
        fungusDataModel.deserializeNBT(tag);
    }
    */
}
