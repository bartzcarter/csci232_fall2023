/***
 * Class to test Pair, ComparatorByFirst, and ComparatorBySecond
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 28, 2023
 * Last Date Modified: March 6, 2023
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Test{
    /***
    General Search method for any type of Pair that will 
    be given a key to search for in the pair
    @param  list the array list of pairs to search through
    @param  key of type E1 the first object in pair to search for
    @return -1 if not found
    @return i the index they key was found at in list
     */
    public static <E1,E2> int search(ArrayList<Pair<E1,E2>> list, E1 key){
        for(int i=0; i<list.size(); i++){
            Pair<E1, E2> pair = list.get(i);
            if(pair.getFirst().equals(key)){
                return i;
            }
        }
        return -1;
    }
    /***
    Main method that will require one or another 
    comand line arguments
    @param args that must be either "states" , or "trees" 
    @return none
    */
    public static void main(String[]args){
        //validate the arguments
        if(args.length == 0){
            System.out.println("Invalid argument. It should be states or trees");
            System.exit(0); //end the program
        }
        if(args.length > 1){
            System.out.println("Too many arguments. It should be states OR trees");
            System.exit(0); //end the program
        }
        String type = args[0];
        if(!type.equals("trees") && !type.equals("states")){
            System.out.println("Invalid data type. states and trees are the only types available.");
            System.exit(0);
        }
        //switch to code relative to arguments -- either states or trees
        switch(type){
            case "states": 
                ArrayList<Pair<String, String>> states = new ArrayList<>(50);
                readStates(states, "states.txt");
                stateOperations(states);
            break;
            case "trees": 
                ArrayList<Pair<String, Integer>> trees = new ArrayList<>(50);
                readTrees(trees, "trees.txt");
                TreeOperations(trees);
            break;
        }
    }
    /***
    Method to read a file passed by filename and store the 
    contents of the file in an ArrayList of type Pair
    @param  list with <String, String> to store file contents
    @param  filename the file of "states.txt" information 
    @return none
     */
    public static void readStates(ArrayList<Pair<String,String>> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                String capital = items[1];
                Pair<String,String> state = new Pair<>(name, capital);
                list.add(state);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    }
    /***
    Method to read a file passed by filename and store the 
    contents of the file in an ArrayList of type Pair
    @param  list with <String, String> to store file contents
    @param  filename the file of "trees.txt" information 
    @return none
     */
    public static void readTrees(ArrayList<Pair<String,Integer>> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                Integer height = Integer.parseInt(items[1]);
                Pair<String,Integer> tree = new Pair<>(name, height);
                list.add(tree);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    }
    /***
    Method that will carry out the state operations the user 
    wishes to perform on the ArrayList
    @param  list of type <String, String> the list of states
    @return none
     */
    public static void stateOperations(ArrayList<Pair<String,String>> list){
        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do{
            printMenu("states");
            operation = Integer.parseInt(keyboard.nextLine());
            switch(operation){
                case 1: //view
                    print(list);
                break;
                case 2: //search
                    System.out.println("Enter a state: ");
                    String name = keyboard.nextLine();
                    int index = search(list, name);
                    if(index == -1){
                        System.out.println("State not found");
                    }
                    else{
                        System.out.println("State found" + list.get(index));
                    }
                break;
                case 3: //sort by name
                    list.sort(new ComparatorByFirst());
                    print(list);
                break;
                case 4: //sort by capital
                    list.sort(new ComparatorBySecond());
                    print(list);
                break;
                case 5: //exit
                break;
                default:
                    System.out.println("Invalid operation 1-5 only");
            }
        }while(operation !=5);
    }
    /***
    Generic method that will print out the contents within 
    the ArrayList that is passed
    @param  list the ArrayList that will be printed out of any type
     */
    public static <E> void print(ArrayList<E> list){
        for(E element: list){
            System.out.println(element);
        }
    }
    /***
    Method to print out the menu options for either
    the states operations, or the trees operations
    @param  type either states of trees to know 
    which operations to print out for the user 
    @return none
     */
    public static void printMenu(String type){
        System.out.println("Select an operation: ");
        System.out.println("1: View the list of " + type);
        System.out.println("2: Search " + type + " by name");
        System.out.println("3: Sort " + type + " by name");
        if(type.equals("states")){
            System.out.println("4: Sort " + type + " by Capital");
        }
        else{
            System.out.println("4: Sort " + type + " by Height");
        }
        System.out.println("5: Exit");
       
    }
     /***
    Method that will carry out the tree operations the user 
    wishes to perform on the ArrayList
    @param  list of type <String, Integer> the list of trees
    @return none
     */
    public static void TreeOperations(ArrayList<Pair<String,Integer>> list){
        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do{
            printMenu("trees");
            operation = Integer.parseInt(keyboard.nextLine());
            switch(operation){
                case 1: //view
                    print(list);
                break;
                case 2: //search
                    System.out.println("Enter a tree: ");
                    String name = keyboard.nextLine();
                    int index = search(list, name);
                    if(index == -1){
                        System.out.println("Tree not found");
                    }
                    else{
                        System.out.println("Tree found" + list.get(index));
                    }
                break;
                case 3: //sort by name
                    list.sort(new ComparatorByFirst());
                    print(list);
                break;
                case 4: //sort by capital
                    list.sort(new ComparatorBySecond());
                    print(list);
                break;
                case 5: //exit
                break;
                default:
                    System.out.println("Invalid operation 1-5 only");
            }
        }while(operation !=5);
    }
}