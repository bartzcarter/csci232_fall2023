/***
 * Class to provide the Comparator StringComparator
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 21, 2023
 * Last Date Modified: March 25, 2023
 */
import java.util.*;
public class StringComparator implements Comparator<String>{
    /***
    The compare method that is used to order strings by their lenght
    when the comparator object StringComparator is used
    @param  s1 the firts string to comare
    @param  s2 the second string to compare to s1
    @return >0 if s1 longer than s2
    @return <0 if s1 shorter than s2
    @return 0 if they are the same length
     */
    public int compare(String s1, String s2){
        return s1.length() - s2.length();
    }
}