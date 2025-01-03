package com.simomett.mycologymod.blocks;

import com.mojang.serialization.MapCodec;
import com.simomett.mycologymod.config.ModCommonConfigs;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.particles.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
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

import static com.simomett.mycologymod.config.ModClientConfigs.SPORE_PARTICLES_FREQ;
import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;
import static com.simomett.mycologymod.config.ModCommonConfigs.*;
import static com.simomett.mycologymod.entities.ModEntities.COLORED_FUNGUS;
import static com.simomett.mycologymod.tags.ModBlockTags.CAN_PLANT_ON;


public class ColoredFungusBlock extends BushBlock implements EntityBlock
{
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
    public static final BooleanProperty MUTAGEN_APPLIED = BlockStateProperties.LIT;

    public ColoredFungusBlock(BlockBehaviour.Properties properties)
    {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(MUTAGEN_APPLIED, false));
    }

    @Override //deprecated
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(MUTAGEN_APPLIED);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos)
    {
        return hasMutagen(state) ? 5 : 0;
    }

    @Override
    protected MapCodec<? extends BushBlock> codec()//what is this for?
    {
        return simpleCodec(ColoredFungusBlock::new);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_51039_)
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
    private static void addSporeParticle(int radius, BlockState blockState, BlockPos blockPos, Level level, RandomSource randomSource)
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

            if(hasMutagen(blockState))
                level.addParticle(ModParticles.MUTANT_SPORE_PARTICLES.get(), randomPos.getX() + randomSource.nextDouble(), randomPos.getY() + randomSource.nextDouble(), randomPos.getZ() + randomSource.nextDouble(), velX, velY, velZ);
            else
                level.addParticle(ModParticles.SPORE_PARTICLES.get(), randomPos.getX() + randomSource.nextDouble(), randomPos.getY() + randomSource.nextDouble(), randomPos.getZ() + randomSource.nextDouble(), velX, velY, velZ);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource)
    {
        super.animateTick(blockState, level, blockPos, randomSource);
        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(blockPos));
        int radius = originBlockEntity.getFungusGenoma().getDominantTraits().area();
        addSporeParticle(radius, blockState, blockPos, level, randomSource);
    }

    @Override // copied from MushroomBlock.randomTick
    protected void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        BlockPos originalPos = pos;
        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity)(level.getBlockEntity(originalPos));
        FungusGenoma thisGenoma = originBlockEntity.getFungusGenoma();

        float spreadBoost = thisGenoma.matchesEnvironment(level, originalPos)? thisGenoma.getDominantTraits().spreadboost() : 1f;
        int spreading = Math.round(thisGenoma.getDominantTraits().spreading() / spreadBoost);
        if(spreading==0)
            spreading=1;

        int areaRadius = thisGenoma.getDominantTraits().area();

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
                    if (i <= 0)
                        return;
                }
            }

            boolean hasMutagen = hasMutagen(blockState);
            removeMutagen(originalPos, blockState, level);

            // find a random position for the new block
            BlockPos blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            // 4 tries
            for(int k = 0; k < 4; ++k)
            {
                if (level.isEmptyBlock(blockpos1) && blockState.canSurvive(level, blockpos1))
                    pos = blockpos1;

                blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if (level.isEmptyBlock(blockpos1))
                breedAndSpread(blockState, level, blockpos1, areaRadius, thisGenoma, hasMutagen);
        }

        // area effect
        String fungusEffect = thisGenoma.getDominantTraits().effect();
        FungusEffects.getEffectByName(fungusEffect).applyEffectToLevel(level, pos, areaRadius);
    }

    private static void breedAndSpread(BlockState blockState, ServerLevel level, BlockPos pos, int areaRadius, FungusGenoma genoma, boolean hasMutagen)
    {
        Random rand = new Random();
        boolean crossBreeding = rand.nextInt(ModCommonConfigs.BREEDING_CHANCE.get()) == 0; //TODO use mutations probabilities
        //TODO mutagen boost mutation chance

        ArrayList<ColoredFungusBlockEntity> nearbyFungi = getFungiInArea(level, pos, areaRadius);

        if (crossBreeding && !nearbyFungi.isEmpty())
        {
            // precalculate the genotype
            ColoredFungusBlockEntity randomFungus = nearbyFungi.get(rand.nextInt(nearbyFungi.size()));
            FungusGenoma offspringGenoma = randomFungus.getFungusGenoma().crossBreedWith(genoma);

            if (offspringGenoma.matchesEnvironmentAndTerrain(level, pos, level.getBlockState(pos.below())))
            {
                // ... then place it
                String fungusType = FungusSpeciesList.INSTANCE.get(offspringGenoma.getDominantTraits().species()).fungusType;
                blockState = ModBlocks.getDefaultBlockStateFromFungusType(fungusType);
                placeFungusBlock(blockState, level, pos, offspringGenoma);
            }
        }
        else if (blockState.canSurvive(level, pos))
        {
            // ... otherwise proceed with normal spreading
            if(hasMutagen && rand.nextFloat(0f,1f) < MUTAGEN_EFFECTIVENESS.get())
            {
                for(int i = 0; i<rand.nextInt(1, 3); i++)
                    genoma.changeRandomTraitByMutagen();
            }
            placeFungusBlock(blockState, level, pos, genoma);
        }
    }

    private static void placeFungusBlock(BlockState blockState, ServerLevel level, BlockPos pos, FungusGenoma genoma)
    {
        level.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
        ColoredFungusBlockEntity newBlockEntity = (ColoredFungusBlockEntity) (level.getBlockEntity(pos));
        if (newBlockEntity != null)
        {
            newBlockEntity.applyGenoma(genoma);
        }
    }

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

        return thisFungusData.matchesEnvironmentAndTerrain(level, origin, belowBlock);
    }

    public static void applyMutagen(BlockPos pos, BlockState blockState, ServerLevel level)
    {
        level.setBlockAndUpdate(pos, blockState.setValue(MUTAGEN_APPLIED, true));
    }

    public static boolean hasMutagen(BlockState blockState)
    {
        return blockState.getValue(MUTAGEN_APPLIED);
    }

    public static void removeMutagen(BlockPos pos, BlockState blockState, ServerLevel level)
    {
        level.setBlockAndUpdate(pos, blockState.setValue(MUTAGEN_APPLIED, false));
    }
}
