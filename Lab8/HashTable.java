/**
 * HashTable Implementation using separate chaining
 * @param <Key>
 * @param <Value>
 * @author Carter Bartz
 * @version 1.0
 */
public class HashTable<Key, Value>{
    //default size of the hash table
    private int size = 5;
    //array of linked lists to store the key-value pairs
    private LinkedList<Key, Value>[] table;

    /**
     * Default constructor
     * Creates a hash table of size 5
     * Initializes the array of linked lists
     */
    public HashTable(){
        table = new LinkedList[size];
    }

    /**
     * Constructor
     * Creates a hash table of size size
     * Initializes the array of linked lists
     */
    public HashTable(int size){
        this.size = size;
        table = new LinkedList[size];
    }

    /**
     * Puts a key-value pair into the hash table
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        int index = hash(key);
        //if the index is empty, create a new linked list
        if(table[index] == null){
            table[index] = new LinkedList<Key, Value>();
        }
        //add the key-value pair to the linked list
        table[index].add(key, value);
    }

    /**
     * Gets the value associated with the key
     * @param key
     * @return value
     */
    public Value get(Key key){
        int index = hash(key);
        //if the index is empty, return null
        if(table[index] == null){
            return null;
        }
        //return the value associated with the key
        return table[index].get(key);
    }
 
    /**
     * hash function to determine the index of the key-value pair
     * @param key
     * @return index
     */
    private int hash(Key key) {
        char letter = key.toString().charAt(0);
        int positionInAlphabet = Character.toUpperCase(letter) - 'A' + 1;
        return (11 * positionInAlphabet) % size;
    }      

    /**
     * Displays the keys and values in the hash table
     */
    public void displayKeysAndValues() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                for (LinkedList.Node<Key, Value> node : table[i].getNodes()) {
                    System.out.printf("%-4s%-6s%-5s\n", node.key, node.value, "Hash: " + i);
                }
            }
        }
    }
}