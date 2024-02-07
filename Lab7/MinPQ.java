/**
 * MinPQ.java
 * generic class that implements a minimum priority queue adjusted to use binary heap logic
 * @author Carter Bartz
 * @version 2.0
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinPQ<E> {
    //underlying data structure
    private ArrayList<E> list;
    //comparator to compare the elements and sort the minPQ
    private Comparator<E> comparator;

    //constructor
    public MinPQ(Comparator<E> comparator) {
        list = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * insert method
     * @param data the data to be inserted
     * @return void
     */
    public void insert(E data) {
        list.add(data);
        swim(list.size() - 1);
    }

    /**
     * removeMin method adjusted for binary heap logic
     * @return E the minimum element
     * @throws NoSuchElementException if the minPQ is empty
     * @param void
     * @return E
     */
    public E removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("MinPQ is empty");
        }
        E min = list.get(0);
        int lastIndex = list.size() - 1;
        list.set(0, list.get(lastIndex));
        list.remove(lastIndex);
        sink(0);
        return min;
    }

    /**
     * swim method adjusted for binary heap logic
     * @param index the index of the element to swim
     * @return void
     */
    private void swim(int index) {
        // Compare the element at index to its parent
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            // If the element at index is greater than its parent, swap them
            if (comparator.compare(list.get(index), list.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * sink method adjusted for binary heap logic
     * @param index the index of the element to sink
     * @return void
     */
    private void sink(int index) {
        int leftChild, rightChild, largest;
        // Compare the element at index to its children
        while (2 * index + 1 < list.size()) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largest = leftChild;
            // If the right child is larger than the left child, use the right child
            if (rightChild < list.size() && comparator.compare(list.get(rightChild), list.get(leftChild)) > 0) {
                largest = rightChild;
            }
            // If the element at index is less than its largest child, swap them
            if (comparator.compare(list.get(index), list.get(largest)) < 0) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    /**
     * swap method
     * @param i the first index to swap
     * @param j the second index to swap
     * @return void
     */
    private void swap(int i, int j) {
        // Swap the elements at indices i and j
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * size method
     * @param void
     * @return int the size of the minPQ
     */
    public int size() {
        return list.size();
    }

    /**
     * isEmpty method
     * @param void
     * @return boolean true if the minPQ is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * clear method
     * @param void
     * @return void
     */
    public void clear() {
        list.clear();
    }

    /**
     * contains method
     * @param data the data to be searched for
     * @return boolean true if the minPQ contains the data, false otherwise
     */
    public boolean contains(E data) {
        return list.contains(data);
    }

    /**
     * containsKey method
     * @param key the key to be searched for
     * @return boolean true if the minPQ contains the key, false otherwise
     */
    public boolean containsKey(long key) {
        for (E data : list) {
            if (data instanceof Data) {
                Data d = (Data) data; // Cast to Data
                if (d.getNewCases() == key) {
                    return true;
                }
            }
        }
        return false;
    }
}