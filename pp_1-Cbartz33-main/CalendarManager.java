/***
 * Class to model the entity CalendarManager
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 19, 2023
 * Last Date Modified: February 22, 2023
 */
import java.util.Scanner;
public class CalendarManager{
    /***
    Main method that allows the user 
    to interact with the program in order to create a 
    customizable callendar that they can save for future use
    @param  args array of strings
    @return none
     */
    public static void main(String [] args){
        Scanner keyboard = new Scanner(System.in);
        Calendar calendar = new Calendar("events.txt");
        int choice = 0;

        while(choice !=7){
            System.out.println("Select an operation: ");
            System.out.println("1: view all events");
            System.out.println("2: search event by description");
            System.out.println("3: search events by date");
            System.out.println("4: add a new event");
            System.out.println("5: remove an existing event");
            System.out.println("6: sort events by date and time");
            System.out.println("7: exit");
            choice = getInt(keyboard);
            if(choice == 1){
                calendar.viewEvents();
                System.out.println();
            }
            if(choice == 2){
                System.out.println("Enter a description: ");
                String description = keyboard.nextLine();
                Event event = calendar.findEvent(description);
                if(event != null){
                    System.out.println("Event found: " + event.toString() + "\n");
                }
                else{
                    System.out.println("Event not found");
                }
            }
            if(choice == 3){
                System.out.println("Enter a date: ");
                String date = keyboard.nextLine();
                Event[] events = calendar.findEvents(date);
                if(events.length > 0){
                    for(int i=0; i<events.length; i++){
                        System.out.println(events[i].toString());
                    }
                }
                else{
                    System.out.println("No events found" + "\n");
                }
            }
            if(choice == 4){
                System.out.println("Enter the type (appointment/meeting): ");
                String type = keyboard.nextLine();
                System.out.println("Enter the description: ");
                String description = keyboard.nextLine();
                System.out.println("Enter the location: ");
                String location = keyboard.nextLine();
                System.out.println("Enter the date (mm/dd/yyyy): ");
                String date = keyboard.nextLine();
                System.out.println("Enter the time (hh:mm): ");
                String time = keyboard.nextLine();
                if(type.equals("meeting")){
                    System.out.println("Enter the name of the host: ");
                    String host = keyboard.nextLine();
                    System.out.println("Enter the number of guests: ");
                    int guests = Integer.parseInt(keyboard.nextLine());
                    try{
                        Event add = new Meeting(description, location, date, time, host, guests);
                        boolean good = calendar.addEvent(add);
                        if(good){
                            System.out.println("Event added succesfully");
                        }
                        else{
                            System.out.println("Event not added");
                        }
                    }
                    catch(InvalidDateTimeException e){
                        System.out.println(e.getMessage());
                    }
                }
                else if(type.equals("appointment")){
                    System.out.println("Enter the contact information: ");
                    String contact = keyboard.nextLine();
                    try{
                        Event add = new Appointment(description, location, date, time, contact);
                        boolean good = calendar.addEvent(add);
                        if(good){
                            System.out.println("Event added succesfully");
                        }
                        else{
                            System.out.println("Event not added");
                        }
                    }
                    catch(InvalidDateTimeException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            if(choice == 5){
                System.out.println("Enter a description: ");
                String description = keyboard.nextLine();
                boolean good = calendar.removeEvent(description);
                if(good){
                    System.out.println("Event found and removed succesfully");
                }
                else{
                    System.out.println("Event not found");
                }
            }
            if(choice == 6){
                calendar.sortEvents();
                calendar.viewEvents();
            }
        }
        calendar.saveEvents("events.txt");
        System.out.println("Calendar saved");
        keyboard.close();
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
                if (num >= 1 && num <= 7) {
                    good = true;
                } else {
                    System.out.println("Invalid input");
                    good = false;
                }
            }
        } while (good == false);
        return num;
    }
}