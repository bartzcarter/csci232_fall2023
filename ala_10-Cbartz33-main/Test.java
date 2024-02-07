/***
 * Class that tests the HashMap, LinkedList, and BST search methods
 * @author Carter Bartz/Lehigh Professors
 * @version 0.1
 * Date of creation: April 17, 2023
 * Last Date Modified: April 23, 2023
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Test{
    /**
        Main Method
        @param args string of arguments
     */
    public static void main(String[]args){
        HashMap<String, String> hashWords = new HashMap<>(50000);//hashtable with capacity 65, 536
        BST<String> bstWords = new BST<>();
        LinkedList<String> llWords = new LinkedList<>();
        ArrayList<HashMapEntry<String,String>> words = new ArrayList<>();
        readFile(words, "dictionary.txt");
        java.util.Collections.shuffle(words);
        for(HashMapEntry<String, String> entry: words){
            hashWords.put(entry.getKey(), entry.getValue());//store words and definition
            bstWords.add(entry.getKey());//store word only
            llWords.add(entry.getKey());
        }
        int totalHash = 0, totalBST = 0, totalLL = 0;
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL Search", 
                                        "BST Search", "HashMap Search");
        for(int i=0; i<1000; i++){
            int randomIndex = (int)(Math.random() * words.size());
            String word = words.get(randomIndex).getKey();
            hashWords.get(word);
            bstWords.contains(word);
            llWords.contains(word);
            totalHash += HashMap.iterations;
            totalBST += BST.iterations;
            totalLL += LinkedList.containsIter;
            if(i % 50 == 0){
                System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", word, LinkedList.containsIter, 
                                        BST.iterations, HashMap.iterations);
            }
        }
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL/1000, 
                                        totalBST/1000, totalHash/1000);
        System.out.println("\n Maximum number of collisions: " + hashWords.collisions());

        /**
            Discussion: In the results of the test, we found that the LinkedList search 
            took the most amount of iterations followed by the BST, and then the HashMap.
            This information allows us to conclude that with a very large amount of data,
            the most efficient way to search for a certain data point is with the concept
            of the HashTable as long as it was implemented the right way. The llSearch must 
            visit almost every node until it is found. The BST is arranged in such a way that 
            cuts that number by logn every time, and then the hashing allows us to know exactly 
            what index it will be then all we have to do is search through a linked list that in 
            this case will never have more than 5 collsions. 
        */
    }
    /**
        Method to read from the file dictionary.txt
        Store the contents in the ArrayList
        @param  al the ArrayList<HashMapEntry<String,String>> to store files contents
        @param  filename the file dictionary.txt to read from
     */
    public static void readFile(ArrayList<HashMapEntry<String,String>> al, String filename){
        File file = new File(filename);
        int line1 = 1;
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] items = line.split("\\|");
                String word = items[0];
                String def = items[1];
                HashMapEntry<String,String> pair = new HashMapEntry<>(word, def);
                al.add(pair);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}