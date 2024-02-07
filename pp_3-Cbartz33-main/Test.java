/***
 * Class to test the data structurs HashMapSC, HashMapLP, and TreeMap
 * @author Carter Bartz 
 * @version 0.1
 * Date of creation: April 25, 2023
 * Last Date Modified: April 26, 2023
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;
public class Test{
    //Main method
    public static void main(String[] args){
        //Instantiate the data structures of type (String,String)
        TreeMap<String, String> tm = new TreeMap<>(new StringComparator());
        HashMapSC<String, String> sc = new HashMapSC<>(100000);
        HashMapLP<String, String> lp = new HashMapLP<>(100000);

        //Array that wil hold the read in mailing list from mailingList.txt
        HashMapEntry[] mailing = new HashMapEntry[100];

        //read files mailingList.txt, and emails.txt
        readMailing(mailing, "mailingList.txt");
        readFile(tm, sc, lp, "emails.txt");

        //testing get() and comparing iterations
        System.out.println("Testing get()");
        testingGet(tm, sc, lp, mailing);
        /**
            Discussion:  The results we see from this test are a great way to 
            show that HashMap's are a wonderful way to search through a very large
            amount of data. Here we see that the TreeMap has an average of around 20 
            iterations, while the two HashMaps are both either 1 or 2 iterations. HashMaps
            are very efficient for searching data, but come with a trade of of space.
         */

        //testing sortedKeys() and comparing iterations
        System.out.println("\nTesting sort() - number of iterations");
        Comparator<String> c = new StringComparator();
        testingSort(tm, sc, lp, c);
        /**
            Discussion:  Here we can see that the TreeMap is much more 
            efficient when it comes to sorting a very large amount of data 
            compared to the HashMaps. The most efficient of the HashMaps is the 
            one that uses separate chaining which allows for fewer collisions.
         */

        //testing put and comparing collisions
        System.out.println("\nTesting put() - number of collisions");
        testingPut("emails.txt");
        /**
            Discussion:  In this test we can see that there is a pattern with the size
            of the data structure for both of the HashMaps. This is do to the capacity that 
            we get from trimming to the power of 2. Certain sizes will trim to the same power. 
            Here we can see that 50,000 and 100,000 are different, but the next three sizes have 
            the same amount of collisions due to them having the same power of 2 capacity. This is the
            same for 300,000 - 500,000 in both of the HashMaps.
         */
    }
    /**
        Method to read from the file mailingList.txt and store in the array mailing
        @param  mailing the [] to store the information
        @param  filename the file to be read in 
     */
    public static void readMailing(HashMapEntry[] mailing, String filename){
        File file = new File(filename);
        int index = 0;
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String[] info = read.nextLine().split(" ");
                HashMapEntry<String, String> newEntry = new HashMapEntry(info[0], info[1]);
                mailing[index++] = newEntry;
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    /**
        Method to read from the file emails.txt and store in the data structures tm, sc, and lp
        @param  tm the TreeMap
        @param  sc the HashTableSC using separate chaining
        @param  lp the HashTableLP using linear probing
        @param  filename the file to be read in 
     */
    public static void readFile(TreeMap tm, HashMapSC sc, HashMapLP lp, String filename){
        File file = new File(filename);
        int count = 0;
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                String[] info = readFile.nextLine().split(" ");
                tm.add(info[0], info[1]);
                sc.put(info[0], info[1]);
                lp.put(info[0], info[1]);
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    /**
        Method to test the get() method in tm, sc, and lp
        @param  tm the TreeMap
        @param  sc the HashTableSC using separate chaining
        @param  lp the HashTableLP using linear probing
        @param  mailing the [] storing the mailing list to search from
     */
    public static void testingGet(TreeMap tm, HashMapSC sc, HashMapLP lp, HashMapEntry[] mailing){
        int tmTotalIter = 0;
        int scTotalIter = 0;
        int lpTotalIter = 0;
        int random;
        System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", "Username", "TreeMap", "HashMapSC", "HashMapLP");
        for(int i=0; i<20; i++){
            random = (int)(Math.random() * mailing.length);
            tm.get(mailing[random].getKey());
            tmTotalIter += TreeMap.iterations;
            sc.get(mailing[random].getKey());
            scTotalIter += HashMapSC.iterations;
            lp.get(mailing[random].getKey());
            lpTotalIter += HashMapLP.iterations;
            System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", mailing[random].getKey(), TreeMap.iterations, HashMapSC.iterations, HashMapLP.iterations);
        }
        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "Average", tmTotalIter/20, scTotalIter/20, lpTotalIter/20);
    }
    /**
        Method to test the sortedKeys() method in tm, sc, and lp
        @param  tm the TreeMap
        @param  sc the HashTableSC using separate chaining
        @param  lp the HashTableLP using linear probing
        @param  c the Comparator<String> to pass to the HashTables so they can order by key
     */
    public static void testingSort(TreeMap tm, HashMapSC sc, HashMapLP lp, Comparator<String> c){
        tm.sortedKeys();
        sc.sortedKeys(c);
        lp.sortedKeys(c);
        System.out.printf("%-20s\t%-10d\n", "TreeMap", tm.iterations);
        System.out.printf("%-20s\t%-10d\n", "HashMapSC", sc.iterations);
        System.out.printf("%-20s\t%-10d\n", "HashMapLP", lp.iterations);
    }
    /**
       @param  filename the file to be read to the structures of different sizes
       Calculates the number of collisions and presents the data to the user
     */
    public static void testingPut(String filename){
        System.out.printf("%-20s\t%-10s\t%-10s\n", "Size", "HashMapSC", "HashMapLP");
        //temporary TreeMap to satisfy the readFile parameters, will not be filled, just passed
        TreeMap<String, String> tm = new TreeMap<>(new StringComparator());
        for(int i=1; i<11; i++){
            HashMapSC<String, String> sc = new HashMapSC<>(i*50000);
            HashMapLP<String, String> lp = new HashMapLP<>(i*50000);
            readFile(tm, sc, lp, filename);
            System.out.printf("%-20d\t%-10d\t%-10d\n", i*50000, sc.collisions, lp.collisions);
        }
    }
}