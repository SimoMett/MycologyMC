package com.simomett.mycologymod.blocks;

import com.mojang.serialization.MapCodec;
import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.entities.ModEntities;
import com.simomett.mycologymod.particles.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

import java.util.ArrayList;
import java.util.Random;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;
import static com.simomett.mycologymod.config.ModCommonConfigs.*;
import static com.simomett.mycologymod.entities.ModEntities.COLORED_FUNGUS;
import static com.simomett.mycologymod.tags.ModBlockTags.CAN_PLANT_ON;


public class ColoredFungusBlock extends BushBlock implements EntityBlock
{
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);

    public ColoredFungusBlock()
    {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    }

    @Override //deprecated
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BushBlock> codec()//what is this for?
    {
        return null;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_51039_, BlockGetter p_51040_, BlockPos p_51041_)
    {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return COLORED_FUNGUS.get().create(blockPos, blockState);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player)
    {
        if (level.getBlockEntity(pos) instanceof ColoredFungusBlockEntity coloredFungusBlockEntity)
        {
            if (!level.isClientSide && !player.isCreative())
            {
                ItemStack itemStack = new ItemStack(this.asItem());
                storeFungusDataIntoItemStack(coloredFungusBlockEntity.getFungusGenoma(), itemStack);

                ItemEntity stackEntity = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, itemStack);
                stackEntity.setDefaultPickUpDelay();
                level.addFreshEntity(stackEntity);
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    private static void storeFungusDataIntoItemStack(FungusGenoma fungusGenoma, ItemStack itemStack)
    {
        itemStack.applyComponents(DataComponentMap.builder().set(FUNGUS_GENOMA, fungusGenoma).build());
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player)
    {
        ItemStack stack = super.getCloneItemStack(state, target, world, pos, player);
        FungusGenoma fungusData = world.getBlockEntity(pos, COLORED_FUNGUS.get()).orElseThrow().getFungusGenoma();
        storeFungusDataIntoItemStack(fungusData, stack);
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

    @OnlyIn(Dist.CLIENT)
    private static void addSporeParticle(int radius, BlockPos blockPos, Level level, RandomSource randomSource)
    {
        Random random = new Random();
        int density = SPORE_PARTICLES_FREQ.get()*radius;
        radius *= RADIUS_MULTIPLIER.get();
        for (int i = 0; i < density; i++)
        {
            //get random BlockPos
            BlockPos randomPos = new BlockPos(
                    random.nextInt(blockPos.getX() - radius, blockPos.getX() + radius),
                    random.nextInt(blockPos.getY() - radius, blockPos.getY() + radius),
                    random.nextInt(blockPos.getZ() - radius, blockPos.getZ() + radius));

            //spawn particle
            double velX = 0;
            double velY = 0;
            double velZ = 0;
            level.addParticle(ModParticles.SPORE_PARTICLES.get(), randomPos.getX() + randomSource.nextDouble(), randomPos.getY() + randomSource.nextDouble(), randomPos.getZ() + randomSource.nextDouble(), velX, velY, velZ);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    //FIXME testing only
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource)
    {
        super.animateTick(blockState, level, blockPos, randomSource);
        //ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(blockPos));
        //int radius = (Integer)originBlockEntity.getFungusData().getField(FungusGenoma.AREA);
        //addSporeParticle(radius, blockPos, level, randomSource);
    }

    /*@Override //deprecated
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        BlockPos originalPos = pos;
        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(originalPos));
        FungusDataModel thisFungusData = originBlockEntity.getFungusData();

        //code copied from MushroomBlock.randomTick
        //TODO use nbt data instead of magic numbers
        int spreading = (int)thisFungusData.getField(FungusDataModel.SPREADING, IFungusData.GeneType.DOMINANT);//TODO implement spreadboost
        int areaRadius = (Integer) thisFungusData.getField(FungusDataModel.AREA);
        if (rand.nextInt(spreading) == 0)
        {
            //check if there are 'i' mushrooms in area
            //if it does then prevent spreading
            int i = MAX_MUSHROOMS_IN_AREA.get();
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
                boolean crossBreeding = dice.nextInt(ModCommonConfigs.BREEDING_CHANCE.get()) == 0; //FIXME adjust BREEDING_CHANCE

                // check if there are any different fungi nearby (by 'nearby' I mean the dominant "area" trait)
                ArrayList<ColoredFungusBlockEntity> nearbyFungi = getFungiInArea(level, blockpos1, areaRadius);

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

                    if (offspringDataModel.matchesEnvironmentAndTerrain(light, temperature, humidity, level.getBlockState(blockpos1.below())))
                    {
                        // ... then place it
                        String fungusType = FungusSpeciesList.INSTANCE.get((String) offspringDataModel.getField(FungusDataModel.SPECIES)).fungusType;
                        blockState = ModBlocks.getDefaultBlockStateFromFungusType(fungusType);
                        placeFungusBlock(blockState, level, blockpos1, offspringDataModel);
                        return;
                    }
                }

                //otherwise proceed with normal spreading
                if (blockState.canSurvive(level, blockpos1))
                    placeFungusBlock(blockState, level, blockpos1, thisFungusData);
            }
        }
        //implement here area effect
        String fungusEffect = (String) thisFungusData.getField(FungusDataModel.EFFECT);
        FungusEffects.getEffectByName(fungusEffect).applyEffectToLevel(level, pos, areaRadius);
    }*/

    /*private static void placeFungusBlock(BlockState blockState, ServerLevel level, BlockPos pos, FungusDataModel dataModel)
    {
        level.setBlock(pos, blockState, 2); //wtf is this '2'?
        ColoredFungusBlockEntity newBlockEntity = (ColoredFungusBlockEntity) (level.getBlockEntity(pos));
        if (newBlockEntity != null)
        {
            newBlockEntity.getFungusData().deserializeNBT(dataModel.serializeNBT());//FIXME ugly code
        }
    }*/

    private static ArrayList<ColoredFungusBlockEntity> getFungiInArea(ServerLevel level, BlockPos pos, int radius)
    {
        AABB boxArea = new AABB(
                pos.getX() - radius,
                pos.getY() - radius,
                pos.getZ() - radius,
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

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos origin)
    {
        // This part should prevent the case when 'originBlockEntity' is null
        // i.e. when trying to plant the mushroom on the ground
        BlockState belowBlock = level.getBlockState(origin.below());
        if(belowBlock.is(CAN_PLANT_ON))
            return true;
        //


        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(origin));
        if(originBlockEntity==null)
        {
            // Sometimes originBlockEntity is infact null
            // This happens when mushroom try to spread but fails
            Log.error("ColoredFungusBlock#canSurvive: originBlockEntity is null");
            return false;
        }
        FungusGenoma thisFungusData = originBlockEntity.getFungusGenoma();

        if(thisFungusData==null)
        {
            Log.error("Block cannot survive. FungusGenoma is null");
            return false;
        }

        boolean matchesTerrain = thisFungusData.matchesTerrain(belowBlock);
        int light = level.getBrightness(LightLayer.SKY, origin);
        float temperature = level.getBiome(origin).value().getModifiedClimateSettings().temperature();
        float humidity = level.getBiome(origin).value().getModifiedClimateSettings().downfall();
        boolean matchesEnv = thisFungusData.matchesEnvironment(light, temperature, humidity);
        return thisFungusData.matchesEnvironmentAndTerrain(light, temperature, humidity, belowBlock);
    }
}
