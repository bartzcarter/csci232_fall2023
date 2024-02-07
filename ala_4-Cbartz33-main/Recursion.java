/***
Class to model Recursion 
@author Carter Bartz
@version 0.1
Date of Creation: February 14, 2023
Last Date Modified: February 14, 2023
 */ 
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Recursion{
    //main method to test the recursive methods fineFile(), getSize(), and findWord().
    public static void main(String []args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Testing findFile()");
        System.out.println("Enter a path: ");
        String folder = keyboard.nextLine();

        System.out.println("Enter a filename");
        String filename = keyboard.nextLine();
        //test findFile()
        String found = findFile(folder, filename);
        if(found.equals("")){
            System.out.println("File not found");
        }
        else{
            System.out.println("File found at: " + found);
        }
        
        System.out.println("Testing getSize()");
        System.out.println("Enter a path: ");
        folder = keyboard.nextLine();
        long size = getSize(folder);
        if(size == 0){
            System.out.println("folder not found");
        }
        else{
            if(size > 1000000000){
                double s = size / 1000000000.00;
                System.out.printf("Size: %.2f Gbytes\n", s);
            }
            else if(size > 1000000){
                double s = size / 1000000.00;
                System.out.printf("Size: %.2f Mbytes\n", s);
            }
            else if(size > 1000){
                double s = size / 1000.00;
                System.out.printf("Size: %.2f Kbytes\n", s);
            }
        }
        System.out.println("Testing findWord()");
        System.out.println("Enter a path");
        folder = keyboard.nextLine();
        System.out.println("Enter a word: ");
        String word = keyboard.nextLine();
        findWord(folder, word);

        keyboard.close();
    }
    /***
    Recursive method that will create a File object, and search for a file 
    given a file name. 
    @param  folder the folder that the file should be searched for
    @param  filename the name of the file to search for
    @return String with the directory the file was found in, or if the file 
    was not found at all
     */
    public static String findFile(String folder, String filename){
        File file = new File(folder);
        if(!file.exists()){
            return "";
        }
        if(file.isFile()){
            return "";
        }
        if(file.isDirectory()){
            File[] files = file.listFiles(); //get content of the folder
            for(int i=0; i<files.length; i++){
                if(files[i].isFile()){
                    if(files[i].getName().equals(filename)){
                        return files[i].getAbsolutePath();
                    }
                }
                if(files[i].isDirectory()){
                    String found = findFile(files[i].getAbsolutePath(), filename);//recursive case
                    if(!found.equals("")){
                        return found;
                    }
                }
            }
        }
        return "";
    }
    /***
    Recursive method that accepts a folder, will return the size in bytes of the folder 
    @param  folder the folder that the method will be gathering size on 
    @return a long value indicating the size of the folder
     */
    public static long getSize(String folder){
        File file = new File(folder);
        long size = 0;
        if(!file.exists()){
            return 0;
        }
        if(file.isFile()){
            return file.length();//returns the size of file in bytes
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++){
                if(files[i].isFile()){
                    size += files[i].length();
                }
                if(files[i].isDirectory()){
                    size += getSize(files[i].getAbsolutePath()); //recursive case
                }
            }
        }
        return size;
    }
    /***
    Recursive method that is givin a folder, and a word to search that folder for
    @param  folder the folder to search the word in
    @param  word the word to search the folder for 
    @return void method that will print out the number of occurances of the word in the folder
     */
    public static void findWord(String folder, String word){
        File file = new File(folder);
        if(!file.exists()){
            System.out.println("Folder/File not found");
        }
        if(file.isFile()){
            int count = searchword(file.getAbsolutePath(), word); //look for word inside file
            if(count != 0){
                System.out.println(word + " appears " + count + " times in " + file.getAbsolutePath());
            }
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f: files){
                findWord(f.getAbsolutePath(), word); //recursive call
            }
        }
    }
    /***
    Helper method to findWord() that is recursively called
    @param  filename the name of the file to search 
    @param  word the word to search for in filename 
    @return an int value that represents the number of times the word was found in the file
     */
    public static int searchword(String filename, String word){
        File file = new File(filename);
        int count = 0;
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                int index = line.indexOf(word); //first occurance of word
                while(index != -1){
                    count++;
                    index = line.indexOf(word, index+1); //looking for next occurance
                }
            }
            read.close();
        }
        catch(FileNotFoundException e){
            return 0;
        }
        return count;
    }
}