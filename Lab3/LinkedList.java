/**
 * @author: Carter Bartz, Algorithms, 4th edition by Sedgewick and Wayne - edited from Lab1 LinkedList.java
 * Generic Unordered LinkedList data structure class
 */
import java.util.Iterator;

public class LinkedList<K extends Comparable<K>, V>{

    private Node head;  
    private Node cur;
    private int size = 0;

    // helper linked list class Node
    private class Node {
        private K Key;
        private V Value;
        private Node next;

        public Node(K Key, V Value, Node next) {
            this.Key = Key;
            this.Value = Value;
            this.next = next;
        }
    }

    public LinkedList() {
        head = null;
        cur = head;
    }

    /**
     * @param  none
     * @return  K - the key of the current data
     */
    public K getCurData() {
        if (cur != null) {
            return cur.Key;
        }
        else {
            return null;
        } 
    }

    /**
     * @param  none
     * @return  V - the value of the current data
     */
    public boolean nextData() {
        if (cur != null) {
            cur = cur.next;
        }
        return (cur != null); // false means no next data to move to
                              // in other words, at end of list
    }

    /**
     * @param  none
     * @return  boolean - true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @param  K key - the key to be inserted
     * @param  V value - the value to be inserted
     * @return  none
     */
    public void insert(K key, V value) {
        for (Node x = head; x != null; x = x.next) {
            if (key.equals(x.Key)) {
                x.Value = value;
                return;
            }
        }
        Node newNode = new Node(key, value, head);
        head = newNode;
    }

    /***
     * @param  K key - the key to be searched for
     * @return  boolean - true if key is found, false otherwise
     */
    public V get(K key) {
        for (Node x = head; x != null; x = x.next) {
            if (key.equals(x.Key)) {
                return x.Value;
            }
        }
        return null;
    }

    /**
     * @param  K key - the key to be searched for
     * @return  boolean - true if key is found, false otherwise
     */
    public void remove(K key) {
        if(head == null) {
            return;
        }
        if (head.Key.equals(key)) {
            head = head.next;
            return;
        }
        cur = head;
        while (cur.next != null) {
            if (cur.next.Key.equals(key)) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    /**
     * @param  none
     * @return  K - the minimum key in the list
     */
    public K minKey() {
        if (head == null) {
            return null;
        }
        K min = head.Key;
        for (Node x = head; x != null; x = x.next) {
            if (min.compareTo(x.Key) > 0) {
                min = x.Key;
            }
        }
        return min;
    }

    /**
     * @param  none
     * @return  K - the maximum key in the list
     */
    public K maxKey() {
        if (head == null) {
            return null;
        }
        K max = head.Key;
        for (Node x = head; x != null; x = x.next) {
            if (max.compareTo(x.Key) < 0) {
                max = x.Key;
            }
        }
        return max;
    }

    /***
     * @param  none
     * @return  boolean - true if at end of list, false otherwise
     */
    public boolean atEndOfList() {
        return (cur == null);
    }

    /**
     * @param  none
     * @return  none
     */
    public void goToHead() {
        cur = head;
    }

    /**
     * @param  none
     * @return  none
     */
    public String printListDataType() {
        this.goToHead();
        return cur.Key.getClass().getSimpleName();  
    }

    /**
     * @param  none
     * @return  int - the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * @param  none
     * @return  Iterator<K> - an iterator for the list
     */
    public Iterator<K> iterator() {
        return new ListIterator();
    }

    /**
     * @param  none
     * @return  Iterator<K> - an iterator for the list
     */
    private class ListIterator implements Iterator<K> {
        private Node current = head;

        /**
         * @param  none
         * @return  boolean - true if there is a next node, false otherwise
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @param  none
         * @return  K - the key of the next node
         */
        public K next() {
            K key = current.Key;
            current = current.next;
            return key;
        }
    }   
}
