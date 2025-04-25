package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.datacomponents.ModDataComponentTypes;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.mixins.IFlowerPotBlockMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static com.simomett.mycologymod.entities.ModEntities.COLORED_FUNGUS;

public class FungusPotBlock extends FlowerPotBlock implements EntityBlock
{

    public FungusPotBlock(Supplier<? extends Block> potted, Properties properties)
    {
        super(ModBlocks.FUNGUS_POT::get, potted, properties);
    }

    public FungusPotBlock(Properties properties)
    {
        super(null, ()-> Blocks.AIR, properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return COLORED_FUNGUS.get().create(blockPos, blockState);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        if(stack.is(Items.AIR))
            return InteractionResult.TRY_WITH_EMPTY_HAND;

        if(stack.has(ModDataComponentTypes.FUNGUS_GENOMA))
        {
            InteractionResult result = super.useItemOn(stack, state, level, pos, player, hand, hitResult);

            if(result == InteractionResult.SUCCESS)
            {
                FungusGenoma fungusGenoma = stack.get(ModDataComponentTypes.FUNGUS_GENOMA);
                ColoredFungusBlockEntity blockEntity = (ColoredFungusBlockEntity) level.getBlockEntity(pos);
                blockEntity.applyGenoma(fungusGenoma);
                return InteractionResult.SUCCESS;
            }

            return result;
        }
        return InteractionResult.PASS;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (this.isEmpty())
            return InteractionResult.CONSUME;
        else
        {
            ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity) (level.getBlockEntity(pos));
            ItemStack itemstack = new ItemStack(this.getPotted());
            originBlockEntity.getFungusGenoma().storeIntoItemStack(itemstack);

            if (!player.addItem(itemstack)){
                player.drop(itemstack, false);
            }

            level.setBlock(pos, this.getEmptyPot().defaultBlockState(), 3);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state)
    {
        ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity) (level.getBlockEntity(pos));
        if(getPotted()==Blocks.AIR)
            return super.getCloneItemStack(level, pos, state);
        else
        {
            ItemStack stack = new ItemStack(this.getPotted().asItem());
            originBlockEntity.getFungusGenoma().storeIntoItemStack(stack);
            return stack;
        }
    }

    private boolean isEmpty()
    {
        IFlowerPotBlockMixin flowerPotBlockMixin = (IFlowerPotBlockMixin) this;
        return flowerPotBlockMixin.invokeIsEmpty();
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        // area effect
        if(!this.isEmpty())
        {
            ColoredFungusBlockEntity originBlockEntity = (ColoredFungusBlockEntity) (level.getBlockEntity(pos));
            FungusGenoma thisGenoma = originBlockEntity.getFungusGenoma();
            int areaRadius = thisGenoma.getDominantTraits().area();
            String fungusEffect = thisGenoma.getDominantTraits().effect();
            FungusEffects.getEffectByName(fungusEffect).applyEffectToLevel(level, pos, areaRadius);
        }
    }
}
