package com.mettsmirnov.mycology.data;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import com.mettsmirnov.mycology.genetics.FungusTraits;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.world.item.ItemStack;

import java.util.*;

import static com.mettsmirnov.mycology.blocks.ModBlocks.COLORED_CRIMSON_STRING;
import static com.mettsmirnov.mycology.blocks.ModBlocks.COLORED_RED_STRING;

public class FungusSpeciesList
{
    private HashMap<String, FungusSpecies> speciesHashMap = new HashMap<>();

    public static FungusSpeciesList INSTANCE = new FungusSpeciesList();

    public void put(FungusTraits defaultTraits, int[] colors, String fungusType, FungusSpawn spawnType)
    {
        FungusSpecies species = new FungusSpecies(defaultTraits,colors,fungusType, spawnType);
        speciesHashMap.put(defaultTraits.species, species);
    }

    public FungusSpecies get(String speciesName)
    {
        return speciesHashMap.get(speciesName);
    }

    public ArrayList<FungusSpecies> getSpeciesList()
    {
        return new ArrayList<>(speciesHashMap.values());
    }

    public void clearList()
    {
        speciesHashMap.clear();
    }

    public Collection<ItemStack> getAllSpeciesCollection()
    {
        Collection<ItemStack> collection = new ArrayList<>();

        List<FungusSpecies> sortedSpecies = speciesHashMap.values().stream().sorted(Comparator.comparing(a -> a.defaultTraits.species)).toList();
        for(FungusSpecies species : sortedSpecies)
        {
            ItemStack e;
            if(species.fungusType.equals(COLORED_CRIMSON_STRING))
                e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
            else if(species.fungusType.equals(COLORED_RED_STRING))
                e = new ItemStack(ModItems.COLORED_RED_FUNGUS.get());
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
        FungusSpecies species = speciesHashMap.get("Boletus salubrium");

        ItemStack e;
        if(species.fungusType.equals(COLORED_CRIMSON_STRING))
            e = new ItemStack(ModItems.COLORED_CRIMSON_FUNGUS.get());
        else if(species.fungusType.equals(COLORED_RED_STRING))
            e = new ItemStack(ModItems.COLORED_RED_FUNGUS.get());
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
        public final FungusSpawn spawnInfo;

        public FungusSpecies(FungusTraits traits, int [] cols, String type, FungusSpawn spawnInfo)
        {
            defaultTraits = traits;
            colors = cols;
            fungusType = type;
            this.spawnInfo = spawnInfo;
        }
    }
}
