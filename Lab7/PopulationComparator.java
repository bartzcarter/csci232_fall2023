/**
 * This class is used to compare two Data objects based on their newCases attribute.
 * @author Carter Bartz
 * @version 1.0
 */
import java.util.Comparator;

public class PopulationComparator implements Comparator<Data> {
    // Compare method
    @Override
    public int compare(Data data1, Data data2) {
        // Compare data1 and data2 based on their newCases attribute
        return Long.compare(data1.getPopulation(), data2.getPopulation());
    }
}