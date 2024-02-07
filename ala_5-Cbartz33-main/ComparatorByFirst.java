/***
 * Class to model the General comparator entity ComparatorByFirst
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 28, 2023
 * Last Date Modified: March 6, 2023
 */
import java.util.Comparator;
public class ComparatorByFirst<E1 extends Comparable<E1>,E2> implements Comparator<Pair<E1,E2>>{
    /***
    compare() method that will compare the first object in two different
    pairs with eachother
    @param  p1 of type pair for the first pair
    @param  p2 of type pair for the second pair
    @return -1, 0, or 1 depending on the order the pairs are compared
     */
    public int compare(Pair<E1,E2> p1, Pair<E1,E2> p2){
        E1 p1First = p1.getFirst();
        E1 p2First = p2.getFirst();
        return p1First.compareTo(p2First);
    }
}