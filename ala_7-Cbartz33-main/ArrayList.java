/***
 * Class to model the data structure ArrayList
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 21, 2023
 * Last Date Modified: March 25, 2023
 */
import java.util.Iterator;
import java.util.*;
public class ArrayList<E> {
  // data members
  private E[] elements;
  private int size;
  public static int containsIter, sortIter, comparatorSortIter;
  /***
  Default no-arg constructor
  initialize elements and size
  @param  none
  @return none
   */
  public ArrayList() {
    elements = (E[]) new Object[10];
    size = 0;
  }
  /***
  1-arg constructor
  initialize elements using int capacity and size
  @param  int capacity to set size of elements array
  @return none
   */
  public ArrayList(int capacity) {
    elements = (E[]) new Object[capacity];
    size = 0;
  }
  /***
  boolean method to add an item to the ArrayList
  @param  item on object of type E to be added
  @return true when the item is added
   */
  public boolean add(E item) {
    return add(size, item);	// adding at the first free index
  }
  /***
  boolean method to add an item to the ArrayList at a given index
  @param  item on object of type E to be added
  @param  index where to add the item in the list
  @return true when the item is added
   */
  public boolean add(int index, E item){
    if(index > size || index < 0)
      throw new ArrayIndexOutOfBoundsException();
    ensureCapacity();
    for(int i=size-1; i>=index; i--){
      elements[i+1] = elements[i];
    }
    elements[index] = item;
    size++;
    return true;
  }
  /***
  Getter method for an object in the ArrayList at a given index
  @param  index the index of the object to be returned
  @return elements[index] the object at index
   */
  public E get(int index) {
    checkIndex(index);
    return elements[index];
  }
  /***
  Setter method for an index spot in elements
  @param  index where to set the item
  @param  item the object to be set
  @return oldItem the item that was replaced
   */
  public E set(int index, E item) {
    checkIndex(index);
    E oldItem = elements[index];
    elements[index] = item;
    return oldItem;
  }
  /***
  method to return the size of the list
  @param  none
  @return size of the list
   */
  public int size() {
    return size;
  }
  /***
  Method to clear the list
  set size to 0
  @param  none
  @return none
   */
  public void clear() {
    size = 0;
  }
  /***
  Method to check if the list is empty
  @param  none
  @return true if the size is now = 0
   */
  public boolean isEmpty() {
    return (size == 0);
  }
  /***
  Method to remove an object from the list
  @param  o the object to be removed from the list
  @return true if the object was found and removed
  @return false if the object was not found or removed
   */
  public boolean remove(Object o) {
    E item = (E) o; // casting down o to type E
    for(int i=0; i<size; i++)
      if(elements[i].equals(item)){
          remove(i);
          return true;
      }
    return false;
  }
  /***
  Method to remove an object at a given index from the list
  @param  index where to find the object to be removed from the list
  @return item that was removed
   */
  public E remove(int index) {
    checkIndex(index);
    E item = elements[index];
    for(int i=index; i<size-1; i++)
      elements[i] = elements[i+1];
    size--;
    return item;
  }
  /***
  Method to shrink the list to a given size
  @param  none
  @return none
   */
  public void trimToSize() {
    if (size != elements.length) {
        E[] newElements = (E[]) new Object[size];// capacity = size
        for(int i=0; i<size; i++)
          newElements[i] = elements[i];
        elements = newElements;
    }
  }
  /***
  Method to check if list needs to add more space
  @param  none
  @return the itterations to ensure capacity
   */
  private int ensureCapacity() {
      int iterations = 0;
    if(size >= elements.length) {
        int newCap = (int) (elements.length * 1.5);
        E[] newElements = (E[]) new Object[newCap];
        for(int i=0; i<size; i++){
                  iterations++;
          newElements[i] = elements[i];
            }
        elements = newElements;
    }
      return iterations;
  }
  /***
  Method to check if the index is a valid index for the array
  @param  index to be chekced
  @return none
  Throws ArrayIndexOutOfBoundsException
  */
  private void checkIndex(int index){
    if(index < 0 || index >= size)
        throw new ArrayIndexOutOfBoundsException(
            "Index out of bounds. Must be between 0 and "+(size-1));
  }
  /***
  toString method to return formatted string to match that of an ArrayList
  @param  none
  @return formatted string of data members in elements
   */
  public String toString() {
    String output = "[";
    for(int i=0; i<size-1; i++)
        output += elements[i] + ", ";
    output += elements[size-1] + "]";
    return output;
  }
  /***
  Method that provides an ArrayIterator to iterate through list
  @param  none
  @return ArrayIterator
   */
  public Iterator<E> iterator(){
    return new ArrayIterator();
  }
  /***
  Inner class that implements Iterator
  Provides this ArrayList an iterator to iterate thorugh list
   */
  private class ArrayIterator implements Iterator<E>{
    private int current = -1;
    /***
    hasNext method to ensure that there is more info in an array
    @param  none
    @return true if there is something next
    @return false if there is nothing left
     */
    public boolean hasNext() {
      return current < size-1;
    }
    /***
    next method to return the next object in the array
    @param  none
    @return elements[++current] the next object
     */
    public E next() {
      return elements[++current];
    }
  }
  /***
  contains method to check if the ArrayList contains an object
  @param  o the object to seach for
  @return true if it contains 
  @return false if it doesnt contain
   */
  public boolean contains(Object o){ //O(n)
    containsIter = 0;
    Iterator<E> iter = iterator(); //getting iterator of the array list 
    while(iter.hasNext()){       
      containsIter++;  
      if(iter.next().equals(o)){
        return true;
      }
    }
    return false;
  }
  /***
  sort method to sort the list by natural ordering
  @param  none
  @return none
   */
  public void sort(){ //O(n^2)
    sortIter = 0;
    for(int i=0; i<size; i++){
      sortIter++;
      int minIndex = i;
      E min = elements[i];
      for(int j=i; j<size; j++){
        sortIter++;
        Comparable<E> c = (Comparable<E>)elements[j];
        if(c.compareTo(min) < 0){
          min = elements[j];
          minIndex = j;
        }
      }
      E temp = elements[i];
      elements[i] = elements[minIndex];
      elements[minIndex] = temp;
    }
  }
  /***
  sort method to sort the list using a given comparator
  @param c the comparator to sort with
  @return none
   */
  public void sort(Comparator<E> c){ //O(n^2)
  comparatorSortIter = 0;
    for(int i=0; i<size; i++){
      comparatorSortIter++;
      int minIndex = i;
      E min = elements[i];
      for(int j=i; j<size; j++){
        comparatorSortIter++;
        if(c.compare(elements[j], min) < 0){
          min = elements[j];
          minIndex = j;
        }
      }
      E temp = elements[i];
      elements[i] = elements[minIndex];
      elements[minIndex] = temp;
    }
  }
}