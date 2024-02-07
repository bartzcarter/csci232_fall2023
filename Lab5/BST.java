/**
 * @author: Carter Bartz
 * @date: 10/10/2023
 * Generic Binary Search Tree class that implements the Comparable interface using Key and Value
 */
import java.util.Queue;
import java.util.LinkedList;
public class BST<K extends Comparable<K>, V>{
    //private instance variables
    private TreeNode root;
    private int size;
    //private inner class TreeNode
    private class TreeNode{
        K Key;
        V Value;
        TreeNode left;
        TreeNode right;
        TreeNode(K Key, V Value){
            this.Key = Key;
            this.Value = Value;
            left = right = null;
        }
    }
    //constructor
    BST(){
        root = null;
        size = 0;
    }
    //method to get the size of the tree
    public int size(){
        return size;
    }
    //method to check if the tree is empty
    public boolean isEmpty(){
        return size == 0;
    }
    //method to clear the tree
    public void clear(){
        root = null;
        size = 0;
    }
    //search method
    public boolean contains(K Key){
        //start at the root
        TreeNode node = root;
        //search for the value
        while(node != null){
            if(Key.compareTo(node.Key) < 0){
                node = node.left;
            }
            else if(Key.compareTo(node.Key) > 0){
                node = node.right;
            }
            else{
                return true;
            }
        }
        return false;
    }
    //method to put a key and value into the tree
    public boolean put(K Key, V Value){
        //if the tree is empty, create a new root
        if(root == null){
            root = new TreeNode(Key, Value);
            size++;
            return true;
        }
        //if the tree is not empty, find the right place to insert the new node
        else{
            TreeNode node = root;
            while(node != null){
                //if the key is less than the current node's key, go left
                if(Key.compareTo(node.Key) < 0){
                    if(node.left == null){
                        node.left = new TreeNode(Key, Value);
                        size++;
                        return true;
                    }
                    else{
                        node = node.left;
                    }
                }
                //if the key is greater than the current node's key, go right
                else if(Key.compareTo(node.Key) > 0){
                    if(node.right == null){
                        node.right = new TreeNode(Key, Value);
                        size++;
                        return true;
                    }
                    else{
                        node = node.right;
                    }
                }
                //if the key is equal to the current node's key, replace the value
                else{
                    node.Value = Value;
                    return true;
                }
            }
        }
        return false;
    }
    //method to remove a node from the tree
    public boolean remove(K Key){
        TreeNode node, parent;
        parent = null;
        node = root;
        //find value first
        while(node != null){
            if(Key.compareTo(node.Key) < 0){
                parent = node;
                node = node.left;
            }
            else if(Key.compareTo(node.Key) > 0){
                parent = node;
                node = node.right;
            }
            else{
                break; //value found
            }
        }
        if(node == null){ //value not in the tree
            return false;
        }
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
        else{
            //case 3: node has two children
            TreeNode rightMostParent = node;
            TreeNode rightMost = node.left;
            while(rightMost.right != null){
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            //copy the value of rightMost to node
            node.Key = rightMost.Key;
            //delete rightMost node
            changeChild(rightMostParent, rightMost, rightMost.left);
        }
        size--;
        return true;
    }
    //helper method to change the child of a node
    private void changeChild(TreeNode parent, TreeNode node, TreeNode newChild){
        if(parent.left == node){
            parent.left = newChild;
        }
        else{
            parent.right = newChild;
        }
    }
    //recursive method inorder()
    public void inorder(){
        inorder(root);
    }
    //recursive helper method inorder()
    private void inorder(TreeNode node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.Key + " " + node.Value + ", ");
            inorder(node.right);
        }
    }
    //recursive method preorder()
    public void preorder(){
        preorder(root);
    }
    //recursive helper method preorder()
    private void preorder(TreeNode node){
        if(node != null){
            System.out.print(node.Key + " " + node.Value + ", ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    //recursive method postorder()
    public void postorder(){
        postorder(root);
    }
    //recursive helper method postorder()
    private void postorder(TreeNode node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.Key + " " + node.Value + ", ");
        }
    }
    //level order traversal
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.remove();
            System.out.print(node.Key + " " + node.Value + ", ");
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    }
}