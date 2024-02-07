/**
 * HeapSort.java Program to sort the data from the csv file using Heap Sort based on Population
 * @author Carter Bartz
 * @version 1.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeapSort{
    public static void main(String[] args){
        //create a new array of Data objects
        Data[] a = new Data[240];
        //call the readFile method
        readFile("owid-covid-data.csv", a);
        //call the sort method using heapsort from the textbook Algorithms 4th Edition
        sort(a);
        //call the writeFile method to write to the output file
        writeFile("output2.txt", a);
    }
    /**
     * Method to read the file and store the data in an array of Data objects
     * @param file the file to read
     * @param a the array of Data objects to store the data in
     * @return void
     */
    public static void readFile(String file, Data[] a) {
        //try-catch block to read the file
        try {
            //create a new file object
            File f = new File(file);
            //create a new scanner object
            Scanner sc = new Scanner(f);
            //while the file has another line
            sc.nextLine();
            String temp = null; // Initialize temp to null
            int count = 0; // Initialize count to 0
            int size = 0;

        while (sc.hasNextLine()) {
            // Create a new string array to store the data
            String[] data = sc.nextLine().split(",");
            // Check if count is 0, first time iterating through new country
            if(count == 0){
                ++count;
                temp = data[1];
            }
            
            // Check if data[1] is not the same as the last read value in temp
            if (temp != null && !data[1].equals(temp)) {
                Data d = new Data(data[0], data[1], data[2], Long.parseLong(data[3]), Long.parseLong(data[4]), Long.parseLong(data[5]));
                a[size] = d;
                size++;
                
            }
            // Update the value of temp for the next iteration
            temp = data[1];
        }       
            //close the scanner
            sc.close();
        } catch (FileNotFoundException e) {
            //print the error message
            System.out.println("File not found.");
        }
    }
    /**
     * Method to write the data to the output file
     * @param file the file to write to
     * @param a the array of Data objects to write to the file
     * @return void
     */
    public static void writeFile(String file, Data[] a) {
        //try-catch block to write to the file
        try {
            //create a new file object
            File f = new File(file);
            //create a new print writer object
            PrintWriter pw = new PrintWriter(f);
            for(int i = 0; i < a.length; i++){
                Data d = a[i];
                pw.println("New cases: " + d.getNewCases() + " at " + d.getCountry() + "/" + d.getContinent() + " on " + d.getDay() + " Total: " + d.getTotalCases() + " Pop: " + d.getPopulation());
            }
            //close the print writer
            pw.close();
        } catch (FileNotFoundException e) {
            //print the error message
            System.out.println("File not found.");
        }
    }    
    /**
     * Method to sort the data using Heap Sort from the textbook Algorithms 4th Edition
     * @param a the array of Data objects to sort
     * @return void
     */
    public static void sort(Data[] a) {
        int n = a.length;
        // Convert one-based index to zero-based index
        for (int k = n / 2 - 1; k >= 0; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            // Convert one-based indices to zero-based indices
            exch(a, 0, n - 1);
            n--; // Reduce the size of the heap
            sink(a, 0, n);
        }
    }
    /**
     * Method to exchange two elements in an array
     * @param a the array of Data objects
     * @param i the first element to exchange
     * @param j the second element to exchange
     * @return void
     */
    public static void exch(Data[] a, int i, int j) {
        Data swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Method to sink an element in the array
     * @param a the array of Data objects
     * @param k the element to sink
     * @param n the size of the array
     * @return void
     */
    public static void sink(Data[] a, int k, int n){
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }
    /**
     * Method to check if one element is less than another
     * @param a the array of Data objects
     * @param i the first element to check
     * @param j the second element to check
     * @return boolean true if the first element is less than the second, false otherwise
     */
    public static boolean less(Data[] a, int i, int j) {
        return a[i].getPopulation() < a[j].getPopulation();
    }   
}