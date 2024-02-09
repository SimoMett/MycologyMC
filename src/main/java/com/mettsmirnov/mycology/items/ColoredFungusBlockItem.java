package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
        super(block, new Properties());
    }

    //Forestry uses capability. Why shouldn't I?
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return super.initCapabilities(stack, nbt);
    }

    @Override
    public Component getName(ItemStack itemStack)
    {
        //TODO need testing
        String name = (String) itemStack.getCapability(FungusDataCapability.INSTANCE).resolve().get().getField("species", IFungusData.GeneType.DOMINANT);
        Component textComponent = MutableComponent.create(ComponentContents.EMPTY).append(name);
        return textComponent;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, @Nullable Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
        super.appendHoverText(itemStack, p_41422_, tooltip, p_41424_);
        //tooltip.add(new TextComponent("\u00a77Some info here pls"));
    }

    @Nullable
    @Override
    protected BlockState getPlacementState(BlockPlaceContext context)
    {
        BlockState blockState = super.getPlacementState(context);

        return blockState;
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState blockState)
    {
        boolean result = super.placeBlock(context, blockState);
        ColoredFungusBlockEntity entity = (ColoredFungusBlockEntity)context.getLevel().getBlockEntity(context.getClickedPos());

        CompoundTag tags = context.getItemInHand().getCapability(FungusDataCapability.INSTANCE).resolve().get().serializeNBT();
        //entity.getCapability(FungusDataCapability.INSTANCE).resolve().get().deserializeNBT(tags);
        entity.handleUpdateTag(tags);
        return result;
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState blockState)
    {
        //fungi can be placed from hand only on mycelium blocks
        BlockPos clickedPos = context.getClickedPos();
        BlockState belowBlock = context.getLevel().getBlockState(clickedPos.below());
        return super.canPlace(context,blockState) && belowBlock.is(Blocks.MYCELIUM);
    }
}
