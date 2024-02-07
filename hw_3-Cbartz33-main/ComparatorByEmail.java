/***
 * Class to model the Comparator ComparatorByEmail
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 6, 2023
 * Last Date Modified: March 9, 2023
 */
import java.util.Comparator;
public class ComparatorByEmail implements Comparator<Contact>{
    /***
    compare(Contact, Contact) method that will compare two Contact objects by their emails
    Allows the use of the comparator to sort Contacts by email
    @param  c1 one contact to comprare
    @param  c2 second contact to comprare
    @return -1,0, or 1 depending on how c1 and c2 emails compare
     */
    public int compare(Contact c1, Contact c2){
        String email1 = c1.getEmail();
        String email2 = c2.getEmail();
        return email1.compareTo(email2);
    }
}