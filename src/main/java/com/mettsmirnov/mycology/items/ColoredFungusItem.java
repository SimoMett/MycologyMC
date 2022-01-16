package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.blocks.ColoredFungusBlock;
import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredFungusItem extends BlockItem
{
    public static ColoredFungusItem createColoredCrimson()
    {
        return new ColoredFungusItem(ModBlocks.COLORED_CRIMSON_FUNGUS.get());
    }
    public static ColoredFungusItem createColoredWarped()
    {
        return new ColoredFungusItem(ModBlocks.COLORED_WARPED_FUNGUS.get());
    }

    public ColoredFungusItem(Block block)
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
        TextComponent textComponent = new TextComponent((String) itemStack.getCapability(FungusDataCapability.INSTANCE).resolve().get().getField("species", IFungusData.GeneType.DOMINANT));
        return textComponent;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, @Nullable Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
        super.appendHoverText(itemStack, p_41422_, tooltip, p_41424_);
        tooltip.add(new TextComponent("\u00a77Some info here pls"));
    }

    @Nullable
    @Override
    protected BlockState getPlacementState(BlockPlaceContext context) {
        BlockState blockState = super.getPlacementState(context);

        return blockState;
    }
}
