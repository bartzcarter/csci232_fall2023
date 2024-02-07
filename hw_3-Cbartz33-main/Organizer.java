/***
 * Class to model the Entity Organizer
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 6, 2023
 * Last Date Modified: March 9, 2023
 */
import java.util.*;
public class Organizer<E>{
    //data members
    private ArrayList<E> elements;
    private Comparator<E> comparator;
    /***
    1-arg constructor 
    @param  cap the integer value that will initialize a max amoount
    for the array list elements
    @return none
     */
    public Organizer(int cap){ //O(1)
        elements = new ArrayList<>(cap);
        comparator = null;
    }
    /***
    2-arg constructor 
    @param  cap the integer value that will initialize a max amoount
    for the array list elements
    @param  comp the comparator that will set the data members comparator */
    public Organizer(int cap, Comparator<E> comp){ //O(1)
        elements = new ArrayList<>(cap);
        comparator = comp;
    }
    /***
    void method that will add an object to the array list elements
    the array list will then be sorted by natural ordering (pre-defined)
    @param  e the object that will be added to elements
    @return none
     */
    public void addElement(E e){ // O(1)
        elements.add(e);
        Collections.sort(elements, comparator);
    }
    /***
    method that will use recursive binary search to search for
    an object in the elements array list
    @param  e the object so be searched for
    @return the object that was searched for
     */
    public E findElement(E e){ //O(1)
        int first = 0;
        int last = elements.size() - 1;
        return findElement(e, first, last);
    } 
    /***
    recursive helper method for findElement(E)
    performed recursive binary search on the array list elements
    @param  key the object to be searched for
    @param  first the int value of the current first index
    @param last the int value of the current last index
     */
    public E findElement(E key, int first, int last){ //O(1)
        if (first > last){
            return null;
        }
        else{
            int middle = (last + first) / 2;
            if(comparator == null){
                if(((Comparable)(elements.get(middle))).compareTo(key) == 0){
                    return elements.get(middle);
                }
                else if(((Comparable)(elements.get(middle))).compareTo(key) < 0){
                    first = middle + 1;
                }
                else if(((Comparable)(elements.get(middle))).compareTo(key) > 0){
                    last = middle - 1;
                }
                return findElement(key, first, last); 
            }
            else{
                if(comparator.compare(elements.get(middle), key) == 0){
                    return elements.get(middle);
                }
                else if(comparator.compare(elements.get(middle), key) < 0){
                    last = middle - 1;
                }
                else if(comparator.compare(elements.get(middle), key) > 0){
                    first = middle + 1;
                }
                return findElement(key, first, last);
            }
        }
    }
    /***
    method to remove an object from the elements array list
    @param e the object to be removed
    @return the object that is removed
     */
    public E removeElement(E e){ //O(1)
        elements.remove(e);
        return e;
    }
    /***
    void method to set the data member comparator
    Determines the way the array list will be sorted
    @param comp the comparator that will be set 
    @return none
     */
    public void setComparator(Comparator<E> comp){ //O(1)
        comparator = comp;
        Collections.sort(elements, comparator);
    }
    /***
    Overriden toString() method to return formatted string
    of the data member elements and the information withheld in the 
    array list
    @param  none
    @return formatted string of data member elements information
     */
    @Override
    public String toString(){ //O(n)
        String out = "";
        for(E e: elements){
            out += e + "\n";
        }
        return out;
    } 
}