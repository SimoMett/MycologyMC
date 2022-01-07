import com.mettsmirnov.mycology.myutils.FloatComposition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloatCompositionTest
{
    @Test
    public void floatCompositionTest()
    {
        float A = -29f;
        float B = 1.5f;

        long compositeFloat = FloatComposition.compose(A,B);

        float[] floats = FloatComposition.decompose(compositeFloat);

        assertEquals(A,floats[0]);
        assertEquals(B,floats[1]);
    }
}
