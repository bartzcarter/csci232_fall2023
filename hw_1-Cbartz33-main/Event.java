/***
 * Class to model the entity Event
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 29, 2023
 * Last Date Modified: January 30, 2023
 */
public class Event {
    // data members
    private String description;
    private String location;
    private String date;
    private String time;

    /***
     * Default no-arg constructor
     * no parameters
     * Initializes description, location, date, and time to "null"
     */
    public Event() {
        description = "null";
        location = "null";
        date = "null";
        time = "null";
    }

    /***
     * 4-arg constructor
     * @param description to describe the event
     * @param location    for the location of the event
     * @param date        for the date of the event
     * @param time        for the time of the event
     */
    public Event(String description, String location, String date, String time) {
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    /***
     * Getter method for the description of the event
     * @param none
     * @return the description of the event
     */
    public String getDescription() {
        return description;
    }

    /***
     * Getter method for the location of the event
     * @param none
     * @return the location of the event
     */
    public String getLocation() {
        return location;
    }

    /***
     * Getter method for the date of the event
     * @param none
     * @return the date of the event
     */
    public String getDate() {
        return date;
    }

    /***
     * Getter method for the time of the event
     * @param noen
     * @return the time of the event
     */
    public String getTime() {
        return time;
    }

    /***
     * Setter method for the description of the event
     * @param d to set the data member description
     * @return none
     */
    public void setDescription(String d) {
        description = d;
    }

    /***
     * Setter method for the location of the event
     * @param l to set the date member location
     * @return none
     */
    public void setLocation(String l) {
        location = l;
    }

    /***
     * Setter method for the date of the event
     * @param date to set the data member date
     * @return none
     */
    public void setDate(String date) {
        this.date = date;
    }

    /***
     * Setter method for the time of the event
     * @param t to set the date member time
     * @return none
     */
    public void setTime(String t) {
        time = t;
    }

    /***
     * Method to get the event information
     * @param none
     * @return formatted string containing the value of the data members
     */
    @Override
    public String toString() {
        return String.format("Description: %s\tLocation: %s\tDate: %s\tTime: %s", description, location, date, time);
    }
}