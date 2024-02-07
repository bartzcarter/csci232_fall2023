/**
 * Linked List implementation for HashTable.java
 * ArrayList used for getNodes() method to return iterable list of nodes
 * @param <Key>
 * @param <Value>
 * @author Carter Bartz
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

    public class LinkedList<Key, Value> {
        //head of the linked list
        private Node<Key, Value> head;

        //Node class for the linked list
        public static class Node<Key, Value> {
        //key-value pair
        public Key key;
        public Value value;
        private Node<Key, Value> next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Adds a key-value pair to the linked list
     * @param key
     * @param value
     */
    public void add(Key key, Value value) {
        Node<Key, Value> newNode = new Node<>(key, value);
        //if the linked list is empty, set the head to the new node
        if (head == null) {
            head = newNode;
        } 
        //else, add the new node to the front of the linked list
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Gets the value associated with the key
     * @param key
     * @return value
     */
    public Value get(Key key) {
        //if the linked list is empty, return null
        Node<Key, Value> current = head;
        while (current != null) {
            //if the key is found, return the value
            if (key.equals(current.key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Returns an iterable list of nodes
     * @return nodes
     */
    public Iterable<Node<Key, Value>> getNodes() {
        List<Node<Key, Value>> nodes = new ArrayList<>();
        Node<Key, Value> current = head;
        //add each node to the list
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        //return the list
        return nodes;
    }

    /**
     * Returns the size of the linked list
     * @return size
     */
    public int size() {
        int size = 0;
        Node<Key, Value> current = head;
        //increment size for each node in the linked list
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
