import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloatCompositionTest
{
    @Test
    public void floatCompositionTest()
    {
        float A = -1.5f;
        float B = 29.4f;

        long bitsOfA = (long) Float.floatToIntBits(A) <<32;
        int bitsOfB = Float.floatToIntBits(B);

        long compositeFloat = bitsOfA | bitsOfB;

        float decomposedA = Float.intBitsToFloat((int)(compositeFloat >> 32));
        float decomposedB = Float.intBitsToFloat((int)(compositeFloat));

        assertEquals(-1.5f,decomposedA);
        assertEquals(29.4f,decomposedB);
    }
}
