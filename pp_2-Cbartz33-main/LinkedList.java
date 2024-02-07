/***
 * @author Carter Bartz/Lehigh Professors
 * @version 0.1
 * Date of creation: April 10, 2023
 * Last Date Modified: April 12, 2023
 */
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
    Linked List data structure (Double Linked)
 */
public class LinkedList<E>{
    // Data members: references to the head and tail nodes
	private Node head, tail;
    // data member: size of the list
	int size;
    /**
        Inner class Node
     */ 
	private class Node{
        //Data members value, next, and previous
		E value;
		Node next;
        Node previous;
        /**
            Constructor with one parameter
            sets the value and initializes next to null
            @param initialValue the value of the node
         */
		Node(E initialValue){//O(1)
			value = initialValue; 
            next = null;
            previous = null;
		}
	}
    /**
        default constructor
        sets the head and tail to null and size to 0
     */ 
	public LinkedList() { //O(1)
		head = tail = null;
		size = 0;
	}
    /**
        Adding an item at the head of the list
        @param value of the node to be added
        @return true if the node was added successfully
    */
    public boolean addFirst(E value) {//O(1)
		Node newNode = new Node(value);
		if(head == null) {
            head = tail = newNode; 
        }
		else { 
            newNode.next = head;
            head.previous = newNode;
			head = newNode;
		}
		size++; 
        return true;
    }
    /**
        Adding an item at the end of the list
        @param value of the node to be added
        @return true if the node was added successfully
    */
    public boolean addLast(E value) {//O(1)
		Node newNode = new Node(value);
		if(head == null) { 
            head = tail = newNode; 
            head.previous = null;
            tail.next = null;
        }
		else { 
            tail.next = newNode; 
            newNode.previous = tail;
            tail = newNode; 
            tail.next = null;
        }
		size++; 
        return true;
    }
    /**
        Adding an item at the tail of the list (inherited from Collection)
        @param value of the node to be added
        @return true if the node was added successfully
    */
    public boolean add(E value) {
		return addLast(value);
    }
    /**
        Retrieving the value of the first node in the list
        @return the value of the node at the head of the list
        @throws NoSuchElementException if the list is empty
        time complexity: O(1)
     */
    public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
    }
    /**
        Retrieving the value of the last node in the list
        @return the value of the node at the tail of the list
        @throws NoSuchElementException if the list is empty
        time complexity: O(1)
     */
    public E getLast() {
		if (head == null)
			throw new NoSuchElementException();
		return tail.value;
    } 
    /**
        Removing the first node from the list
        @return true if the node was removed successfully
        @throws NoSuchElementException if the list is empty
     */
    public boolean removeFirst() { //O(1)
		if (head == null) 
            throw new NoSuchElementException();
		head = head.next;
        head.previous = null;
		if(head == null)
            tail = null;
		size--; 
        return true;
    }
    /**
        Removing the last node from the list
        @return true if the node was removed successfully
        @throws NoSuchElementException if the list is empty
    */
    public boolean removeLast() {//O(n)
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
        tail.previous = previous.previous;
        tail = previous;
        size--;
        return true;
    }
    /**
        Get the value of the node at position index
        @param index of the node being accessed
        @return the value of the node at index
        @throws ArrayIndexOutOfBoundsException if index < 0 or index >= size
        time complexity: O(n)
     */
    public E get(int index){ 
        if(index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        if(index == 0){
            return getFirst();
        }
        if(index == size-1){
            return getLast();
        }
        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node.value;
    }
    /**
        Set the value of the node at position index
        @param index of the node being modified
        @return the old value of the modified node
        @throws ArrayIndexOutOfBoundsException if index < 0 or index >= size
        time complexity: O(n)
     */
    public E set(int index, E value){
        if(index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        E old;
        if(index == 0){
            old = head.value;
            head.value = value;
            return old;
        }
        if(index == size-1){
            old = tail.value;
            tail.value = value;
            return old;
        }
        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        old = node.value;
        node.value = value;
        return old;
    }

    /**
        @override toString from class Object
        @return formatted string with all the values in the list
        time complexity: O(n)
     */
    public String toString() {
		String output = "[";
		Node node = head;
		while(node != null) {
			output += node.value + " ";
			node = node.next;
		}
		output += "]";
		return output;
    }
    /**
        clear the list
        sets head and tail to null and size to 0
        time complexity: O(1)
     */
    public void clear() {
        head = tail = null; 
        size = 0; 
    }
    /**
        check if the list is empty
        @return true if the list is empty, false otherwise
        time complexity: O(1)
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
        get the size of the list
        @return the number of nodes in the list
        time complexity: O(1)
     */
    public int size() {
        return size; 
    } 
    /**
        Get an iterator for the list
        @return an iterator object pointing to the first node in the list
        time complexity: O(1)
     */
    public Iterator<E> iterator(){
		  return new LinkedListIterator();
    }
    /**
        Inner class that implements the interface Iterator
     */
    private class LinkedListIterator implements Iterator<E>{
        // data member: reference to the node referenced by the iterator
		private Node current = head;
        /**
            check if the iterator has a next node
            @return true if the iterator has access to the next node, false otherwise
            time complexity: O(1)
         */
		public boolean hasNext() {
			return (current != null);
		}
        /**
            get the value of the current noe and move the iterator to the next node
            @return the value of the current node
            time complexity: O(1)
         */
	    public E next() {
            if(current == null)
			  throw new NoSuchElementException();
			E value = current.value;
			current = current.next; 
            return value;
		}
    }
    /**
        Inner class that implements the interface ListIterator
     */
    private class list_Iterator implements ListIterator<E>{
        /** 
            data member: current reference to the node referenced by the iterator
            data member: previous reference to the node previously referenced by the iterator
        */
		private Node current;
        private Node previous;
        /**
            Constructor to start the iterator at the start of the list
         */
        list_Iterator(){//O(1)
            current = head;
            previous = null;
        }
         /**
            Constructor to start the iterator at a given index
            @param  index the index where the iterator will point at
         */
        list_Iterator(int index){//O(n)
            current = head;
            for(int i=0; i<=index; i++){
                current = current.next;
            }
            previous = current.previous;
        }
        /**
            check if the iterator has a next node
            @return true if the iterator has access to the next node, false otherwise
            time complexity: O(1)
         */
		public boolean hasNext() {//O(1)
			return (current != null);
		}
        /**
            check if the iterator has a previous node
            @return true if the iterator has access to the previous node, false otherwise
            time complexity: O(1)
         */
        public boolean hasPrevious(){//O(1)
            return (previous != null);
        }
        /**
            get the value of the current node and move the iterator to the next node
            @return the value of the current node
            time complexity: O(1)
         */
	    public E next() { //O(1)
            if(current == null)
			  throw new NoSuchElementException();
			E value = current.value;
            previous = current;
			current = current.next;
            return value;
		}
        /**
            get the value of the previous node and move the iterator to the previous node
            @return the value of the previous node
            time complexity: O(1)
         */
        public E previous(){//O(1)
            if(previous == null){
                throw new NoSuchElementException();
            }
            E value = previous.value;
            current = previous;
            previous = current.previous;
            return value;
        }
        /**
            Method to satisfy the ListIterator<E> interface
         */
        public void add(E value){//O(1)
            throw new UnsupportedOperationException();
        }
        /**
            Method to satisfy the ListIterator<E> interface
         */
        public void remove(){//O(1)
            throw new UnsupportedOperationException();
        }
        /**
            Method to satisfy the ListIterator<E> interface
         */
        public void set(E value){//O(1)
            throw new UnsupportedOperationException();
        }
        /**
            Method to satisfy the ListIterator<E> interface
         */
        public int nextIndex(){//O(1)
            throw new UnsupportedOperationException();
        }
        /**
            Method to satisfy the ListIterator<E> interface
         */
        public int previousIndex(){//O(1)
            throw new UnsupportedOperationException();
        }
    }
    /**
        Method to get a bidirectional iterator for the list
        @return an iterator object pointing to the first node of the list
     */
    public ListIterator<E> listIterator(){//O(1)
        return new list_Iterator();
    }
    /**
        Method to get a bidirectional iterator for the list
        @param index where the iterator should start
        @return the iterator object pointing to the element at index
        @throws ArrayIndexOutOfBoundsExeption if index is less than 0 or index is greater than size
     */
    public ListIterator<E> listIterator(int index){//O(n)
        if(index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return new list_Iterator(index);
    }
}