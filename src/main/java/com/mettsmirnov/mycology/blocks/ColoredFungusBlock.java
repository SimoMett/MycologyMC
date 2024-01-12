package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import com.mettsmirnov.mycology.entities.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class ColoredFungusBlock extends BushBlock implements EntityBlock
{
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);

    public ColoredFungusBlock()
    {
        super(BlockBehaviour.Properties.of(Material.PLANT)
                .sound(SoundType.GRASS)
                .noCollission()
                .randomTicks());
    }

    @Override //deprecated
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return ModEntities.COLORED_FUNGUS.get().create(blockPos, blockState);
    }
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player)
    {
        ItemStack stack = super.getCloneItemStack(state, target, world, pos, player);
        FungusDataModel fungusData = ((ColoredFungusBlockEntity) world.getBlockEntity(pos)).getFungusData();
        CompoundTag tags = fungusData.serializeNBT();
        stack.getCapability(FungusDataCapability.INSTANCE).resolve().get().deserializeNBT(tags);
        return stack;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type)
    {
        return level.isClientSide()? null : ($0, pos, $1, blockEntity) ->{
            if(blockEntity instanceof ColoredFungusBlockEntity coloredFungusBlockEntity)
            {
                coloredFungusBlockEntity.tick();
            }
        };
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos pos)
    {
        //TODO proper implementation
        return !level.getBlockState(pos.below()).isAir();
    }

    @Override //deprecated
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        BlockPos originalPos = pos;
        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(originalPos));
        FungusDataModel fungusData = originBlockEntity.getFungusData();

        //code copied from MushroomBlock.randomTick
        //TODO use nbt data instead of magic numbers
        int spreading = (int)fungusData.getField(FungusDataModel.SPREADING, IFungusData.GeneType.DOMINANT);//TODO implement spreadboost
        if (rand.nextInt(spreading) == 0)
        {
            //check if there are 'i' mushroom in area
            //if it does then prevent spreading
            int i = 5;
            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
                if (level.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }
            //

            BlockPos blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (level.isEmptyBlock(blockpos1) && blockState.canSurvive(level, blockpos1))
                {
                    pos = blockpos1;
                }

                blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            //mushroom spreading procedure
            if (level.isEmptyBlock(blockpos1) && blockState.canSurvive(level, blockpos1))
            {
                level.setBlock(blockpos1, blockState, 2);
                ColoredFungusBlockEntity newBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(blockpos1));
                if(newBlockEntity != null)
                {
                    newBlockEntity.getFungusData().deserializeNBT(fungusData.serializeNBT());
                }
            }
            //
        }
    }
}
