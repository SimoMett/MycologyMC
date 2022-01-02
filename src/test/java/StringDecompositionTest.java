import com.mettsmirnov.mycology.myutils.StringDecomposition;
import org.jline.utils.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDecompositionTest
{
    @Test
    public void correctness()
    {
        String string1 = "dominant:recessive";
        String[] array = StringDecomposition.decompose(string1,':');
        assertEquals("dominant", array[0]);
        assertEquals("recessive", array[1]);
    }

    @Test
    public void timeExecution()
    {
        int count=0;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis()<startTime+1000)
        {
            String string1 = "dominant:recessive";
            String[] array = StringDecomposition.decompose(string1, ':');
            count++;
        }
        Log.info("Number of iterations: "+count);
    }
}