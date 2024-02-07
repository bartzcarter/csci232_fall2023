/***
 * Class to Test classes Event, Appointment, and Meeting.
 * @author Carter Bartz
 * @version 0.2
 * Date of creation: January 29, 2023
 * Last Date Modified: February 8, 2023
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Test{
    /***
    Method that will use a scanner to read from the file "events.txt"
    Method will return the integer value of the non-null elements within 
    the events array.
    @param  list the array that will hold the information read from the file 
    @param  filename the name of the file that we are reading from
    @return counter the integer value for the number of events read from the file 
    */
    public static int readEvents(Event[] list, String filename){
        File file = new File(filename);
        int counter = 0;
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                if(readFile.nextLine().equals("meeting")){
                    list[counter] = new Meeting(readFile.nextLine(), readFile.nextLine(), readFile.nextLine()
                                                        ,readFile.nextLine(), readFile.nextLine(), readFile.nextInt());
                    readFile.nextLine();
                }
                else {
                    list[counter] = new Appointment(readFile.nextLine(), readFile.nextLine(), readFile.nextLine()
                                                        ,readFile.nextLine(), readFile.nextLine());
                }
                counter += 1;
            }
            readFile.close();
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot open file \"" + filename + "\"");
        }
        return counter;
    }

    /***
    Method to print the list of Events
    @param  list to print out the contents within the list array
    @return none
     */
    public static void printEvents(Event[] list, int index){
        for(int i = 0; i<index; i++){
            System.out.println(list[i].toString());
        }
    }
    /***
    Method to sort the list of Events by Date and then time
    @param  list to implement a sorting algorithim on 
    in order to sort the array by date and time .
    @return none
     */
    public static void sortEvents(Event[] list, int index){
        for(int i=1; i<index; i++){
            int j=i;
            Event currentVal = list[i];
            while(j>0 && currentVal.getDate().toString().compareTo(list[j-1].getDate().toString()) < 0){
                list[j] = list[j-1];
                j--;
            }
            list[j] = currentVal;
        }
        for(int i=1; i<index; i++){
            int j=i;
            Event currentVal = list[i];
            if((currentVal.getDate().toString().compareTo(list[j-1].getDate().toString()) == 0) &&
                (currentVal.getTime().getHours() < list[j-1].getTime().getHours())){
            list[j] = list[j-1];
            j--;
            list[j] = currentVal;
            }
        }
        printEvents(list, index);
        
    }
    /***
    Method to search the list of Events for a specific description
    @param  list to search the contents of the array(descriptions)
    @param  descr is the description the algorithm will search for
    @return index the index at which the description was found.
    Will return -1 if not found.
     */
    public static int findEvent(Event[] list, String descr, int index1){
        int index = -1;
        for(int i = 0; i<index1; i++){
            if(list[i].getDescription().equals(descr)){
                index = i;
            }
        }
        return index;
    }
    /***
    Method to search for a given date in the list of Events
    @param  list to search the locations within the list array
    @param  date to serve as the date to search for
    @return list1 an array to hold the events that were found with the given date 
     */
    public static Event[] findEvents(Event[] list, String date, int index){
        int counter = 0;
        int counter2 = 0;
        Event[] list1 = new Event[0];
        try{
            Date check = new Date(date);
            for(int i = 0; i<index; i++){
                if(list[i].getDate().toString().equals(check.toString())){
                    counter++;
                }
            }
            list1 = new Event[counter];
            for(int i = 0; i<index; i++){
                if(list[i].getDate().toString().equals(check.toString())){
                    list1[counter2] = list[i]; 
                    counter2++;
                    if(counter2 == counter){
                        break;
                    }
                }
            }
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
        return list1;
    }
    /***
    Method to validate an integer from the scanner between 1 and 5
    @param  scnr to pass the scanner to the method
    @return num the validated integer between 1 and 5
     */
    public static int getInt(Scanner scnr){  
        boolean good = true;
        int num = 0;
        do {
            good = scnr.hasNextInt();
            if (good == false) {
                System.out.println("Invalid input");
                scnr.nextLine();
            } else {
                num = scnr.nextInt();
                scnr.nextLine();
                if (num >= 1 && num <= 5) {
                    good = true;
                } else {
                    System.out.println("Invalid input");
                    good = false;
                }
            }
        } while (good == false);
        return num;
    }
    /***
    The main method that will test the methods held 
    within Event.java, Appointment.java, Meeting.java, Date.java, Time.java, and InvalidDateTimeException.java
     */
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in); 
        Event[] events = new Event[50];
        int nonNull = readEvents(events, "events.txt");
        int choice = 0;
        int index = -1;
        String description = " ";
        String date = " ";
        do{
            System.out.println("Select an operation: ");
            System.out.println("1: view all events");
            System.out.println("2: search event by description");
            System.out.println("3: search events by date");
            System.out.println("4: sort events by date and time");
            System.out.println("5: exit");

            choice = getInt(scnr);
            if(choice == 1){
                printEvents(events, nonNull);
            }
            else if(choice == 2){
                System.out.println("Enter a description: ");
                description = scnr.nextLine();
                index = findEvent(events, description, nonNull);
                if(index != -1){
                    System.out.println("Event found: " + events[index].toString());
                }
                else{
                    System.out.println("Event not found");
                }
            }   
            else if(choice == 3){
                System.out.println("Enter a Date: ");
                date = scnr.nextLine();
                Event[] search = findEvents(events, date, nonNull);
                if(search.length == 0){
                    System.out.println("no Events on this date");
                }
                else{
                    for(int i = 0; i<search.length; i++){
                        System.out.println(search[i].toString());
                    }
                }
            }
            else if(choice == 4){
                sortEvents(events, nonNull);
            }
            else{
                break;
            }
        }while(choice !=5);
    }
}