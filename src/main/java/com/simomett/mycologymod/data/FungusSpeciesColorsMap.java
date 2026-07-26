package com.simomett.mycologymod.data;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.genetics.FungusTraits;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class FungusSpeciesColorsMap implements CustomPacketPayload, ISerializable
{
    public static final CustomPacketPayload.Type<FungusSpeciesColorsMap> TYPE = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fungus_colors_sync"));
    private final HashMap<String, int[]> colorsMap = new HashMap<>();

    protected static FungusSpeciesColorsMap INSTANCE = new FungusSpeciesColorsMap();

    public static FungusSpeciesColorsMap getInstance()
    {
        if(INSTANCE == null)
            throw new NullPointerException();
        return INSTANCE;
    }

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
    public static final StreamCodec<FriendlyByteBuf, FungusSpeciesColorsMap> COLORS_STREAM_CODEC = StreamCodec.ofMember(FungusSpeciesColorsMap::encode, FungusSpeciesColorsMap::fromByteBuf);

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
}

