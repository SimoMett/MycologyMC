import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.genetics.Breeding;
import org.junit.jupiter.api.Test;

public class BreedingTest
{
    @Test
    public void crossBreed()
    {
        FungusSpeciesList.FungusSpecies whiteFungusSpecies = FungusSpeciesList.INSTANCE.get("WHITE_FUNGUS");
        FungusSpeciesList.FungusSpecies lactariusViridisSpecies = FungusSpeciesList.INSTANCE.get("Lactarius viridis");

        FungusDataModel whiteFungus = new FungusDataModel();
        whiteFungus.loadFrom(whiteFungusSpecies);
        FungusDataModel lactariusViridis = new FungusDataModel();
        lactariusViridis.loadFrom(lactariusViridisSpecies);

        FungusDataModel offspring = Breeding.crossBreed(whiteFungus, lactariusViridis);

        return;
    }
}
