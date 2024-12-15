package com.simomett.mycologymod.data;

import com.simomett.mycologymod.datagen.common.FungusSpawn;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import com.simomett.mycologymod.items.ModItems;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.world.item.ItemStack;

import java.util.*;

import static com.simomett.mycologymod.blocks.ModBlocks.COLORED_CRIMSON_STRING;
import static com.simomett.mycologymod.blocks.ModBlocks.COLORED_WARPED_STRING;
import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;
import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.BOLETUS_SALUBRIUM;
import static com.simomett.mycologymod.items.ModItems.COLORED_CRIMSON_FUNGUS;

public class FungusSpeciesList
{
    private HashMap<String, FungusSpecies> speciesHashMap = new HashMap<>();

    public static FungusSpeciesList INSTANCE = new FungusSpeciesList();

    public void put(FungusTraits defaultTraits, int[] colors, String fungusType, FungusSpawn spawnType)
    {
        FungusSpecies species = new FungusSpecies(defaultTraits,colors,fungusType, spawnType);
        speciesHashMap.put(defaultTraits.species(), species);
    }

    public FungusSpecies get(String speciesName)
    {
        return speciesHashMap.getOrDefault(speciesName, new FungusSpecies(FungusTraits.UNINIT, new int[]{0, 0, 0, 0}, COLORED_WARPED_STRING, FungusSpawn.NO_SPAWN));
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

        List<FungusSpecies> sortedSpecies = speciesHashMap.values().stream().sorted(Comparator.comparing(a -> a.defaultTraits.species())).toList();
        for(FungusSpecies species : sortedSpecies)
        {
            ItemStack e;
            if(species.fungusType.equals(COLORED_CRIMSON_STRING))
                e = new ItemStack(COLORED_CRIMSON_FUNGUS.get());
            else
                e = new ItemStack(ModItems.COLORED_WARPED_FUNGUS.get());
            e.applyComponents(DataComponentMap.builder().set(FUNGUS_GENOMA, new FungusGenoma(new FungusTraits(species.defaultTraits), new FungusTraits(species.defaultTraits))).build());
            collection.add(e);
        }
        return collection;
    }

    public ItemStack getCreativeTabIcon()
    {
        FungusSpecies species = speciesHashMap.get(BOLETUS_SALUBRIUM);

        ItemStack e;
        if(species.fungusType.equals(COLORED_CRIMSON_STRING))
            e = new ItemStack(COLORED_CRIMSON_FUNGUS.get());
        else
            e = new ItemStack(ModItems.COLORED_WARPED_FUNGUS.get());
        e.applyComponents(DataComponentMap.builder().set(FUNGUS_GENOMA, new FungusGenoma(new FungusTraits(species.defaultTraits), new FungusTraits(species.defaultTraits))).build());
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
