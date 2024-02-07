/***
 * @author Carter Bartz
 * Generic Symbol Table data structure class using unordered LinkedList - non pre-defined by java
 */
import java.util.Iterator;

public class LLSymbolTable<K extends Comparable<K>,V>{
    private LinkedList<K,V> table;
    public LLSymbolTable(){
        table = new LinkedList<K,V>();
    }

    /**
     * @param  K key - the key to be inserted
     * @param  V value - the value to be inserted
     * @return  none
     */
    public void put(K key, V value){
        table.insert(key,value);
    }

    /**
     * @param  K key - the key to be searched for
     * @return  value - the value of the key
     * @return  null - if the key is not found
     */
    public V get(K key){
        return table.get(key);
    }

    /**
     * @param  K key - the key to be searched for
     * @return  boolean - true if the key is found, false otherwise
     */
    public void delete(K key){
        table.remove(key);
    }

    /**
     * @param  K key - the key to be searched for
     * @return  boolean - true if the key is found, false otherwise
     */
    public K min(){
        return table.minKey();
    }

    /**
     * @param  K key - the key to be searched for
     * @return  boolean - true if the key is found, false otherwise
     */
    public K max(){
        return table.maxKey();
    }

    /**
     * @param  K key - the key to be searched for
     * @return  boolean - true if the key is found, false otherwise
     */
    public Iterator<K> iterator(){
        return table.iterator();
    }
}