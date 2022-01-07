package com.mettsmirnov.mycology.myutils;

public class FloatComposition
{
    public static long compose(float a, float b)
    {
        long bitsOfA = Float.floatToRawIntBits(a);
        long bitsOfB = Float.floatToRawIntBits(b);

        bitsOfA = bitsOfA<<32;
        bitsOfB = bitsOfB & 0xffffffffL;
        return bitsOfA | bitsOfB;
    }

    public static float[] decompose(long bits)
    {
        float[] result = new float[2];

        result[0] = Float.intBitsToFloat((int)(bits >>> 32));
        result[1] = Float.intBitsToFloat((int)(bits));

        return result;
    }

    private FloatComposition(){}
}
