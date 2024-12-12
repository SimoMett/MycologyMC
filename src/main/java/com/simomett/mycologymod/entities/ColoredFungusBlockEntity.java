package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.effects.FungusEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final FungusGenoma fungusGenoma = new FungusGenoma();

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_FUNGUS.get(), blockPos, blockState);
    }

    /*public void load(CompoundTag tag)
    {
        super.load(tag);
        fungusGenoma.deserializeNBT(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        tag.merge(fungusGenoma.serializeNBT());
        super.saveAdditional(tag);
    }*/

    private static Instant lastInstant = Instant.now();
    public void tick()
    {
        BlockPos pos = this.getBlockPos();

        String fungusEffect = fungusGenoma.getField(FungusGenoma.EFFECT);
        int areaRadius = Integer.parseInt(getFungusData().getField(FungusGenoma.AREA));
        List<LivingEntity> entityList = getEntityListInAreaRadius(areaRadius);
        for (LivingEntity entity : entityList)
        {
            if (entity.distanceToSqr(pos.getCenter()) < (areaRadius*areaRadius))
            {
                if (Duration.between(lastInstant, Instant.now()).getSeconds() > 1)
                {
                    FungusEffects.getEffectByName(fungusEffect).applyEffectToEntity(entity);
                    lastInstant = Instant.now();
                }
            }
        }
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

    public final FungusGenoma getFungusData()
    {
        return fungusGenoma;
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

    /*@Override
    public CompoundTag getUpdateTag()
    {
        CompoundTag tag = super.getUpdateTag();
        tag.merge(fungusGenoma.serializeNBT());
        return tag;
    }*/
}
