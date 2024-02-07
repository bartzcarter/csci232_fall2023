/***
 * RedBlackTree.java
 * This class implements a Red Black Tree using a Node class
 * Segments of this code are from Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne
 * Some code is modified by Carter Bartz
 */

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    // The root of the tree
    private Node root;

    // The Node class
    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean isRed;

        /***
         * Constructor for the Node class
         * @param key The key of the node
         * @param value The value of the node
         * @param isRed Whether the node is red or black
         * @return A new Node object
         */
        Node(Key key, Value value, boolean isRed) {
            this.key = key;
            this.value = value;
            this.isRed = isRed;
        }
    }

    /***
     * get method for the RedBlackTree class
     * @param key The key of the node to get
     * @return The value of the node
     */
    public Value get(Key key) {
        Node node = get(root, key);
        return (node != null) ? node.value : null;
    }

    /***
     * get method for the RedBlackTree class
     * @param node The node to get
     * @param key The key of the node to get
     * @return The value of the node
     */
    private Node get(Node node, Key key) {
        // If the node is null, return null
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        // Compare the key to the node's key
        if (cmp < 0) return get(node.left, key);
        // If the key is less than the node's key, go left
        else if (cmp > 0) return get(node.right, key);
        // If the key is greater than the node's key, go right
        else return node;
    }

    /***
     * put method for the RedBlackTree class
     * @param key The key of the node to put
     * @param value The value of the node to put
     * @return The value of the node
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.isRed = false;
    }

    /***
     * recursive put method for the RedBlackTree class
     * @param node The node to put
     * @param key The key of the node to put
     * @param value The value of the node to put
     * @return The value of the node
     */
    private Node put(Node node, Key key, Value value) {
        // If the node is null, return a new node
        if (node == null) return new Node(key, value, true);

        // Compare the key to the node's key
        int cmp = key.compareTo(node.key);

        // If the key is less than the node's key, go left
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        // Fix the tree
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    /***
     * keys method for the RedBlackTree class
     * @return An iterable of the keys in the tree
     */
    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    /***
     * recursive inOrder method for the RedBlackTree class
     * @param node The node to start at
     * @param keys The list of keys to add to
     */
    private void inOrder(Node node, List<Key> keys) {
        if (node == null) return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /***
     * rotateLeft method for the RedBlackTree class
     * @param h The node to rotate
     * @return The rotated node
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }

    /***
     * rotateRight method for the RedBlackTree class
     * @param h The node to rotate
     * @return The rotated node
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }

    /***
     * flipColors method for the RedBlackTree class
     * @param h The node to flip the colors of
     */
    private void flipColors(Node h) {
        h.isRed = !h.isRed;
        h.left.isRed = !h.left.isRed;
        h.right.isRed = !h.right.isRed;
    }

    /***
     * isRed method for the RedBlackTree class
     * @param node The node to check
     * @return Whether the node is red or not
     */
    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.isRed;
    }

    /***
     * getColor method for the RedBlackTree class
     * @param key The key of the node to get the color of
     * @return The color of the node
     */
    public String getColor(String key){
        Node node = get(root, (Key)key);
        return (node != null) ? (node.isRed) ? " Red" : " Black" : null;
    }
}
