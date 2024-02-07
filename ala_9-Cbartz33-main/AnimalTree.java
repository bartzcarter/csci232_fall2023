/**
    @author: Carter Bartz/Lehigh Professors
    @version: 0.1
    Date of Creation: April 11, 2023
    Test class to test the implementation of BST and Heap
*/
import java.util.*;
import java.io.*;
public class AnimalTree{
    //Main Method
    /**
        Discussioin of contains(), add(), and remove(): 
        Here we can see that the Big-O of contains in the heap is O(n),
        and the contains for BST is also O(n). Although the average iterations for
        the heap is more than the bst. I think this is due to the BST being a Binary Search Tree
        it was designed for searching which is what contains() does. 

        The add() for Heap is O(logn) and for BST it is O(n). 
        As we can see in the results the add method for the heap
        is going to be more efficient when we are adding the animals randomly at 
        the very beginging of the program. The first outputs iterations average shows this 
        where the heap is less than the bst.

        The remove() for the Heap is O(logn) and for BST it is O(logn) to O(n). 
        In the results we can see that the heap is very consistent in the iterations
        being either 8 or 9, while the BST has some very low, but most are in the range
        of being greater than 10. The heap is more efficient becuase we are typically doing 
        the same amount of iterations every time due to the Heaps ordering. 
     */
    public static void main(String[]args){
        BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        ArrayList<String> animalAL = new ArrayList<>();
        System.out.println("\n" + "Testing Add");
        readAnimals(animalAL, animalBST, animalHeap, "animals.txt");
        System.out.println("\n" + "Testing Contains");
        testContains(animalAL, animalBST, animalHeap);
        System.out.println("\n" + "Testing Remove");
        testRemove(animalAL, animalBST, animalHeap);

        //Test 1
        System.out.println("\n" + "Height(BST) = " + animalBST.height());
        System.out.println("Height(Heap) = " + animalHeap.height());
        System.out.println("isBalanced(BST) = " + animalBST.isBalanced());
        System.out.println("isBalanced(Heap) = " + animalHeap.isBalanced());

        //Test 2 sorted
        java.util.Collections.sort(animalAL);
        animalBST.clear();
        animalHeap.clear();
        //adding sorted list of animals
        for(String animal: animalAL){
            animalBST.add(animal);
            animalHeap.add(animal);
        }
        System.out.print("\n" + "Results when inserted sorted");
        System.out.println("\n" + "Height(BST) = " + animalBST.height());
        System.out.println("Height(Heap) = " + animalHeap.height());
        System.out.println("isBalanced(BST) = " + animalBST.isBalanced());
        System.out.println("isBalanced(Heap) = " + animalHeap.isBalanced());
        /**
            Discussion: Here we can see that when the program is run we find 
            that the heap is balanced because the heap is always balanced in order
            to be a heap. The BST on the other hand, in this case, is not balanced. 
            In addtion, becuase of this balance, the heap has a lower height than the 
            unblanaced BST. When we inset sorted data into the BST, the height is as large 
            as the numner of animals we read in becuase of the ordering. It will keep 
            adding to the right most node, while the heap actually remaisn the same. We never insert into
            the BST sorted information. 
         */
    }
    /**
        Method to read from the file animals.txt and store them in the data structures
        @param  al add to ArrayList
        @param  bst add to BST
        @param  heap add to Heap
        @param  filename the file to read from

     */
    public static void readAnimals(ArrayList<String> al, BST<String> bst, Heap<String> heap, String filename){
        File file = new File(filename);
        int index = 0;
        int totalBST = 0;
        int totalHeap = 0;
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal", "Iterations(BST)", "Iterations(Heap)");
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String animal = read.nextLine();
                al.add(animal);
                bst.add(animal);
                heap.add(animal);
                totalBST += BST.iterations;
                totalHeap += Heap.iterations;
                if(index % 24 == 0){
                    System.out.printf("%-30s\t%-15d\t%-15d\n", animal, BST.iterations, Heap.iterations);
                }
                index++;
            }
            read.close();
            System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalBST/al.size(), totalHeap/al.size());
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    /**
        Method to test the contains() method in each of the data structres al, bst, and heap
        displays the iterations to complete each call
        @param  al test ArrayList
        @param  bst test BST
        @param  heap test Heap
     */
    public static void testContains(ArrayList<String> al, BST<String> bst, Heap<String> heap){
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal", "Iterations(BST)", "Iterations(Heap)");
        int totalBST = 0;
        int totalHeap = 0;
        for(int i=0; i<20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            bst.contains(randomAnimal);
            heap.contains(randomAnimal);
            totalBST += BST.iterations;
            totalHeap += Heap.iterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomAnimal, BST.iterations, Heap.iterations);
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalBST/20, totalHeap/20);
    }
    /**
        Method to test the remove() method in each of the data structres al, bst, and heap
        displays the iterations to complete each call
        @param  al test ArrayList
        @param  bst test BST
        @param  heap test Heap
     */
    public static void testRemove(ArrayList<String> al, BST<String> bst, Heap<String> heap){
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal", "Iterations(BST)", "Iterations(Heap)");
        int totalBST = 0;
        int totalHeap = 0;
        for(int i=0; i<20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            bst.remove(randomAnimal);
            heap.remove();
            totalBST += BST.iterations;
            totalHeap += Heap.iterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomAnimal, BST.iterations, Heap.iterations);
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalBST/20, totalHeap/20);
    }
}