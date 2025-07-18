package com.simomett.mycologymod.blocks;

import com.mojang.serialization.MapCodec;
import com.simomett.mycologymod.config.ModCommonConfigs;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.particles.ModParticles;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params)
    {
        ColoredFungusBlockEntity coloredFungusBlockEntity = (ColoredFungusBlockEntity) params.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        ItemStack itemStack = new ItemStack(this);
        coloredFungusBlockEntity.getFungusGenoma().storeIntoItemStack(itemStack);
        return Collections.singletonList(itemStack);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player)
    {
        ItemStack stack = super.getCloneItemStack(state, target, world, pos, player);
        FungusGenoma fungusData = world.getBlockEntity(pos, COLORED_FUNGUS.get()).orElseThrow().getFungusGenoma();
        fungusData.storeIntoItemStack(stack);
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

        boolean hasMutagen = hasMutagen(blockState);
        float spreadBoost = (thisGenoma.matchesEnvironment(level, originalPos)
                && level.getBlockState(originalPos.below()).is(Blocks.MYCELIUM)) || hasMutagen? thisGenoma.getDominantTraits().spreadboost() : 1f;
        int spreading = Math.round(thisGenoma.getDominantTraits().spreading() / spreadBoost);
        if(spreading==0)
            spreading=1;
        boolean canSpread = thisGenoma.matchesEnvironmentAndTerrain(level, pos, level.getBlockState(pos.below()));

        int areaRadius = thisGenoma.getDominantTraits().area();

        if (canSpread && rand.nextInt(spreading) == 0)
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

            removeMutagen(originalPos, blockState, level);

            BlockPos blockpos1 = findSuitableBlockPos(pos, level, blockState);
            if (level.isEmptyBlock(blockpos1))
                breedAndSpread(blockState, level, blockpos1, areaRadius, thisGenoma, hasMutagen);
        }

        // area effect
        String fungusEffect = thisGenoma.getDominantTraits().effect();
        FungusEffects.getEffectByName(fungusEffect).applyEffectToLevel(level, pos, areaRadius);
    }

    private static BlockPos findSuitableBlockPos(BlockPos searchStartPos, ServerLevel level, BlockState blockState)
    {
        BlockPos pos = searchStartPos;
        Random rand = new Random();
        // find a random position for the new block
        BlockPos blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

        // 4 tries
        for(int k = 0; k < 4; ++k)
        {
            if (level.isEmptyBlock(blockpos1) && blockState.canSurvive(level, blockpos1))
                pos = blockpos1;

            blockpos1 = pos.offset(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
        }
        return blockpos1;
    }

    private static void breedAndSpread(BlockState blockState, ServerLevel level, BlockPos pos, int areaRadius, FungusGenoma genoma, boolean hasMutagen)
    {
        //WARNING
        // if whatever mod/datapack changes default temperature and humidity of a biome, the fungus cannot spread.
        Random rand = new Random();
        boolean crossBreeding = rand.nextFloat(1.0f) < ModCommonConfigs.BREEDING_CHANCE.get();

        ArrayList<ColoredFungusBlockEntity> nearbyFungi = getFungiInArea(level, pos, areaRadius);
        nearbyFungi.removeIf((e) -> e.getFungusGenoma()==genoma); //Remove self

        if (crossBreeding && !nearbyFungi.isEmpty())
        {
            // precalculate the genotype
            ColoredFungusBlockEntity randomFungus = nearbyFungi.get(rand.nextInt(nearbyFungi.size()));
            FungusGenoma offspringGenoma = randomFungus.getFungusGenoma().crossBreedWith(genoma, hasMutagen);

            if (offspringGenoma.matchesTerrain(level.getBlockState(pos.below())))
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

    private static void breedAndSpread2(BlockState blockState, ServerLevel level, BlockPos pos, int areaRadius, FungusGenoma genoma, boolean hasMutagen)
    {
        ArrayList<ColoredFungusBlockEntity> nearbyFungi = getFungiInArea(level, pos, areaRadius);
        if(!nearbyFungi.isEmpty())
        {

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
        if(null==originBlockEntity)
            return false;// This happens when mushroom try to spread but fails. I.E. the mushroom is not yet planted.

        FungusGenoma thisFungusData = originBlockEntity.getFungusGenoma();

        if(null==thisFungusData)
        {
            originBlockEntity.setRemoved();
            return false;
        }

        boolean canSurvive = thisFungusData.matchesTerrain(belowBlock);
        if(!canSurvive)
            originBlockEntity.setRemoved();
        return canSurvive;
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
