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

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final IFungusData fungusDataModel = new FungusDataModel();

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_FUNGUS.get(), blockPos, blockState);
    }

    //READ PLEASE
    /*
    * According to my understanding, there's no need to override the load and save method
    * because the capability seems to already loading and saving data itself.
    *
    @Override
    public void load(CompoundTag tag)
    {
        CompoundTag capTag = tag.getCompound("ForgeCaps").getCompound(MycologyMod.MODID+":fungus_data");
        fungusData.deserializeNBT(capTag);
        super.load(tag);
    }*/

    private static Instant lastInstant = Instant.now();
    public void tick()
    {
        Level world = this.getLevel();
        BlockPos pos = this.getBlockPos();
        IFungusData fungusData = world.getBlockEntity(pos).getCapability(FungusDataCapability.INSTANCE).resolve().get();

        // FIXME check when this occurs
        if(fungusData.getField(FungusDataModel.AREA, IFungusData.GeneType.DOMINANT)=="none")
            return;
        //

        int areaRadius = (Integer) fungusData.getField(FungusDataModel.AREA, IFungusData.GeneType.DOMINANT);
        List<LivingEntity> entityList = getEntityListInAreaRadius(areaRadius);
        String fungusEffect = (String) fungusData.getField(FungusDataModel.EFFECT, IFungusData.GeneType.DOMINANT);

        for(LivingEntity entity : entityList)
        {
            if(entity.distanceToSqr(pos.getCenter()) < areaRadius)
            {
                if(Duration.between(lastInstant,Instant.now()).getSeconds() > 1f)
                {
                    applyEffectToEntity(entity,fungusEffect);
                    lastInstant = Instant.now();
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
}
