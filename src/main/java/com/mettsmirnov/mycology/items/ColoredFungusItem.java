package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

import java.awt.*;
import java.util.List;

public class ColoredFungusItem extends Item
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
        super(new Properties().tab(MycologyMod.MOD_ITEM_GROUP));
    }

    //FIXME foil effect is too much
    /*@Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack itemStack)
    {
        return itemStack.isEnchanted();
    }*/

    @Override
    public ItemStack getDefaultInstance()
    {
        ItemStack itemStack = super.getDefaultInstance();
        itemStack.getOrCreateTag().putString("species","test");
        return itemStack;
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
