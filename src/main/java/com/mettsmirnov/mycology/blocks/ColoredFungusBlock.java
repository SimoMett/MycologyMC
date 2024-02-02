package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.effects.FungusEffects;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import com.mettsmirnov.mycology.entities.ModEntities;
import com.mettsmirnov.mycology.genetics.Breeding;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static com.mettsmirnov.mycology.constants.Constants.BREEDING_CHANCE;
import static com.mettsmirnov.mycology.constants.Constants.MAX_MUSHROOMS_IN_AREA;
import static com.mettsmirnov.mycology.datagen.SpeciesBuilder.CRIMSON_TYPE;

public class ColoredFungusBlock extends BushBlock implements EntityBlock
{
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);

    public ColoredFungusBlock()
    {
        super(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM));
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

    @Override //deprecated
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        BlockPos originalPos = pos;
        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(originalPos));
        FungusDataModel thisFungusData = originBlockEntity.getFungusData();

        //code copied from MushroomBlock.randomTick
        //TODO use nbt data instead of magic numbers
        int spreading = (int)thisFungusData.getField(FungusDataModel.SPREADING, IFungusData.GeneType.DOMINANT);//TODO implement spreadboost
        if (rand.nextInt(spreading) == 0)
        {
            //check if there are 'i' mushrooms in area
            //if it does then prevent spreading
            int i = MAX_MUSHROOMS_IN_AREA;
            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4)))
            {
                if (level.getBlockState(blockpos).is(this))
                {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            // find a random position for the new block
            BlockPos blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            // 4 tries
            for(int k = 0; k < 4; ++k)
            {
                if (level.isEmptyBlock(blockpos1) && blockState.canSurvive(level, blockpos1))
                {
                    pos = blockpos1;
                }

                blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            //mushroom spreading (and breeding) procedure
            if (level.isEmptyBlock(blockpos1))
            {
                Random dice = new Random();
                boolean crossBreeding = dice.nextInt(BREEDING_CHANCE) == 0; //FIXME adjust BREEDING_CHANCE

                // check if there are any different fungi nearby (by 'nearby' I mean the dominant "area" trait)
                int radius = (Integer)thisFungusData.getField(FungusDataModel.AREA);
                ArrayList<ColoredFungusBlockEntity> nearbyFungi = getFungiInArea(level, blockpos1, radius);

                if (crossBreeding && !nearbyFungi.isEmpty())
                {
                    // precalculate the genotype
                    ColoredFungusBlockEntity randomBlockEntity = nearbyFungi.get(new Random().nextInt(nearbyFungi.size()));
                    FungusDataModel offspringDataModel = Breeding.crossBreed(randomBlockEntity.getFungusData(), thisFungusData);

                    // if the environment requisites for the fungus are matched ...
                    int light = level.getBrightness(LightLayer.SKY, blockpos1);
                        //LightLayer.SKY is the light level of a block due to other blocks obstructing skylight. 0 is in complete darkness, 15 is in plain air.
                        //LightLayer.BLOCK is the light level of a block due to other sources of light (Glowstone, torches..).

                    float temperature = level.getBiome(blockpos1).get().getModifiedClimateSettings().temperature();
                        // getBaseTemperature() or getModifiedClimateSettings().temperature() ?
                        // they seems to be the same...

                    float humidity = level.getBiome(blockpos1).get().getModifiedClimateSettings().downfall();

                    String fungusType = FungusSpeciesList.INSTANCE.get((String) offspringDataModel.getField(FungusDataModel.SPECIES)).fungusType;
                    if (Objects.equals(fungusType, CRIMSON_TYPE))
                        blockState = ModBlocks.COLORED_CRIMSON_FUNGUS.get().defaultBlockState();
                    else
                        blockState = ModBlocks.COLORED_WARPED_FUNGUS.get().defaultBlockState();

                    if (offspringDataModel.matchesEnvironmentAndTerrain(light, temperature, humidity, level.getBlockState(blockpos1.below())))
                    {
                        // ... then place it
                        placeFungusBlock(blockState, level, blockpos1, offspringDataModel);
                        return;
                    }
                }

                //otherwise proceed with normal spreading
                if (blockState.canSurvive(level, blockpos1))
                    placeFungusBlock(blockState, level, blockpos1, thisFungusData);
            }
        }
        //TODO implement here area effect
        String fungusEffect = (String) thisFungusData.getField(FungusDataModel.EFFECT);
        if(!fungusEffect.equals("none"))
        {
            int areaRadius = (Integer) thisFungusData.getField(FungusDataModel.AREA);
            FungusEffects.getEffectByName(fungusEffect).applyEffectToLevel(level, pos, areaRadius);
        }
    }

    private static void placeFungusBlock(BlockState blockState, ServerLevel level, BlockPos pos, FungusDataModel dataModel)
    {
        level.setBlock(pos, blockState, 2); //wtf is this '2'?
        ColoredFungusBlockEntity newBlockEntity = (ColoredFungusBlockEntity) (level.getBlockEntity(pos));
        if (newBlockEntity != null)
        {
            newBlockEntity.getFungusData().deserializeNBT(dataModel.serializeNBT());
        }
    }

    private static ArrayList<ColoredFungusBlockEntity> getFungiInArea(ServerLevel level, BlockPos pos, int radius)
    {
        AABB boxArea = new AABB(
                pos.getX() - (radius +1),
                pos.getY() - (radius +1),
                pos.getZ() - (radius +1),
                pos.getX() + radius,
                pos.getY() + radius,
                pos.getZ() + radius
        );
        ArrayList<ColoredFungusBlockEntity> fungusBlockEntities = new ArrayList<>();
        BlockPos.betweenClosedStream(boxArea)
                .filter(blockPos -> level.getBlockEntity(blockPos) instanceof ColoredFungusBlockEntity)
                .forEach(blockPos -> fungusBlockEntities.add((ColoredFungusBlockEntity) level.getBlockEntity(blockPos)));
        return fungusBlockEntities;
    }
}
