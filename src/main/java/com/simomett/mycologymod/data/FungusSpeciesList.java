package com.simomett.mycologymod.data;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.datagen.common.FungusSpawn;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import com.simomett.mycologymod.network.serializable.IModSerializable;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

import static com.simomett.mycologymod.blocks.ModBlocks.COLORED_CRIMSON_STRING;
import static com.simomett.mycologymod.blocks.ModBlocks.COLORED_WARPED_STRING;
import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class FungusSpeciesList implements CustomPacketPayload, IModSerializable
{
    private final HashMap<String, FungusSpecies> speciesHashMap = new HashMap<>();
    private final FungusSpeciesColorsMap colorsMap = FungusSpeciesColorsMap.INSTANCE;

    public static FungusSpeciesList INSTANCE = new FungusSpeciesList();

    public static final CustomPacketPayload.Type<FungusSpeciesList> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "fungus_species_list_sync"));
    public static FungusSpeciesList fromByteBuf(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] dst = new byte[byteBuf.readInt()];
            byteBuf.readBytes(dst);
            ByteArrayInputStream i = new ByteArrayInputStream(dst);
            ObjectInputStream inputStream = new ObjectInputStream(i);
            return INSTANCE = (FungusSpeciesList) inputStream.readObject();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void put(FungusTraits defaultTraits, int[] colors, String fungusType, FungusSpawn spawnType)
    {
        FungusSpecies species = new FungusSpecies(defaultTraits, fungusType, spawnType);
        speciesHashMap.put(defaultTraits.species(), species);
        colorsMap.put(defaultTraits.species(), colors);
    }

    public FungusSpecies get(String speciesName)
    {
        return speciesHashMap.getOrDefault(speciesName, new FungusSpecies(FungusTraits.UNINIT, COLORED_WARPED_STRING, FungusSpawn.NO_SPAWN));
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
            collection.add(species.defaultItemStack());
        }
        return collection;
    }

    public ItemStack getCreativeTabIcon()
    {
        FungusSpecies species = new FungusSpecies(FungusTraits.CREATIVE_TAB_ICON, COLORED_CRIMSON_STRING, FungusSpawn.NO_SPAWN);
        return species.defaultItemStack();
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static class FungusSpecies implements Serializable
    {
        public FungusTraits defaultTraits;
        public String fungusType;
        public final FungusSpawn spawnInfo;

        public FungusSpecies(FungusTraits traits, String type, FungusSpawn spawnInfo)
        {
            defaultTraits = traits;
            fungusType = type;
            this.spawnInfo = spawnInfo;
        }

        public ItemStack defaultItemStack()
        {
            Optional<Holder.Reference<Item>> item = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, fungusType));
            ItemStack itemStack = new ItemStack(item.get());
            itemStack.applyComponents(DataComponentMap.builder().set(FUNGUS_GENOMA, new FungusGenoma(new FungusTraits(defaultTraits), new FungusTraits(defaultTraits))).build());
            return itemStack;
        }
    }

    @SubscribeEvent
    public static void syncEvent(OnDatapackSyncEvent evt)
    {
        if(null != evt.getPlayer())
            PacketDistributor.sendToPlayer(evt.getPlayer(), FungusSpeciesList.INSTANCE);
        else
            PacketDistributor.sendToAllPlayers(FungusSpeciesList.INSTANCE);
    }
}
