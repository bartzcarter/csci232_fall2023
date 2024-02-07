/***
 * Class to model the data structure PriorityQueue
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 21, 2023
 * Last Date Modified: March 25, 2023
 */
import java.util.Comparator;
import java.util.*;
public class PriorityQueue<E> {
    //data members
   private ArrayList<E> list;
   private Comparator<E> comparator;
   /***
   default no-arg constructor
   using compareTo for the priority 
   @param   none
   @return  none
    */
   public PriorityQueue() { // O(1)
     list = new ArrayList<>();
     comparator = null;
   }
   /***
   1-arg constructor
   using compare on the object comparator
   @param   c the comparator to sort by
   @return none
    */
   public PriorityQueue(Comparator<E> c) { // O(1)
      list = new ArrayList<>();
      comparator = c;
   }
   /***
   Method to remove the next object in the queue
   @param   none
   @return  the object that was removed
    */
   public E poll() { //O(n)
		E value = list.get(0);
		list.remove(0);
        return value;
   }
   /***
   Method to offer a new object to the queue
   @param   item to be offered
   @return none
    */
   public void offer(E item) { //O(n)
    int i, c;
    for(i=0; i<list.size(); i++){
        if(comparator == null)
            c = ((Comparable<E>)item).compareTo(list.get(i));
        else
	        c = comparator.compare(item, list.get(i));
	    if(c < 0)
            break;
    }
    list.add(i, item);
   }
    /***
    method to see what object is next in the queue
    @param  none
    @return the object next in the queue but doesnt remove it
     */
   public E peek() { //O(1)
      return list.get(0);
   }
    /***
    toString method to return formatted string to match that of a PriorityQueue
    @param  none
    @return formatted string of data members in elements
    */
   public String toString() { //O(n)
		return "Priority Queue: " + list.toString();
   }
    /***
    method to return the size of the queue
    @param  none
    @return size of the queue
    */
   public int size() { //O(1)
    return list.size();
   }
    /***
    Method to clear the queue
    set size to 0
    @param  none
    @return none
   */
   public void clear() { //O(1)
    list.clear();
   }
    /***
    method to check if the queue is empty
    @param  none
    @return true if empty
    @return false if not empty
     */
   public boolean isEmpty() { //O(1)
    return list.isEmpty();
   }
    /***
    contains method to check if the queue contains an object
    @param  o the object to seach for
    @return true if it contains 
    @return false if it doesnt contain
    */
   public boolean contains(Object o){//O(n)
      return list.contains(o);
   }
    /***
    sort method to sort the queue by natural ordering
    @param  none
    @return none
    */
   public void sort(){ //O(n^2)
        list.sort();
    }
    /***
    sort method to sort the queue using a given comparator
    @param c the comparator to sort with
    @return none
    */
    public void sort(Comparator<E> c){//O(n^2)
        list.sort(c);
    }
}