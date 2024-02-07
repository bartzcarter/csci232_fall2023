/**
 * Driver class for the HashTable class
 * Reads keys from a file and inserts them into the hash table
 * @author Carter Bartz
 * @version 1.0
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Create a hash table
        HashTable<Character, Integer> symbolTable = new HashTable<>();
        //used for assigning a number to each letter (Value)
        int count = 0;
        // Read keys from the file and insert into the hash table
        try (Scanner scanner = new Scanner(new File("lab8-2in.txt"))) {
            while (scanner.hasNext()) {
                char key = scanner.next().charAt(0);
                int value = count; // Assign a number to each letter
                symbolTable.put(key, value);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display keys and values in the hash table
        symbolTable.displayKeysAndValues();
    }
}
