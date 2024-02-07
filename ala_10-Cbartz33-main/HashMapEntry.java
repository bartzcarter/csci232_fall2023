/***
 * Class that implements Hashmap entries with two generic types
	K for key
	V for value
 * @author Carter Bartz/Lehigh Professors
 * @version 0.1
 * Date of creation: April 17, 2023
 * Last Date Modified: April 23, 2023
 */
public class HashMapEntry<K, V> {
	//data members key and value
	private K key;
	private V value;
	/**
	 	2-arg constructor to set the data members key and value
		@param	k to set Key
		@param	v to set Value
	 */
	public HashMapEntry(K k, V v) {
		key = k;
		value = v;
	}
	/**
	 	getter method to return the key
		@return	key of the entry
	 */
	public K getKey() { 
        return key; 
    }
	/**
	 	getter method to return the value
		@return	value of the entry
	 */
	public V getValue() { 
        return value; 
    }
	/**
	 	setter method to set the key
		@param	k to set the key
	 */
	public void setKey(K k) {
		key = k;
	}
	/**
	 	setter method to set the value
		@param	v to set the value
	 */
	public void setValue(V v) {
		value = v;
	}
	/**
	 	@override toString method
		@return formatted string to match that of pair (K,V)
	 */
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}