/***
 * Class to model the data structure Stack
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 21, 2023
 * Last Date Modified: March 25, 2023
 */
import java.util.*;
public class Stack<E>{
    //data members
    private ArrayList<E> elements;
    /***
    no-arg constructor
    creates an empty stack with capacity 10
    @param  none
    @return none
     */
    public Stack(){
        elements = new ArrayList<>(); 
    }
    /***
    method to push a new object onto the stack
    @param item to be pushed
    @return none
     */
    public void push(E item){
        elements.add(item);// add at the end of elements (top of the stack)
    }
    /***
    method to see what object is next in the stack
    @param  none
    @return the object next in the stack but doesnt remove it
     */
    public E peek(){
        int lastIndex = elements.size()-1; // get the index of the top
        return elements.get(lastIndex); // return the value at the top
    }
    /***
    method to pop the next object off the stack
    @param  none
    @return the object poped off the stack
     */
    public E pop(){
        int lastIndex = elements.size()-1; // get the index of the top
        E value =  elements.get(lastIndex);// get the value of the top
        elements.remove(lastIndex); // remove the top
        return value;
    }
    /***
    method to check if the stack is empty
    @param  none
    @return true if empty
    @return false if not empty
     */
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    /***
    method to return the size of the stack
    @param  none
    @return size of the stack
    */
    public int size(){
        return elements.size();
    }
    /***
    toString method to return formatted string to match that of a stack
    @param  none
    @return formatted string of data members in elements
    */
    public String toString(){
        return "Stack: " + elements.toString();
    }
    /***
    contains method to check if the stack contains an object
    @param  o the object to seach for
    @return true if it contains 
    @return false if it doesnt contain
    */
    public boolean contains(Object o){ //O(n)
        return elements.contains(o);
    }
    /***
    sort method to sort the stack by natural ordering
    @param  none
    @return none
    */
    public void sort(){ //O(n^2)
        elements.sort();
    }
    /***
    sort method to sort the stack using a given comparator
    @param c the comparator to sort with
    @return none
    */
    public void sort(Comparator<E> c){ //O(n^2)
        elements.sort(c);
    }
}