/**
 * @author Carter Bartz
 * Test class for lab 3 problem 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;

public class Test{
    public static void main(String[]args){
        //Create a SymbolTable object
        SymbolTable<Integer, Integer> table = new SymbolTable<Integer, Integer>();
        //Read in the file
        readFile(table, "lab3in.txt");
        //Determine if the table has the key 5
        if(table.contains(5)){
            System.out.println("The table contains the key 5 and the value is " + table.get(5));
            table.delete(5);
        }
        else{
            System.out.println("The table does not contain the key 5");
        }
        //Print key-value pairs
        printKeyValuePairs(table);
        //Print minimum key-vluae pair
        System.out.println("The minimum key-value pair is " + table.min() + " " + table.get(table.min()));
        //Print maximum key-value pair
        System.out.println("The maximum key-value pair is " + table.max() + " " + table.get(table.max()));

    }

    /**
     * @param  table - the table to be read into
     * @param  filename - the name of the file to be read
     * @return  none
     * Reads the file and inserts the key-value pairs into the table
     */
    public static void readFile(SymbolTable<Integer, Integer> table, String filename){
        try{
            Scanner input = new Scanner(new File(filename));
            while(input.hasNextInt()){
                int key = input.nextInt();
                int value = input.nextInt();
                table.put(key, value);
            }
            input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    /**
     * @param  table - the table to be printed
     * @return  none
     * Prints the key-value pairs of the table
     */
    public static void printKeyValuePairs(SymbolTable<Integer, Integer> table){
        Iterator<Integer> iter = table.iterator();
        while(iter.hasNext()){
            int key = iter.next();
            System.out.println("Key: " + key + " Value: " + table.get(key));
        }
    }
}