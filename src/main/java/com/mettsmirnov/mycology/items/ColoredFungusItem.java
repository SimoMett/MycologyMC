package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ColoredFungusItem extends Item implements ItemColor
{
    public static final String TAG_COLORS = "Colors";

    public CompoundTag tags;

    public static ColoredFungusItem createColoredCrimson()
    {
        return new ColoredFungusItem();
    }

    public ColoredFungusItem()
    {
        super(new Properties().tab(MycologyMod.MOD_ITEM_GROUP));
    }

    public static ListTag getTagColors(ItemStack itemStack)
    {
        CompoundTag compoundTag = itemStack.getTag();
        if(compoundTag!=null)
            return compoundTag.getList(TAG_COLORS,0);
        else
            return new ListTag();
    }

    @Override
    public int getColor(ItemStack itemStack, int tintIndex) {
        //color in ARGB format
        return 0;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
        super.appendHoverText(itemStack, p_41422_, tooltip, p_41424_);
        tooltip.add(new TextComponent("\u00a77Some infos here pls"));
    }
}
