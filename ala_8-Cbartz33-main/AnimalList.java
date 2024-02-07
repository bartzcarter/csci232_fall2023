/***
 * Class to Test the data structures ArrayList and LinkedList
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 28, 2023
 * Last Date Modified: April 01, 2023
 */
import java.util.*;
import java.io.*;
public class AnimalList{
    /***
    Main method to test ArrayList and LinkedList
    using animals.txt
    @param  args String[]
    @return none
     */
    public static void main(String[]args){
        //data structures
        ArrayList<String> animalAL = new ArrayList<>();
        LinkedList<String> animalLL = new LinkedList<>();
    //read from the file animals.txt to be held in the ArrayList and LinkedList
        readAnimals(animalAL, animalLL, "animals.txt");
    //testing contains(Object)
        System.out.println("Testing contains(Object)");
        testContains(animalAL, animalLL);
    //testing add(int, E)
        System.out.println("\nTesting add(int, E)");
        testAdd(animalAL, animalLL);
    //testing remove(Object)
        System.out.println("\nTesting remove(Object)");
        testRemove(animalAL, animalLL);
    }
    /***
    Method to read and fill the ArrayList/LinkedList in the main method with 
    information from animals.txt
    @param  al the ArrayList<String> to read to 
    @param  ll the LinkedList<String> to read to 
    @param  filename the file to read from
    @return none
     */
    public static void readAnimals(ArrayList<String> al, LinkedList<String>ll, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String animal = read.nextLine();
                al.add(animal);
                ll.add(animal);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    /***
    void method to test the contains method for the ArrayList and LinkedList
    Count number of iterations for each data structure as well as compute the averages 
    @param  al the ArrayList to test
    @param  ll the LinkedList to test
    @return none
     */

    /** Discussion
    iterations are all the same because of the way that each the ArrayList and the LinkedList will 
    sort through all the data to determine if the structure contains an obhect. The ArrayList will search until 
    found and same with the LinkedList. The difference from the other methods we will test is that with the
    contains mehtod we are not removing or adding leaving no need to shift any of the other elements in the ArrayList
    or LinkedList. 
    */
    public static void testContains(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0, totalLL = 0;
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal name", "Iterations(AL)", "Iterations(LL)");
        for(int i=0; i<20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String animal = al.get(randomIndex);
            al.contains(animal);
            ll.contains(animal);
            System.out.printf("%-30s\t%-10d\t%-10d\n", animal, ArrayList.containsIter, LinkedList.containsIter);
            totalAL += ArrayList.containsIter;
            totalLL += LinkedList.containsIter;
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "Average", totalAL/20, totalLL/20);
    }
    /*** 
    void method to test the add method for the ArrayList and LinkedList
    Count number of iterations for each data structure as well as compute the averages 
    @param  al the ArrayList to test
    @param  ll the LinkedList to test
    @return none
     */

    /** Discsussion
    adding at the end of the list, the arrayList perfomes better. Linked is better at the begining because 
    the arraylist will have to shift all the remaining elements
     */
    public static void testAdd(ArrayList<String> al, LinkedList<String> ll){
         int totalAL = 0, totalLL = 0;
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal name", "Iterations(AL)", "Iterations(LL)");
        for(int i=0; i<20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String animal = al.get(randomIndex);
            randomIndex = (int)(Math.random() * al.size());
            al.add(randomIndex, animal);
            ll.add(randomIndex, animal);
            System.out.printf("%-30s\t%-10d\t%-10d\n", animal, ArrayList.addIter, LinkedList.addIter);
            totalAL += ArrayList.addIter;
            totalLL += LinkedList.addIter;
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "Average", totalAL/20, totalLL/20);
    }
    /***
    void method to test the remove method for the ArrayList and LinkedList
    Count number of iterations for each data structure as well as compute the averages 
    @param  al the ArrayList to test
    @param  ll the LinkedList to test
    @return none
     */

    /** Discussion
    the average in the arrayList is much larger than the linkedList
    it is taking the arraylist much longer to remove than than the linkedList
    The arrayList must shift all of the remaining elements after removing...(n-i) shifts
    there is no shifting required when removing from the linkeList
     */
     public static void testRemove(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0, totalLL = 0;
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal name", "Iterations(AL)", "Iterations(LL)");
        for(int i=0; i<20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String animal = al.get(randomIndex);
            al.remove(animal);
            ll.remove(animal);
            System.out.printf("%-30s\t%-10d\t%-10d\n", animal, ArrayList.removeIter, LinkedList.removeIter);
            totalAL += ArrayList.removeIter;
            totalLL += LinkedList.removeIter;
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "Average", totalAL/20, totalLL/20);
    }
}