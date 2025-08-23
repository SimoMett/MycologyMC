package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.items.ItemsDefinitions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class MycologyCreativeTab extends CreativeModeTab
{
    public static MycologyCreativeTab instance()
    {
        return new MycologyCreativeTab(CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID))
                .icon(() -> AbstractFungusSpeciesList.getInstance().getCreativeTabIcon())
                .displayItems((e, p) -> {
                    //p.accept(ModItems.MAGNIFYING_GLASS.get());
                })
        );
    }

    protected MycologyCreativeTab(Builder builder)
    {
        super(builder);
    }

    @Override
    public Collection<ItemStack> getDisplayItems()
    {
        ArrayList<ItemStack> displayItems = new ArrayList<>(AbstractFungusSpeciesList.getInstance().getAllSpeciesCollection());
        displayItems.add(new ItemStack(ItemsDefinitions.MAGNIFYING_GLASS.get()));
        return displayItems;
    }
}
