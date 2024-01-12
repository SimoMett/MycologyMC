package com.mettsmirnov.mycology.data;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class FungusSpeciesHandler //TODO add fungusUses structure
{
    private List<FungusSpecies> list = new ArrayList<>();

    public static FungusSpeciesHandler INSTANCE = new FungusSpeciesHandler();

    public void put(FungusTraits defaultTraits, int[] colors, String fungusType)
    {
        //TODO add recipes from fungusUses
        FungusSpecies species = new FungusSpecies(defaultTraits,colors,fungusType);
        list.add(species);
    }

    public ArrayList<FungusSpecies> getSpeciesList()
    {
        return new ArrayList<FungusSpecies>(list);
    }

    public void clearList()
    {
        list.clear();
    }

    public Collection<ItemStack> getCollection()
    {
        Collection<ItemStack> collection = new ArrayList<>();

        for(FungusSpecies species : list)
        {
            ItemStack e;
            if(species.fungusType.equals("colored_crimson_fungus"))
                e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
            else
                e = new ItemStack(ModItems.COLORED_WARPED_FUNGUS.get());
            e.getCapability(FungusDataCapability.INSTANCE).resolve().get().setColors(species.colors);
            e.getCapability(FungusDataCapability.INSTANCE).resolve().get().loadFrom(species.defaultTraits, species.defaultTraits);
            collection.add(e);
        }
        return collection;
    }

    public ItemStack getCreativeTabIcon()
    {
        FungusSpecies species = list.get(1);
        for(FungusSpecies _species : list)
        {
            if(Objects.equals(_species.defaultTraits.species, "Boletus salubrium"))
            {
                species = _species;
                break;
            }
        }

        ItemStack e;
        if(species.fungusType.equals("colored_crimson_fungus"))
            e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
        else
            e = new ItemStack(ModItems.COLORED_WARPED_FUNGUS.get());
        e.getCapability(FungusDataCapability.INSTANCE).resolve().get().setColors(species.colors);
        e.getCapability(FungusDataCapability.INSTANCE).resolve().get().loadFrom(species.defaultTraits, species.defaultTraits);
        return e;
    }

    public static class FungusSpecies
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
