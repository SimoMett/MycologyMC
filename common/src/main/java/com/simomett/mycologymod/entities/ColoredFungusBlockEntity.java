package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.genetics.FungusTraits;
import com.simomett.mycologymod.items.ItemsDefinitions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.*;
import static com.simomett.mycologymod.entities.BlockEntitiesDefinitions.COLORED_FUNGUS_BLOCK_ENTITY;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private FungusGenoma fungusGenoma = new FungusGenoma(FungusTraits.EMPTY, FungusTraits.EMPTY);

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(COLORED_FUNGUS_BLOCK_ENTITY.type(), blockPos, blockState);
    }

    @Override
    protected void loadAdditional(ValueInput input)
    {
        super.loadAdditional(input);
        if (input.child("components").isPresent())
        {
            fungusGenoma = new FungusGenoma(input.child("components").get()
                    .read(Constants.MOD_ID+":"+GENOMA_DATA_COMPONENT_NAME, FUNGUS_GENOMA_CODEC).get());
        }
    }

    private Instant lastInstant = Instant.now();
    public void tick()
    {
        String fungusEffect = getFungusGenoma().getDominantTraits().effect();
        if (FungusEffects.getEffectByName(fungusEffect).equals(FungusEffects.NO_EFFECT))
            return;

        if (Duration.between(lastInstant, Instant.now()).getSeconds() > 1)
        {
            BlockPos pos = this.getBlockPos();
            int areaRadius = getFungusGenoma().getDominantTraits().area();
            List<LivingEntity> entityList = getEntityListInAreaRadius(areaRadius);
            for (LivingEntity entity : entityList) {
                if (entity.distanceToSqr(pos.getCenter()) < (areaRadius * areaRadius))
                    FungusEffects.getEffectByName(fungusEffect).applyEffectToEntity(entity);
            }
            lastInstant = Instant.now();
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
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boxArea);
        entities.removeIf( (livingEntity ->
                livingEntity instanceof ServerPlayer player && player.getItemBySlot(EquipmentSlot.HEAD).is(ItemsDefinitions.SPORE_MASK.get())));
        return entities;
    }

    public final FungusGenoma getFungusGenoma()
    {
        return fungusGenoma;
    }

    public final void applyGenoma(FungusGenoma genoma)
    {
        if(genoma!=null)
        {
            this.fungusGenoma = genoma;
            this.setComponents(DataComponentMap.builder().set(FUNGUS_GENOMA.dataComponentType(), fungusGenoma).build());
        }
        else
            throw new NullPointerException("Cannot apply null genoma");
    }

    //Server-Client synchronization
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        CompoundTag fungusData = new CompoundTag();
        // FIXME awful work-around: part-2
        fungusData.put(Constants.MOD_ID+":"+GENOMA_DATA_COMPONENT_NAME, FUNGUS_GENOMA_CODEC.encodeStart(NbtOps.INSTANCE, fungusGenoma).getOrThrow());
        //
        CompoundTag components = new CompoundTag();
        components.put("components", fungusData);
        return components;
    }

    @Override
    public void setChanged()
    {
        super.setChanged();
        if (this.level != null) {

            BlockState blockState = this.getBlockState();
            this.level.sendBlockUpdated(this.getBlockPos(), blockState, blockState, 3);
        }
    }
}
