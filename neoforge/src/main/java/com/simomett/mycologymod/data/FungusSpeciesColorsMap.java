package com.simomett.mycologymod.data;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.genetics.FungusTraits;
import com.simomett.mycologymod.network.serializable.IModSerializable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class FungusSpeciesColorsMap implements CustomPacketPayload, IModSerializable
{
    public static final CustomPacketPayload.Type<FungusSpeciesColorsMap> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "fungus_colors_sync"));
    private final HashMap<String, int[]> colorsMap = new HashMap<>();

    public static FungusSpeciesColorsMap INSTANCE = new FungusSpeciesColorsMap();

    private FungusSpeciesColorsMap(){}

    public static FungusSpeciesColorsMap fromByteBuf(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] dst = new byte[byteBuf.readInt()];
            byteBuf.readBytes(dst);
            ByteArrayInputStream i = new ByteArrayInputStream(dst);
            ObjectInputStream inputStream = new ObjectInputStream(i);
            return INSTANCE = (FungusSpeciesColorsMap) inputStream.readObject();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public final void put(FungusTraits defaultTraits, int[] colors)
    {
        put(defaultTraits.species(), colors);
    }

    public final void put(String speciesName, int[] colors)
    {
        if(colors.length!=4)
            throw new IllegalArgumentException("colors array must have length of 4");
        colorsMap.put(speciesName, colors);
    }

    public int[] get(String speciesName)
    {
        return colorsMap.getOrDefault(speciesName, new int[]{0, 0, 0, 0});
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    @SubscribeEvent
    public static void syncEvent(OnDatapackSyncEvent evt)
    {
        if(null != evt.getPlayer())
            PacketDistributor.sendToPlayer(evt.getPlayer(), FungusSpeciesColorsMap.INSTANCE);
        else
            PacketDistributor.sendToAllPlayers(FungusSpeciesColorsMap.INSTANCE);
    }
}
