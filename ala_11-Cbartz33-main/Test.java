/**
    Class to test the five sorting algorithms as static methods in Sort.java
    @author Carter Bartz
    Date of the creation: April 25, 2023
    last date modified: May 1, 2023
 */
import java.util.ArrayList;
public class Test{
    public static void main(String[] args){
        final int SIZE = 10000;
        //random list
        ArrayList<Integer> randomList = new ArrayList<>(SIZE);
        for(int i=0; i<SIZE; i++){
            randomList.add((int)(Math.random() * SIZE));
        }
        //sorted list
        ArrayList<Integer> sortedList = (ArrayList<Integer>)(randomList.clone());
        java.util.Collections.sort(sortedList);
        //reversed list
        ArrayList<Integer> reversedList = (ArrayList<Integer>)(sortedList.clone());
        java.util.Collections.reverse(reversedList);

        //Header
        System.out.println("Dataset size: " + SIZE + "\n");
        System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n", "Sorting Algorithm", "Random", "Sorted", "Reversed");

        //Selection Sort
        Sort.selectionSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Selection Sort", Sort.iterations[0]);
        Sort.selectionSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[0]);
        Sort.selectionSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[0]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Insertion sort
        Sort.insertionSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Insertion Sort", Sort.iterations[1]);
        Sort.insertionSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[1]);
        Sort.insertionSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[1]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Bubble sort
        Sort.bubbleSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Bubble Sort", Sort.iterations[2]);
        Sort.bubbleSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[2]);
        Sort.bubbleSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[2]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Merge sort
        Sort.iterations[3] = 0;
        Sort.mergeSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Merge Sort", Sort.iterations[3]);
        Sort.iterations[3] = 0;
        Sort.mergeSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[3]);
        Sort.iterations[3] = 0;
        Sort.mergeSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[3]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Quick sort
        Sort.quickSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Quick Sort", Sort.iterations[4]);
        Sort.quickSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[4]);
        Sort.quickSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[4]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Heap Sort
        Sort.heapSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Heap Sort", Sort.iterations[5]);
        Sort.heapSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[5]);
        Sort.heapSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[5]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Bucket Sort
        Sort.bucketSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Bucket Sort", Sort.iterations[6]);
        Sort.bucketSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[6]);
        Sort.bucketSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[6]);

        //shuffle reversed and random list
        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        //Radix Sort
        Sort.radixSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Radix Sort", Sort.iterations[7]);
        Sort.radixSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[7]);
        Sort.radixSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[7]);
    }
    /**
        Discussion of results for ALA_11 part 1: The results show us that the selection sort will take
        the same amount of iterations for any type of list that is asked to be sorted.
        The Insertion sort is the most efficient when the list is already sorted,
        the slowest when the list is reversed, and in the middle when it is random.
        So far, insertion sort is better with this size of dataset. The bubble sort is almost
        as efficient as insertion when the list is already sorted, but otherwise it takes just as
        long as selection which is quadratic. Merge sort is the same for all the lists and on average
        is much more efficient than the others. The quick sort is very efficient for the random list, 
        but not efficient for sorted. The reversed is right in the middle. 

        In conclussion to sort a list that is already sorted, the most efficient will be the 
        insertion sort. To sort a random list of this size, the most efficient will be quick sort. 
        When sorting a reversed list of this size, the most efficient list will be the merge sort.
    */
    
    /**
        Discussion of results for ALA_11 part 2: After adding more sorting algorithms such as Heap sort, 
        Bucket sort, and Radix sort, we have some new results. We can see here that when the list is already 
        sorted, the Insertion sort is still the most efficient. When the list is random, the most efficient is 
        going to be the bucket sort, but this must be a list of Integers. If the list is reversed the most efficient 
        is going to be the bucket sort as well, but agian must be of type Integer.
    */

}