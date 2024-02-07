/***
 * Driver class for lab6 problem 3
 * @author Carter Bartz
 * This program reads in a file of strings and stores them in a RedBlackTree, then prints them out in order
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_Driver{
    public static void main(String[]args){
        //create a new RedBlackTree
        RedBlackTree<String, Integer> tree = new RedBlackTree<>(); 
        //read in the file 
        readFile(tree, "problem3in.txt");
        //print out the tree in order
        for (String key : tree.keys()) {
            int value = tree.get(key);
            System.out.println(key + " " + value + tree.getColor(key));
        }      
    }

        /***
         * This method reads in a file of strings and stores them in a RedBlackTree
         * @param tree The RedBlackTree to store the data in
         * @param fileName The name of the file to read from
         * @throws FileNotFoundException If the file is not found
         */
        public static void readFile(RedBlackTree<String, Integer> tree, String fileName){
            try{
                Scanner sc = new Scanner(new File(fileName));
                int value = 0;
                while(sc.hasNext()){
                    String key = sc.next();
                    tree.put(key, value);
                    value++;
                }
                sc.close();
            }catch(FileNotFoundException e){
                System.out.println("File not found");
            }
        }
}