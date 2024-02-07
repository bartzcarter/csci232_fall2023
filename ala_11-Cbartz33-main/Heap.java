/**
    @author: Carter Bartz/Lehigh Professors
    @version: 0.2
    Date of Creation: April 11, 2023
    Last date modified: May 1, 2023
    Generic class that implements the data structure Heap
*/
import java.util.ArrayList;
public class Heap<E extends Comparable<E>> {
    // data member: list of the heap nodes
    private ArrayList<E> list;
    public static int iterations;
    /**
        Default constructor to create an empty heap
        Time complexity: O(1)
    */
    public Heap(){
        list = new ArrayList<>();
    }
    /**
        Method to get the size of the heap
        @return the number of nodes in the heap
        Time complexity: O(1)
    */
    public int size(){ 
        return list.size(); 
    }
    /**
        Method to check if the heap is empty
        @return true if the heap is empty, false otherwise
        Time complexity: O(1)
    */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
        Method to clear the heap
        Time complexity: O(1)
    */
    public void clear(){
        list.clear(); 
    }
    /**
        Method to get the values stored in the heap as a string
        @return formatted string with the values of all the nodes in the heap
        Time complexity: O(n)
    */
    public String toString(){
        return list.toString();
    }
    /**
        Method to search for a value in the heap
        @param value to be searched in the heap
        @return true if value was found in the heap, false otherwise
        Time complexity: O(n)
    */
    public boolean contains(E value) {
        iterations = 0;
        for(int i=0; i<list.size(); i++) {
            iterations++;
            if(list.get(i).equals(value))
                return true;
        }
        return false;
    }
    /**
        Method to add a new value in the heap
        @param value to be added to the heap
        Time complexity: O(logn)
    */
    public void add(E value) {
        iterations = 0;
        list.add(value);// add value at the end of the list
        int currentIndex = list.size()-1; // index of the added node
        while(currentIndex > 0) {
            Sort.iterations[5]++;
            iterations++;
            int parentIndex = (currentIndex-1)/2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if(current.compareTo(parent) > 0) { // need to swap
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            }
            else
                break;
            currentIndex = parentIndex;
        }
    }
    /**
        Method to remove the root node from the heap
        @return the value of the root (the largest value in the heap)
        Time complexity: O(logn)
    */
    public E remove() {
        iterations = 0;
        if(list.size() == 0) 
            return null;
        E removedItem = list.get(0);// value of the root
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            iterations++;
            Sort.iterations[5]++;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if (left >= list.size()) 
                break;
            int maxIndex = left;
            E max = list.get(maxIndex);
            if (right < list.size())
            if(max.compareTo(list.get(right)) < 0)
                maxIndex = right;
            E current = list.get(currentIndex);
            max = list.get(maxIndex);            
            if(current.compareTo(max) < 0){
                list.set(maxIndex, current);
                list.set(currentIndex, max);
                currentIndex = maxIndex;
            }
            else
                break;
        }
        return removedItem;
    }
    /**
        Method to return the height of the Heap
        @return height(0) the recursive helper method to calculate the height
     */
    public int height(){
        return height(0);
    }
    /**
        Recursive helper method for height() 
        @param  nodeIndex the index to start at
        @return max height of either the left or right node of the node at nodeIndex (root)
     */
    public int height(int nodeIndex){
        if(nodeIndex >= list.size()){
            return 0;
        }
        return Math.max(height(nodeIndex * 2 + 1), height(nodeIndex * 2 + 2)) + 1;
    }
    /**
        Method to determine if the Heap is balanced or not
        @return isBalanced(0) the recursive helper method 
     */
    public boolean isBalanced(){
        return isBalanced(0);
    }
    /**
        Recursive helper method for isBalanced() to calculate if the Heap is balanced
        @param  nodeIndex the index to start at
        @return true if the Heap is balances and false otherwise
     */
    public boolean isBalanced(int nodeIndex){
        if(nodeIndex >= list.size()){
            return true;
        }
        int lHeight = height(nodeIndex * 2 + 1);
        int rHeight = height(nodeIndex * 2 + 2);
        int diff = Math.abs(lHeight - rHeight);
        if(diff > 1){
            return false;
        }
        return isBalanced(nodeIndex * 2 + 1) && isBalanced(nodeIndex * 2 + 2);
    }
}
