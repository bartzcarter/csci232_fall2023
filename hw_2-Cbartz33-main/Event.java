/***
 * Class to model the entity Event
 * @author Carter Bartz
 * @version 0.2
 * Date of creation: January 29, 2023
 * Last Date Modified: February 8, 2023
 */
public class Event{
    //data members
    private String description;
    private String location;
    private Date date;
    private Time time;
    /***
    Default no-arg constructor
    no parameters
    Initializes description and location to "null" while initializing
    new Date and Time objects
    */
    public Event(){
        description = "null";
        location = "null";
        date = new Date();
        time = new Time();
    }
    /***
    4-arg constructor 
    Throws InvalidDateTimeException
    @param  description to describe the event
    @param  location for the location of the event
    @param  date for the date of the event
    @param  time for the time of the event
     */
    public Event(String description, String location, String date, String time) throws InvalidDateTimeException{
        this.description = description;
        this.location = location;
        this.date = new Date(date);
        this.time = new Time(time);
    }
    /***
    Getter method for the description of the event
    @param  none
    @return the description of the event
     */
    public String getDescription(){
        return description;
    }
    /***
    Getter method for the location of the event
    @param  none
    @return the location of the event
     */
    public String getLocation(){
        return location;
    }
    /***
    Getter method for the date of the event
    @param  none
    @return a date object that contains information 
    regarding the date of the event. 
     */
    public Date getDate(){
        return date;
    }
    /***
    Getter method for the time of the event
    @param  none
    @return a time objects that contains information 
    regarding the time of the event.
     */
    public Time getTime(){
        return time;
    }
    /***
    Setter method for the description of the event
    @param  d to set the data member description
    @return none
     */
    public void setDescription(String d){
        description = d;
    }
    /***
    Setter method for the location of the event
    @param  l to set the date member location
    @return none
     */
    public void setLocation(String l){
        location = l;
    }
    /***
    Setter method for the date of the event
    @param  date to initialize the object member date
    @return none
     */
    public void setDate(String date) throws InvalidDateTimeException{
        this.date = new Date(date);
    }
    /***
    Setter method for the time of the event
    @param  t to initialize the object member time
    @return none
     */
    public void setTime(String t) throws InvalidDateTimeException{
        this.time = new Time(t);
    }
    /***
    Method to get the event information
    @param  none
    @return formatted string containing the value of the data members
     */
    @Override
    public String toString(){
        return String.format("Description: %s\t\tLocation: %s\t\tDate: %s\t\tTime: %s\t", description, location, date, time);
    }
}