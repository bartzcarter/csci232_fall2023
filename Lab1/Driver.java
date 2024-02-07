import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main(String[]args){
        //LinkedList.java From CSCI 232
        LinkedList<Double> LLDouble = new LinkedList<Double>();

        //Reading in the data from the file with doubles
        readDouble("dnums.txt", LLDouble);

        //LinkedList.java From CSCI 232
        LinkedList<String> LLString = new LinkedList<String>();

        //Reading in the data from the file with strings
        readString("strings.txt", LLString);

        //Printing the list data type
        System.out.println("The data type for the data in this linked list is " + LLDouble.printListDataType() + "\n");

        //Printing and deleting the data in the linked list with doubles
        while(!LLDouble.isEmpty()){
            deleteAndPrint(LLDouble);
        }

        //Creating a new line
        System.out.println();

        //Printing the list data type
        System.out.println("The data type for the data in this linked list is " + LLString.printListDataType() + "\n");

        //Printing and deleting the data in the linked list with strings
        while(!LLString.isEmpty()){
            deleteAndPrintString(LLString);
        }
    }

    /*
     * This method reads in the data from the file and inserts it into the linked list
     */
    public static void readDouble(String filename, LinkedList<Double> list){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(filename));
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        while(sc.hasNextLine()){
            Double temp = sc.nextDouble();
            //System.out.println(temp);
            list.insert(temp);
        }
        sc.close();
    }

    /*
     * This method reads in the data from the file and inserts it into the linked list
     */
    public static void readString(String filename, LinkedList<String> list){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(filename));
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        while(sc.hasNext()){
            list.insert(sc.next());
        }
        sc.close();
    }
    /*
     * This method prints the data in the linked list with doubles
     */
    public static void printList(LinkedList<Double> list){
        list.goToHead();
        System.out.print("List is ");
        while(!list.atEndOfList()){
            System.out.print(list.getCurData() + " ");
            list.nextData();
        }
    }
    /*
     * This method prints the data in the linked list with strings
     */
     public static void printListString(LinkedList<String> list){
        list.goToHead();
        System.out.print("List is ");
        while(!list.atEndOfList()){
            System.out.print(list.getCurData() + " ");
            list.nextData();
        }
    }
    /*
     * This method calls the print method then deletes the data in the linked list with doubles
     */
    public static void deleteAndPrint(LinkedList<Double> list){
        printList(list);
        list.delete();
        System.out.println();
    }
    
    /*
     * This method calls the print method then deletes the data in the linked list with strings
     */
    
    public static void deleteAndPrintString(LinkedList<String> list){
        printListString(list);
        list.delete();
        System.out.println();
    }
}

     
