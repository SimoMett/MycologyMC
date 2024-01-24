import com.mettsmirnov.mycology.genetics.FungusTraits;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MemberReflectionTest
{
    @Test
    public void printMembers()
    {
        for(Field f : FungusTraits.class.getDeclaredFields())
        {
            if (!Modifier.isStatic(f.getModifiers()))
                System.out.println(f.getName());
        }
    }
}
