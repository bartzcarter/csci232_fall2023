/***
 * @author: Carter Bartz
 * Generic Symbol Table data structure class using java predefined TreeMap
 */
import java.util.TreeMap;
import java.util.Iterator;

public class SymbolTable<K extends Comparable<K>, V>{
    private TreeMap<K,V> table;
    public SymbolTable(){
        table = new TreeMap<K,V>();
    }

    /**
     * @param  K key - the key to be inserted
     * @param  V value - the value to be inserted
     * @return  none
     */
    public void put(K key, V value){
        table.put(key,value);
    }

    /**
     * @param  K key - the key to be searched for
     * @return  V - the value of the key
     * @return  null - if the key is not found
     */
    public V get(K key){
        return table.get(key);
    }

    /**
     * @param  K key - the key to be searched for and deleted
     * @return  V - the value of the key
     * @return  null - if the key is not found
     */
    public V delete(K key){
        return table.remove(key);
    }

    /**
     * @param  none
     * @return  K - the minimum key
     */
    public K min(){
        return table.firstKey();
    }

    /**
     * @param  none
     * @return  K - the maximum key
     */
    public K max(){
        return table.lastKey();
    }

    /**
     * @param  K key - the key to be searched for
     * @return  boolean - true if the key is found, false otherwise
     */
    public boolean contains(K key){
        return table.containsKey(key);
    }

    /**
     * @param  none
     * @return  boolean - true if the table is empty, false otherwise
     */
    public boolean isEmpty(){
        return table.isEmpty();
    }

    /**
     * @param  none
     * @return  int - the size of the table
     */
    public int size(){
        return table.size();
    }

    /**
     * @param  none
     * @return  Iterator<K> - an iterator for the table
     */
    public Iterator<K> iterator(){
        return table.keySet().iterator();
    }
}