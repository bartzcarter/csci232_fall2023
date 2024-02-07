/***
 * Class to model the entity Calendar
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 19, 2023
 * Last Date Modified: February 22, 2023
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Calendar{
    //data members
    private Event[] events;  
    private static int count = 0;
    /***
    no-arg constructor
    initializes events to new Event[50]
    @param none
    @return none 
     */
    public Calendar(){
        events = new Event[50];
    }
    /***
    1-arg constructor
    initializes events to new Event[50]
    calls the method readEvents to fill events from the file filename
    @param  filename the name of the file to pass to readEvents(String)
    @return none
     */
    public Calendar(String filename){
        events = new Event[50];
        readEvents(filename);
    }
    /***
    method that will take the name of a file and read information 
    to fill the array events with events of type meeting or appointment
    @param  filename name of file that will be read
    @return none
     */
    private void readEvents(String filename){
        File file = new File(filename);
        String type;
        String description; 
        String location;
        String date;
        String time;
        String host;
        String guests;
        int g = 0;
        int counter = 0;
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                type = readFile.nextLine();
                description = readFile.nextLine();
                location = readFile.nextLine();
                date = readFile.nextLine();
                time = readFile.nextLine();
                host = readFile.nextLine();
                if(type.equals("meeting")){
                    guests = readFile.nextLine();
                    g = Integer.parseInt(guests);
                }
                if(type.equals("appointment")){
                    events[counter] = new Appointment(description, location, date, time, host);
                    counter++;
                    count++;
                }
                else if(type.equals("meeting")){
                    events[counter] = new Meeting(description, location, date, time, host, g);
                    counter++;
                    count++;
                }
            }
            readFile.close();
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot open file \"" + filename + "\"");
        }
    }
    /***
    Method that takes the name of a file and will save the information within the 
    events array to
    @param  filename the name of the file that the info will be saved to 
    @return none
     */
    public void saveEvents(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i=0; i<count; i++){
                if(events[i] instanceof Meeting){
                    writeFile.println("meeting");
                    writeFile.println(events[i].getDescription());
                    writeFile.println(events[i].getLocation());
                    writeFile.println(events[i].getDate().toString());
                    writeFile.println(events[i].getTime().toString());
                    writeFile.println(((Meeting)events[i]).getHost());
                    writeFile.println(((Meeting)events[i]).getGuests());
                }
                else{
                    writeFile.println("appointment");
                    writeFile.println(events[i].getDescription());
                    writeFile.println(events[i].getLocation());
                    writeFile.println(events[i].getDate().toString());
                    writeFile.println(events[i].getTime().toString());
                    writeFile.println(((Appointment)events[i]).getContact());
                }
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Unable to write to file");
        }
    }
    /***
    Method that will take a string and will loop through the 
    array events looking for any descriptions that match the passed string 
    @param  description the string to search for
    @return null if no event matched the description
    @return events[i] the event that matched the description
     */
    public Event findEvent(String description){
        for(int i=0; i<count; i++){
            if(events[i].getDescription().equals(description)){
                return events[i];
            }
        }
        return null;
    }
    /***
    Method that searches for events that have the same date as the one passed 
    to the method.
    @param  date the date to search for
    @return list an Event[] that holds all the events that matched the given date
     */
    public Event[] findEvents(String date){
        Event[] list = new Event[0];
        try{
            Date d = new Date(date);
            int counter = 0;
            for(int i=0; i<count; i++){
                if(events[i].getDate().toString().equals(d.toString())){
                    counter++;
                }
            }
            list = new Event[counter];
            int counter1 = 0;
            if(list.length == 0){
                return list;
            }
            for(int j=0; j<count; j++){
                if(events[j].getDate().toString().equals(d.toString())){
                    list[counter1] = events[j];
                    counter1++;
                }
            }
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    /***
    Method that will add an event to the array events
    @param  e the event being added to the array
    @return true if the addition was succesfull
    @return false if the addition was not succesfull 
    */
    public boolean addEvent(Event e){
        if(count < 50){
            events[count] = e;
            count++;
            return true;
        }
        else{
            return false;
        }
    }
    /***
    Method that will remove an event from the array events
    @param  description the description of the event the user wants removed 
    @return true if the removal was a success
    @return false if the removal was not succesful or the event was not found
     */
    public boolean removeEvent(String description){
        int index = -1;
        for(int i=0; i<count; i++){
            if(events[i].getDescription().equals(description)){
                index = i;
                count--;
            }
        }
        if(index == -1){
            return false;
        }
        for(int k=index; k<count; k++){
            events[k] = events[k+1];
        }
        return true;
    }
    /***
    Method that will neatly print the contents 
    of the array events in a formatted way to the user
    @param  none
    @return none
     */
    public void viewEvents(){
        for(int i=0; i<count; i++){
            System.out.println(events[i].toString());
        }
    }
    /***
    Method that will sort the events array dy date and time 
    @param  none
    @return none
     */
    public void sortEvents(){
        java.util.Arrays.sort(events, 0, count);
    }
}
