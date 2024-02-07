/***
 * Driver method for Lab6 question 2
 * This program reads in a file of data and stores it in a RedBlackTree
 * @author Carter Bartz
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver{
    public static void main(String[]args){
        //create a new RedBlackTree
        RedBlackTree<String, Data> tree = new RedBlackTree<>();
        //read in the file
        readFile(tree, "lab6in.txt");
        //print out the tree in order
        for (String key : tree.keys()) {
            Data data = tree.get(key);
            System.out.println(data.toString() + tree.getColor(key));
        }
    }

    /***
     * This method reads in a file of data and stores it in a RedBlackTree
     * @param tree The RedBlackTree to store the data in
     * @param fileName The name of the file to read from
     * @throws FileNotFoundException If the file is not found
     */
    public static void readFile(RedBlackTree<String, Data> tree, String fileName){
        try{
            Scanner scan = new Scanner(new File(fileName));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                double value;
                String type = tokens[0];
                String name = tokens[1];
                if(type.equals("int")){
                    value = 0;
                }
                else if(type.equals("float")){
                    value = 0.0;
                }
                else{
                    break;
                }
                Data data = new Data(name, type, value);
                updateValue(tree, fileName, data);
                tree.put(name, data);
            }
            scan.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    /***
     * This method updates the value of a Data object
     * @param tree The RedBlackTree to store the data in
     * @param fileName The name of the file to read from
     * @param data The Data object to update
     * @throws FileNotFoundException If the file is not found
     */
    public static void updateValue(RedBlackTree<String, Data> tree, String fileName, Data data){
        try{
            Scanner scan = new Scanner(new File(fileName));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] tokens = line.split(" = ");
                String name = tokens[0].trim();
                if(name.equals(data.getName().replace(";", ""))){
                    double value = Double.parseDouble(tokens[1].replace(";", "").trim());
                    data.setValue(value);
                }
            }
            scan.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

}
        