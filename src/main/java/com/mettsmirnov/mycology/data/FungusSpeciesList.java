package com.mettsmirnov.mycology.data;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FungusSpeciesList //TODO add uses structure
{
    private List<FungusSpecies> list = new ArrayList<>();

    public static FungusSpeciesList INSTANCE = new FungusSpeciesList();

    public void put(FungusTraits defaultTraits, int[] colors, String fungusType)
    {
        FungusSpecies species = new FungusSpecies(defaultTraits,colors,fungusType);
        list.add(species);
    }

    public Collection<ItemStack> getCollection()//TODO
    {
        Collection<ItemStack> collection = new ArrayList<ItemStack>();

        for(FungusSpecies species : list)
        {
            ItemStack e;
            if(species.fungusType.equals("colored_crimson_fungus"))
                e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
            else
                e = new ItemStack(ModItems.COLORED_WARPED_FUNGUS.get());
            e.getCapability(FungusDataCapability.INSTANCE).resolve().get().setColors(species.colors);
            e.setHoverName(new TextComponent(species.defaultTraits.species));
            //TODO load other stuff
            collection.add(e);
        }

        return collection;
    }

    private static class FungusSpecies
    {
        public FungusTraits defaultTraits;
        public int [] colors;
        public String fungusType;

        public FungusSpecies(FungusTraits traits, int [] cols, String type)
        {
            defaultTraits = traits;
            colors = cols;
            fungusType = type;
        }
    }
}
