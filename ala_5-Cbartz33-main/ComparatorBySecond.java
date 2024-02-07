/***
 * Class to model the General comparator entity ComparatorBySecond
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 28, 2023
 * Last Date Modified: March 6, 2023
 */
import java.util.Comparator;
public class ComparatorBySecond<E1,E2 extends Comparable<E2>> implements Comparator<Pair<E1,E2>>{
    /***
    compare() method that will compare the second object in two different
    pairs with eachother
    @param  p1 of type pair for the first pair
    @param  p2 of type pair for the second pair
    @return -1, 0, or 1 depending on the order the pairs are compared
     */
    public int compare(Pair<E1,E2> p1, Pair<E1,E2> p2){
        E2 p1Second = p1.getSecond();
        E2 p2Second = p2.getSecond();
        return p1Second.compareTo(p2Second);
    }
}