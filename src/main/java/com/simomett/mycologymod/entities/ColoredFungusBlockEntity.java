package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.effects.FungusEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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

import static com.simomett.mycologymod.datacomponents.ModDataAttachmentTypes.FUNGUS_GENOMA_ATTACHMENT;
import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class ColoredFungusBlockEntity extends BlockEntity
{

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_FUNGUS.get(), blockPos, blockState);
    }

    private static Instant lastInstant = Instant.now();
    public void tick()
    {
        BlockPos pos = this.getBlockPos();

        String fungusEffect = getFungusGenoma().getDominantTraits().effect();
        int areaRadius = getFungusGenoma().getDominantTraits().area();
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

    public final FungusGenoma getFungusGenoma()
    {
        return components().get(FUNGUS_GENOMA.get());
    }

    public void applyGenoma(FungusGenoma fungusGenoma)
    {
        if(fungusGenoma!=null)
        {
            FungusGenoma genoma = new FungusGenoma(fungusGenoma.getDominantTraits(), fungusGenoma.getRecessiveTraits());
            setComponents(DataComponentMap.builder().set(FUNGUS_GENOMA, genoma).build());
        }
        else
            Log.error("Cannot apply null genoma");
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
}
