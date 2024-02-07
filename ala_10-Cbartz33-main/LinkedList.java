/***
 * Class to model the data structure LinkedList
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 28, 2023
 * Last Date Modified: April 01, 2023
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;
public class LinkedList<E> {
    // Data members
    private Node head, tail;
    private int size;
    public static int containsIter, removeIter, addIter;
    /***
    Inner class Node that will allow the linked list to have nodes 
    pointing at other nodes
     */
    private class Node {
        //data members
        E value;
        Node next;
        /***
        1-arg constructor that sets the data member value 
        and sets the data member next
        @param  initialValue to keep track of the current value and set value
         */
        Node(E initialValue) {
            value = initialValue;
            next = null;
        }
    }
    /***
    no-arg constructor to set head and tail to null
    and set the size to 0
    @param  none
    @return none
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    /***
    boolean method to add a node to the front of the linked list and set as head
    and tail if its the only node in the linked list
    @param  item the object to be added
    @return true when the node has been added and size was incremented
     */
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }
    /***
    boolean method to add a node to the end of the linked list and set as tail
    and head if its the only node in the linked list
    @param  item the object to be added
    @return true when the node has been added and size was incremented
     */
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }
    /***
    boolean method to add to the LinkedList 
    just adds to the end and returns addLast()
    @param  item the object to be added
    @return addLast() - true when added and size incremented
     */
    public boolean add(E item) {
        return addLast(item);
    }
    /***
    Method to return the item from the list that is at the front 
    @param  none
    @return head.value the object or throw exception if head is null
     */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }
    /***
    Method to return the item from the list that is at the end
    @param  none
    @return tail.value the object or throw exception if head is null
     */
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }
    /***
    Method to remove an item from the linked list at the front
    @param  none
    @return true if the head was removed or throw exception if there is none in the list
     */
    public boolean removeFirst() { //O(1)
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return true;
    }
    /***
    Method to remove an item from the linked list at the end
    @param  none
    @return true if the tail was removed or throw exception if there is none in the list
     */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        size--;
        return true;
    }
    /***
    ToString() method to return a formatted string to resemble 
    that of a LinkedList
    @param  none
    @return output the string containing LinkedList Nodes
     */
    public String toString() {
        String output = "[";
        Node node = head;
        while (node != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += "]";
        return output;
    }
    /***
    Mehtod to clear the LinkedList
    @param  none
    @return none
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }
    /***
    Method to check if the LinkeList is empty or not
    @param  none
    @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /***
    method to return the current size of the LinkedList
    @param  none
    @return size the number of nodes in the LinkedList
     */
    public int size() {
        return size;
    }
    /***
    Method to generate an iterator for the LinkedList
    @param  none
    @return LinkedListIterator()
     */
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    /***
    Inner class to represent the LinkedListIterator and allow the 
    iteration of the LinkedList 
     */
    private class LinkedListIterator implements Iterator<E> {
        //data members
        private Node current = head;
        /***
        boolean method to return weather or not there is a
        node at the next iteration or if current is null
        @param  none
        @return true if not null
        @return false if null
         */
        public boolean hasNext() {
            return (current != null);
        }
        /***
        method to return the object that is in the next node if not null
        @param  none
        @return value the object in the next node
         */
        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }
    /***
    boolean method to check if the LinkedList contains an object
    @param  o the object to search for
    @return true if the LinkedList contains the object and false otherwise
     */
    public boolean contains(Object o){   //O(n) time complexity 
        containsIter = 0;
        E value = (E) o;
        Iterator<E> iter = iterator();
        while(iter.hasNext()){
            containsIter++;
            if(iter.next().equals(value))
            {
                return true;
            }
        }
        return false;
    }
    /***
    Method to remove a given object from the LinkedList
    @param  o the object to be removed
    @return true if the object was found and removed and false otherwise
    */
    public boolean remove(Object o){    //O(n) time complexity 
        Node current = head;
        Node previous = null;
        removeIter = 0;
        while(current != null && !current.value.equals(o)){
            removeIter++;
            previous = current;
            current = current.next;
        }
        if(current == null){
            return false;
        }
        if(previous == null){
            return removeFirst();
        }
        else{
            previous.next = current.next;
            if(current == tail){
                tail = previous;
            }
            size--;
            return true;
        }
    }
    /***
    Method to add to the LinkedList at a given index
    @param  index the location to add the newNode
    @param  element to be passed to newNode
    @return true when added to the LinkeList
     */
    public boolean add(int index, E element){   //O(n) time complexity 
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        addIter = 0;
        if(index == 0){
            return addFirst(element);
        }
        if(index == size){
            return addLast(element);
        }
        Node current = head;
        Node previous = null;
        for(int i=0; i<index; i++){
            addIter++;
            previous = current;
            current = current.next;
        }
        Node newNode = new Node(element);
        previous.next = newNode;
        newNode.next = current;
        size++;
        return true;
    }
}