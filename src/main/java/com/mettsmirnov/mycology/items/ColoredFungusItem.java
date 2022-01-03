package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.blocks.ColoredFungusBlock;
import com.mettsmirnov.mycology.blocks.ModBlocks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredFungusItem extends BlockItem
{
    public static ColoredFungusItem createColoredCrimson()
    {
        return new ColoredFungusItem();
    }
    public static ColoredFungusItem createColoredWarped()
    {
        return new ColoredFungusItem();
    }

    public ColoredFungusItem()
    {
        super(ModBlocks.COLORED_CRIMSON_FUNGUS.get(),new Properties().tab(MycologyMod.MOD_ITEM_GROUP));
    }

    //FIXME foil effect is too much
    /*@Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack itemStack)
    {
        return itemStack.isEnchanted();
    }*/

    //Forestry uses capability. Why shouldn't I?
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return super.initCapabilities(stack, nbt);
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return new TextComponent("Alea Fungus");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, @Nullable Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
        super.appendHoverText(itemStack, p_41422_, tooltip, p_41424_);
        tooltip.add(new TextComponent("\u00a77Some info here pls"));
    }
}
