/**
 * @author: Carter Bartz
 * @date: 09/26/2023
 * Driver to test the BST class - lab4 question 2
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main(String[]args){
        //Create a BST object
        BST<String, Integer> tree = new BST<String, Integer>();
        //read in the file lab4in.txt
        readFile("lab4in.txt", tree);
        //print out the inorder traversal of the tree
        System.out.println("Inorder traversal of the tree:");
        System.out.print("[");
        tree.inorder();
        System.out.print("]");
    }
    //method to read in a file and put the key,value pair into a BST
    public static void readFile(String file, BST<String, Integer> tree){
        try{
            int count = 1;
            Scanner sc = new Scanner(new File(file));
            while(sc.hasNext()){
                String key = sc.next();
                tree.put(key, count * 5);
                count++;
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}