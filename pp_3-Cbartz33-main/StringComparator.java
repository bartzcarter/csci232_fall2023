/***
 * Class to compare two strings 
 * @author Carter Bartz 
 * @version 0.1
 * Date of creation: April 25, 2023
 * Last Date Modified: April 26, 2023
 */
import java.util.Comparator;
public class StringComparator implements Comparator<String>{
    /**
        Method that will split two strings at the "@" operator
        Will then compare these two strings by compareTo()
        @param s1 the first string 
        @param s2 the second string
        @return 0 if equal, -1 if s1 less than s2, and 1 if s1 greater than s2
     */
     public int compare(String s1, String s2){
        String [] str1 = s1.split("@");
        String [] str2 = s2.split("@");
        return str1[0].compareTo(str2[0]);
    }
}