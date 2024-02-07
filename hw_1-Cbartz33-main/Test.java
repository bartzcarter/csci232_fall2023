
/***
 * Class to Test classes Event, Appointment, and Meeting.
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 29, 2023
 * Last Date Modified: January 30, 2023
 */
import java.util.Scanner;

public class Test {
    /***
     * Method to print the list of Events
     * @param list to print out the contents within the list array
     * @return none
     */
    public static void printEvents(Event[] list) {
        for (Event E : list) {
            System.out.println(E);
        }
    }

    /***
     * Method to sort the list of Events by location
     * @param list to implement a sorting algorithim on in order to sort the array by location.
     * @return none
     */
    public static void sortEvents(Event[] list) {
        for (int i = 1; i < list.length; i++) {
            int j = i;
            Event currentVal = list[i];
            while (j > 0 && currentVal.getLocation().compareTo(list[j - 1].getLocation()) < 0) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = currentVal;
        }
    }

    /***
     * Method to search the list of Events for a specific description
     * @param list  to search the contents of the array(descriptions)
     * @param descr is the description the algorithm will search for
     * @return index the index at which the description was found.
     * Will return -1 if not found.
     */
    public static int findEvent(Event[] list, String descr) {
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getDescription().equals(descr)) {
                index = i;
            }
        }
        return index;
    }

    /***
     * Method to search for a given location in the list of Events
     * @param list to search the locations within the list array
     * @param location to serve as the location to search for
     * @return list1 an array to hold the events that were found with the given location
     */
    public static Event[] findEvents(Event[] list, String location) {
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getLocation().equals(location)) {
                counter++;
            }
        }
        Event[] list1 = new Event[counter];
        for (int i = 0; i < list.length; i++) {
            if (list[i].getLocation().equals(location)) {
                list1[counter2] = list[i];
                counter2++;
                if (counter2 == counter) {
                    break;
                }
            }
        }
        return list1;
    }

    /***
     * Method to validate an integer from the scanner between 1 and 5
     * @param scnr to pass the scanner to the method
     * @return num the validated integer between 1 and 5
     */
    public static int getInt(Scanner scnr) {
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
     * The main method that will test the methods held
     * within Event.java, Appointment.java, and Meeting.java
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Event[] events = new Event[10];
        events[0] = new Appointment("Dentist", "Lehigh Dentists", "01/26/2023", "10:30", "Beth Clark");
        events[1] = new Meeting("Science Club", "PA-220", "02/03/2023", "16:30", "Will Johns", 25);
        events[2] = new Meeting("Movie Club", "PA-220", "01/31/2023", "17:00", "Grace Williams", 10);
        events[3] = new Appointment("Instructor", "PA-254", "01/30/2023", "11:15", "Mark Jones");
        events[4] = new Meeting("Provost", "Memorial Building", "05/05/2023", "14:30", "Lissa Zuppe", 100);
        events[5] = new Meeting("Group Work", "Zoom", "02/07/2023", "18:45", "Jack Taylor", 5);
        events[6] = new Appointment("Doctor", "Lehigh Doctors", "04/22/2023", "13:45", "Kathy Bell");
        events[7] = new Meeting("Programming Club", "PA-220", "03/15/2023", "19:00", "Billy Steward", 20);
        events[8] = new Appointment("Advising", "PA-252", "03/11/2023", "12:15", "Sharon Kraft");
        events[9] = new Appointment("Bank Account", "Wells Fargo", "03/25/2023", "10:30", "Sarah Thompson");

        int choice = 0;
        int index = -1;
        String description = " ";
        String location = " ";
        do {
            System.out.println("Select an operation: ");
            System.out.println("1: view all events");
            System.out.println("2: search event by description");
            System.out.println("3: search events by location");
            System.out.println("4: sort events by location");
            System.out.println("5: exit");

            choice = getInt(scnr);
            if (choice == 1) {
                printEvents(events);
            } else if (choice == 2) {
                System.out.println("Enter a description: ");
                description = scnr.nextLine();
                index = findEvent(events, description);
                if (index != -1) {
                    System.out.println("Event found: " + events[index].toString());
                } else {
                    System.out.println("Event not found");
                }
            } else if (choice == 3) {
                System.out.println("Enter a location: ");
                location = scnr.nextLine();
                Event[] search = findEvents(events, location);
                if(search.length == 0){
                    System.out.println("Location not found");
                }
                for (int i = 0; i < search.length; i++) {
                    System.out.println(search[i].toString());
                }
            } else if (choice == 4) {
                sortEvents(events);
                printEvents(events);
            } else {
                break;
            }
        } while (choice != 5);
    }
}