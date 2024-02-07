/**
 * @Author: Carter Bartz
 * @Date: 2023-09-12
 * This program reads a list of numbers from a file and finds the closest pair of numbers
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ClosestPair{
    public static void main(String[] args){
        // Read values from file and store in array
        double[] values = readValues("lab2in.txt");
        // Sort array Big O(nlogn)
        Arrays.sort(values);
        // Find closest pair Big O(n)
        double[] closestPair = findClosestPair(values);
        // Print results with 6 decimal places
        System.out.printf("The numbers %.6f and %.6f are the closest pair with a difference of %.6f%n", 
        closestPair[0], closestPair[1], closestPair[1] - closestPair[0]);

    }
    /**
     * Reads values from a file and stores them in an array
     * @param filename name of file to read from
     * @return array of values from file
     * Big O(n)
     */
    public static double[] readValues(String filename){
        double[] values = null;
        try{
            Scanner counter = new Scanner(new File(filename));
            int n = 0;
            //count number of values in file
            while(counter.hasNextDouble()){
                counter.nextDouble();
                n++;
            }   
            counter.close();
            //initialize array to size of number of values
            Scanner input = new Scanner(new File(filename));
            values = new double[n];
            //store values in array
            for(int i = 0; i < n; i++){
                 values[i] = input.nextDouble();
            }
            input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return values;
    }
    /**
     * Finds the closest pair of numbers in an array
     * @param values array of values to find closest pair
     * @return array of closest pair
     * Big O(n)
     */
    public static double[] findClosestPair(double[] values){
        //return array
        double[] closestPair = new double[2];
        //initialize min to max value of double
        double min = Double.MAX_VALUE;

        //loop through array and find closest pair and store in closestPair
        for(int i=0; i<values.length-1; i++){
            double diff = values[i+1] - values[i];
            if(diff < min){
                min = diff;
                closestPair[0] = values[i];
                closestPair[1] = values[i+1];
            }
        }
        return closestPair;
    }
}