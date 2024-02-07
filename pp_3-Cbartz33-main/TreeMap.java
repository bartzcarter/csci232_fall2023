/***
 * Class to model a BST that will have nodes of type HashMapEntry
 * @author Carter Bartz 
 * @version 0.1
 * Date of creation: April 25, 2023
 * Last Date Modified: April 26, 2023
 */
import java.util.ArrayList;
import java.util.Comparator;
public class TreeMap<K,V>{
    private TreeNode root;
    private int size;
    private Comparator<K> c;
    public static int iterations;
    private class TreeNode{
        // data member: the HashMapEntry of the node
        HashMapEntry<K,V> entry;
        // data member: reference to the left child node
        TreeNode left;
        // data member: reference to the right child node
        TreeNode right;
        /**
            Constructor to initialize the value of the tree node
            sets the left and right child to null
        */
        TreeNode(HashMapEntry<K,V> e){
            entry = e;
            left = right = null;
        }
    }
    /**
        1-arg constructor to set Comparator<K>
        @param  c to set Comparator<K>
        set root to null, and size to 0
     */
    public TreeMap(Comparator<K> c){
        this.c = c;
        root = null;
        size = 0;
    }
    /**
        method to return the size of the TreeMap
        @return size
     */
    public int size(){
        return size;
    }
    /**
        method to check if the TreeMap is empty
        @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return (size == 0);
    }
    /**
        Void Method to clear the TreeMap
        set root to null, and size to 0
     */
    public void clear(){
        root = null;
        size = 0;
    }
    /**
        Method to check if the TreeMap contains a given key
        @param  key to search for
        @return true if the TreeMap contains the key, false otherwise
     */
    public boolean containsKey(K key){
        TreeNode node = root;
        while (node != null) {
            if( c.compare(key, node.entry.getKey()) < 0)
                node = node.left;
            else if (c.compare(key, node.entry.getKey())> 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }
    /**
        Mehtod to get a HashMapEntry from the TreeMap given a key
        @param  key to search for and return
        @return node.entry.getValue() returns the value of the key found in TreeMap
        @return null if the key is not found in the TreeMap
     */
    public V get(K key){
        iterations = 0;
        if(containsKey(key)){
            TreeNode parent, node;
            parent = null; node = root;
            // Find value first
            while (node != null) {
                iterations++;
                if (c.compare(key, node.entry.getKey()) < 0) {
                    parent = node;
                    node = node.left;// go left
                }
                else if (c.compare(key, node.entry.getKey()) > 0) {
                    parent = node;
                    node = node.right;//go right
                }
                else
                    return node.entry.getValue(); // value found
            }   
        }
        return null;
    }
    /**
        Method to add a HashMapEntry to the TreeMap
        @param  key the key of the entry
        @param  value the value of the entry
        @return true once added succesfully
     */
    public boolean add(K key, V value){
        if (root == null) // the first node to be inserted
            root = new TreeNode(new HashMapEntry(key, value));
        else {
            TreeNode parent, node;
            parent = null; node = root;
            while (node != null) { // Looking for a leaf node
                parent = node;
                if(c.compare(key, node.entry.getKey()) < 0) {
                    node = node.left; 
                }
                else if (c.compare(key, node.entry.getKey()) > 0) {
                    node = node.right;
                }
                else{
                    node.entry.setValue(value);
                    return true;
                }   
            }
            if (c.compare(key, parent.entry.getKey())< 0)
                parent.left = new TreeNode(new HashMapEntry(key, value));
            else
                parent.right = new TreeNode(new HashMapEntry(key, value));
        }
        size++;
        return true; 
    }
    /**
       Method to change the child of a parent node
       @param   parent the node whos child is to be changed
       @param   node the node that will be changed
       @param   newChile the node that will be the new child
     */
    private void changeChild(TreeNode parent, TreeNode node, TreeNode newChild){
        if(parent.left == node)
            parent.left = newChild;
        else
            parent.right = newChild;
    }
    /**
       Method to remove an entry from the TreeMap given the key
       @param   key to search for and remove
       @return  true if found and removed
       @return  false if key not found
     */
    public boolean remove(K key){
        TreeNode parent, node;
        parent = null; node = root;
        // Find value first
        while (node != null) {
            if (c.compare(key, node.entry.getKey()) < 0) {
                parent = node;
                node = node.left;// go left
            }
            else if (c.compare(key, node.entry.getKey()) > 0) {
                parent = node;
                node = node.right;//go right
            }
            else
                break; // value found
        }
        if (node == null) // value not in the tree
            return false;
        // Case 1: node has no children
        if(node.left == null && node.right == null){
            if(parent == null) // delete root
                root = null;
            else
                changeChild(parent, node, null);
        }
        else if(node.left == null){ 
            //case 2: node has one right child
            if (parent == null) // delete root
                root = node.right;
            else
                changeChild(parent, node, node.right);
        }
        else if(node.right == null){ 
            //case 2: node has one left child
            if (parent == null) // delete root
                root = node.left;
            else
                changeChild(parent, node, node.left);
        } 
        else { 
            // case 3: node has two children
            TreeNode rightMostParent = node;
            TreeNode rightMost = node.left;
            // go right on the left subtree
            while (rightMost.right != null) {
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            // copy the value of rigthMost to node
            node.entry = rightMost.entry;
            //delete rigthMost
            changeChild(rightMostParent,rightMost,
                        rightMost.left);
        }
        size--;
        return true;
    }
    /**
       Method that will print the TreeMap in order by key
       calls recursive helper method
     */
    public void inorder(){
        inorder(root);
    }
    /**
      recursive helper method to inorder() that will print in LNR inorder
      @param   node to be called recursively then eventually printed
     */
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.entry + " ");
            inorder(node.right);
        }
    }
    /**
       Method that will print the TreeMap in a preorder by key
       calls recursive helper method
     */
    public void preorder() {
        preorder(root);
    }
    /**
      recursive helper method to preorder() that will print in NLR order
      @param   node to be called recursively then eventually printed
     */
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.entry + " ");
            preorder(node.left);
            preorder(node.right);
        }
    } 
    /**
       Method that will print the TreeMap in a postorder by key
       calls recursive helper method
     */
    public void postorder() {
        postorder(root);
    }
    /**
      recursive helper method to postorder() that will print in LRN order
      @param   node to be called recursively then eventually printed
     */
    private void postorder(TreeNode node)  {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.entry + " "); 
        }
    }   
    /**
        Method that will return an ArrayList with
        the HashMapEntry's from the TreeMap inorder sorted by key
        @return list the sorted list of entrys
        calls recursive helper method 
        Time Complexity: O(n)
     */
    public ArrayList<HashMapEntry<K,V>> sortedKeys(){
        ArrayList<HashMapEntry<K,V>> list = new ArrayList<>();
        iterations = 0;
        return sortedKeys(list, root);
    } 
    /**
        recursive helper method to sortedKeys()
        follows the same algo as inorder, but adds node to 
        list instead of printing.
        @param  list to be added and returned
        @param  node to be called recursively then added to list
     */
    public ArrayList<HashMapEntry<K,V>> sortedKeys(ArrayList<HashMapEntry<K,V>> list, TreeNode node){
        iterations++;
        if (node != null) {
            sortedKeys(list, node.left);
            list.add(node.entry);
            sortedKeys(list, node.right);
        }
        return list;
    }
}  