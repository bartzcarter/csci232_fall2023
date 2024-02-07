/**
 * MinPQ.java
 * generic class that implements a minimum priority queue
 * @author Carter Bartz
 * @version 1.0
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
        int i;
        for (i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(i), data) > 0) {
                break;
            }
        }
        list.add(i, data);
    }

    /**
     * removeMin method
     * @return E the minimum element
     * @throws NoSuchElementException if the minPQ is empty
     * @param void
     * @return E
     */
    public E removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("MinPQ is empty");
        }
        return list.remove(list.size() - 1);
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
    /**
     * removeMax method
     * @throws NoSuchElementException if the minPQ is empty
     * @param void
     * @return E the maximum element
     */
    public E removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("MinPQ is empty");
        }
        return list.remove(0);
    }
}