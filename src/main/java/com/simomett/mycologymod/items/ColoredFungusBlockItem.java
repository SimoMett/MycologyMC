package com.simomett.mycologymod.items;

import com.simomett.mycologymod.blocks.ModBlocks;
import com.simomett.mycologymod.capabilities.ModDataComponentTypes;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.simomett.mycologymod.capabilities.ModDataComponentTypes.FUNGUS_GENOMA;

public class ColoredFungusBlockItem extends BlockItem
{
    public static ColoredFungusBlockItem createColoredCrimson()
    {
        return new ColoredFungusBlockItem(ModBlocks.COLORED_CRIMSON_FUNGUS.get());
    }
    public static ColoredFungusBlockItem createColoredWarped()
    {
        return new ColoredFungusBlockItem(ModBlocks.COLORED_WARPED_FUNGUS.get());
    }

    public ColoredFungusBlockItem(Block block)
    {
        super(block, new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().build()));
    }

    @Override
    public @Nullable FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity)
    {
        /*IFungusData thisDataModel = stack.getCapability(FungusDataCapability.INSTANCE).resolve().get();
        String eatBuff = (String) thisDataModel.getField("eatingEffect", IFungusData.GeneType.DOMINANT);
        if(eatBuff != null)
        {
            MobEffect mobEffect = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(eatBuff));
            return new FoodProperties.Builder().alwaysEdible().effect(()-> new MobEffectInstance(Holder.direct(mobEffect), -1), 1f).build();
        }*/
        return Foods.SPIDER_EYE;
    }

    @Override
    public Component getName(ItemStack itemStack)
    {
        String speciesName = itemStack.has(FUNGUS_GENOMA) ? itemStack.get(FUNGUS_GENOMA).getDominantTraits().species() : "Fungus impossibilis";
        return Component.literal(speciesName);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag p_41424_)
    {
        super.appendHoverText(itemStack, tooltipContext, components, p_41424_);
        components.add(Component.literal("\u00a77Mycology WIP build"));
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState blockState)
    {
        boolean result = super.placeBlock(context, blockState);
        //ColoredFungusBlockEntity entity = (ColoredFungusBlockEntity)context.getLevel().getBlockEntity(context.getClickedPos());

        FungusGenoma thisGenoma = context.getItemInHand().get(FUNGUS_GENOMA);
        //entity.handleUpdateTag(tags);
        return result;
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState blockState)
    {
        //fungi can be placed from hand only on mycelium or podzol blocks
        BlockPos clickedPos = context.getClickedPos();
        BlockState belowBlock = context.getLevel().getBlockState(clickedPos.below());
        return super.canPlace(context,blockState) && (belowBlock.is(Blocks.MYCELIUM) || belowBlock.is(Blocks.PODZOL)) ;
    }
}
