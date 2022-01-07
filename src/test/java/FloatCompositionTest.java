import com.mettsmirnov.mycology.myutils.FloatComposition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloatCompositionTest
{
    @Test
    public void floatCompositionTest()
    {
        float A = -29F;
        float B = -6F;

        long compositeFloat = FloatComposition.compose(A,B);

        float[] floats = FloatComposition.decompose(compositeFloat);

        assertEquals(A,floats[0]);
        assertEquals(B,floats[1]);
    }
}
