/***
 * Class to Tests the data structures ArrayList, Stack, PriorityQueue
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 21, 2023
 * Last Date Modified: March 25, 2023
 */
import java.util.*;
import java.io.*;
public class Test{
    public static void main(String[]args){
        ArrayList<String> animalAL = new ArrayList<>();
        Stack<String> animalStack = new Stack<>();
        PriorityQueue<String> animalPQ = new PriorityQueue<>();
        readAnimals("animals.txt", animalAL, animalStack, animalPQ);
        int alTotal=0, sTotal=0, pqTotal=0;
        //testing contains(
        System.out.println("Testing the contains() method");
        System.out.printf("%-30s\t%-10s\t%-10s\t%-10s\n", "Animal", "ArrayList", "Stack", "PriorityQueue");
        for(int i=0; i<20; i++){
            int randomIndex = (int)(Math.random() * animalAL.size());
            String randomAnimal = animalAL.get(randomIndex);
            animalAL.contains(randomAnimal);
            int alIter = ArrayList.containsIter;
            alTotal += alIter;
            animalStack.contains(randomAnimal);
            int stackIter = ArrayList.containsIter;
            sTotal += stackIter;
            animalPQ.contains(randomAnimal);
            int pqIter = ArrayList.containsIter;
            pqTotal += pqIter;
            System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", randomAnimal, alIter, stackIter, pqIter);
        }
        /**
        Every run provides a random sample of animals in the three data structures
        The numbers printed are the iterations that each data structure took to perform the operations 
        Some numbers are simular as in the arrayList and Stack for they are more simular than 
        the PriorityQueue is to the others.
        The priority queue has a different natural ordering so thats why its iterations are differnt from the rest
         */
        System.out.println();
        System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", "Average", alTotal/20, sTotal/20, pqTotal/20);
        System.out.println();
        //testing sort
        System.out.println("Contents of the three data structures" + "\n");
        System.out.println("ArrayList: " + animalAL + "\n");
        System.out.println(animalStack + "\n");
        System.out.println(animalPQ + "\n\n");

        animalAL.sort();
        int alSortN = ArrayList.sortIter;
        animalStack.sort();
        int StackSortN = ArrayList.sortIter;
        animalPQ.sort();
        int pqSortN = ArrayList.sortIter;
        System.out.println("Contents of the three data structures after sorting using the natural ordering" + "\n");
        System.out.println("ArrayList: " + animalAL + "\n");
        System.out.println(animalStack + "\n");
        System.out.println(animalPQ + "\n\n");
        /***
        After sorting we can see that the contents in the three data structures are all sorted by natural ordering 
        We did not need to sort the PriorityQueue because its natural ordering was already a-z
         */

        StringComparator sc = new StringComparator();
        animalAL.sort(sc);
        int alSortC = ArrayList.comparatorSortIter;
        animalStack.sort(sc);
        int StackSortC = ArrayList.comparatorSortIter;
        animalPQ.sort(sc);
        int pqSortC = ArrayList.comparatorSortIter;
        System.out.println("Contents of the three data structures after sorting using a string comparator" + "\n");
        System.out.println("ArrayList: " + animalAL + "\n");
        System.out.println(animalStack + "\n");
        System.out.println(animalPQ + "\n");

        System.out.println("Testing sort methods: ");
        System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", "Sorting Method", "ArrayList", "Stack", "PriorityQueue");
        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "Sort()", alSortN, StackSortN, pqSortN);
        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "Sort(Comparator)", alSortC, StackSortC, pqSortC);
        /***
        From testing the sort methods we see that the iterations were all exactly the same in all three
        data structires for both of the sort methods
        They are all the same size and are put into the same ordering for each
         */
    
    }
    /***
    Method to read from the file animals.txt
    reads the contents and adds them to the three instances of data structures 
    in the test class
    @param  filename the file to be read
    @param  al the ArrayList to add animals to 
    @param  s the Stack to add animals to
    @param  pq the PriorityQueue to add animals to
    @return none
    */
    public static void readAnimals(String filename, ArrayList<String> al, Stack<String> s, PriorityQueue<String> pq){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String animal = read.nextLine();
                al.add(animal);
                s.push(animal);
                pq.offer(animal);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}