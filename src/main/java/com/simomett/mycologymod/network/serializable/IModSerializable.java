package com.simomett.mycologymod.network.serializable;

import net.minecraft.network.FriendlyByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface IModSerializable extends Serializable
{
    default void encode(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] serialized = serialize();
            byteBuf.writeInt(serialized.length);
            byteBuf.writeBytes(serialized);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    default byte[] serialize() throws IOException
    {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(this);
        return b.toByteArray();
    }
}
