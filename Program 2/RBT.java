/**
 * Red-Black Tree implementation
 * @author Professor Oudghiri - Lehigh University // Carter Bartz
 * @version 1.0
 */

//import Arraylist to return iterable of all data in tree
import java.util.ArrayList;

public class RBT<T> {
    private Node<T> root;

    // Node class for tree to hold data
    private static class Node<T> {
        // Data fields
        T data;
        Node<T> left, right;
        boolean isRed;

        // Constructor
        Node(T data) {
            this.data = data;
            this.isRed = true;
        }
    }

    /**
     * Insert data into the tree
     * @param data the data to insert
     * @return true if data was inserted, false if data was already in the tree
     */
    public void insert(T data) {
        root = insert(root, data);
        // Make root black
        root.isRed = false;
    }

    /**
     * recursive helper method to insert data into the tree
     * @param node the root of the tree
     * @param data the data to insert
     * @return the new root of the tree
     */
    private Node<T> insert(Node<T> node, T data) {
        // Base case - found a null node
        if (node == null) {
            return new Node(data);
        }
        
        // Recursive case - insert data instance of Data
        if (data instanceof Data) {  
            // Cast data to Data
            Data d = (Data)data;
            Data n = (Data)node.data;
            
            // Compare data to node - insert left if less than, right if greater than
            if (d.getValue() < n.getValue()) {
                node.left = insert(node.left, data);
            } else if (d.getValue() >= n.getValue()) {  
                node.right = insert(node.right, data);
            }
        }
        
        return balance(node);
    }

    private Node<T> balance(Node<T> node) {
        // Check if right child is red and left child is black
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        // Check if left child and left grandchild are red
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        // Check if both children are red
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        // Return balanced node
        return node;
    }



    /**
     * Check if a node is red
     * @param node the node to check
     * @return true if the node is red, false otherwise
     */
    private boolean isRed(Node<T> node) {
        // Check if node is null
        if (node == null) {
            return false;
        }
        // Return node color
        return node.isRed;
    }

    /**
     * Rotate a node to the left
     * @param node the node to rotate
     * @return the new root of the subtree
     */
    private Node<T> rotateLeft(Node<T> node) {
        // Save right child
        Node<T> temp = node.right;
        // Rotate
        node.right = temp.left;
        // Move left child to right child
        temp.left = node;
        // Set colors
        temp.isRed = node.isRed;
        node.isRed = true;
        // Return new root
        return temp;
    }

    /**
     * Rotate a node to the right
     * @param node the node to rotate
     * @return the new root of the subtree
     */
    private Node<T> rotateRight(Node<T> node) {
        // Save left child
        Node<T> temp = node.left;
        // Rotate
        node.left = temp.right;
        // Move right child to left child
        temp.right = node;
        // Set colors
        temp.isRed = node.isRed;
        node.isRed = true;
        // Return new root
        return temp;
    }

    /**
     * Flip the colors of a node and its children
     * @param node the node to flip
     */
    private void flipColors(Node<T> node) {
        // Flip colors
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }   

    /**
     * Find a node in the tree
     * @param data the data to find
     * @return the node containing the data, or null if the data is not in the tree
     */
    public T findMax(){
        // Start at root
        Node<T> current = root;
        // Traverse right until null
        while (current.right != null){
            current = current.right;
        }
        // Return max
        return current.data;
    }

    /**
     * Find the minimum value in the tree
     * @return the minimum value in the tree
     */
    public T findMin(){
        // Start at root
        Node<T> current = root;
        // Traverse left until null
        while (current.left != null){
            current = current.left;
        }
        // Return min
        return current.data;
    }

    /**
     * Iterate through the tree in order
     * @return an iterable of all data in the tree in order
     */
    public ArrayList<T> inOrder(){
        // Create list to hold data
        ArrayList<T> list = new ArrayList<T>();
        // Call recursive helper method
        inOrder(root, list);
        // Return list
        return list;
    }

    /**
     * Recursive helper method to iterate through the tree in order
     * @param node the root of the tree
     * @param list the list to add data to
     */
    private void inOrder(Node<T> node, ArrayList<T> list){
        // Base case - null node - do nothing
        // Recursive case - add left, add root, add right
        if (node != null){
            inOrder(node.left, list);
            list.add(node.data);
            inOrder(node.right, list);
        }
    }
}
