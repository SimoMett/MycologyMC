package com.simomett.mycologymod.creativetab;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.items.ItemsDefinitions;
import com.simomett.mycologymod.items.potions.PotionsDefinitions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

public class MycologyCreativeTab
{
    public static UnaryOperator<CreativeModeTab.Builder> CREATIVE_TAB_BUILDER = builder -> builder
            .title(Component.translatable("itemGroup." + Constants.MOD_ID))
            .icon(() -> FungusSpeciesList.getInstance().getCreativeTabIcon())
            .displayItems((e, p) -> p.acceptAll(getItemsToDisplay()))
    ;

    public static Collection<ItemStack> getItemsToDisplay()
    {
        ArrayList<ItemStack> displayItems = new ArrayList<>(FungusSpeciesList.getInstance().getAllSpeciesCollection());
        displayItems.add(ItemsDefinitions.COOKED_CRIMSON_FUNGUS.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.COOKED_WARPED_FUNGUS.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.COOKED_POISONOUS_CRIMSON_FUNGUS.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.COOKED_POISONOUS_WARPED_FUNGUS.get().getDefaultInstance());
        //displayItems.add(ItemsDefinitions.MAGNIFYING_GLASS.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.ANALYSING_STATION.get().getDefaultInstance());
        //displayItems.add(ItemsDefinitions.TEST_TUBE.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMIUM_ORE.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMITE_POWDER.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMIUM_MUTAGEN.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMIUM_INGOT.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMIUM_NUGGET.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMIUM_BLOCK.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.CHROMIUM_STAIRS.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.FUNGUS_POT.get().getDefaultInstance());
        displayItems.add(ItemsDefinitions.SPORE_MASK.get().getDefaultInstance());
        displayItems.addAll(PotionsDefinitions.getModPotions());
        return displayItems;
    }

    public static void init(){}
}
