/***
 * Class to model the Comparator ComparatorByTitle
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 6, 2023
 * Last Date Modified: March 9, 2023
 */
import java.util.*;
public class ComparatorByTitle implements Comparator<Note>{
    /***
    compare(Note, Note) method that will compare two Note objects by their titles
    Allows the use of the comparator to sort Notes by title
    @param  n1 one note to comprare
    @param  n2 second note to comprare
    @return -1,0, or 1 depending on how n1 and n2 emails compare
     */
    public int compare(Note n1, Note n2){
        String note1 = n1.getTitle();
        String note2 = n2.getTitle();
        return note1.compareTo(note2);
    }
}