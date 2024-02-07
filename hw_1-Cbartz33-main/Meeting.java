/***
 * Class to model the entity Meeting that extends Event.java
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 29, 2023
 * Last Date Modified: January 30, 2023
 */
public class Meeting extends Event {
    // data members
    private String host;
    private int guests;

    /***
     * Default no-arg constructor
     * no parameters
     * calls the super() constructor and initializes data member host to "null", and
     * guests to 0
     */
    public Meeting() {
        super();
        host = "null";
        guests = 0;
    }

    /***
     * 6-arg constructor
     * calls super(String,String,String,String) constructor
     * @param description to describe the event
     * @param location    for the location of the event
     * @param date        for the date of the event
     * @param time        for the time of the event
     * @param host        for the host of the meeting
     * @param guests      for the number of guests attending the meeting
     */
    public Meeting(String description, String location, String date, String time, String host, int guests) {
        super(description, location, date, time);
        this.host = host;
        this.guests = guests;
    }

    /***
     * Getter method for the host of the meeting
     * @param none
     * @return the host of the meeting
     */
    public String getHost() {
        return host;
    }

    /***
     * Getter method for the guests of the meeting
     * @param none
     * @return the number of guests attending the meeting
     */
    public int getGuests() {
        return guests;
    }

    /***
     * Setter method for the host of the meeting
     * @param h to set the data member host
     * @return none
     */
    public void setHost(String h) {
        host = h;
    }

    /***
     * Setter method for the guests attending the meeting
     * @param g to set the data member guests
     * @return none
     */
    public void setGuests(int g) {
        guests = g;
    }

    /***
     * Method to get the meeting information
     * 
     * @param none
     * @return formatted string containing the value of the data members and
     * super.toString()
     */
    @Override
    public String toString() {
        return String.format("%s\tHost: %s\tGuests: %d\t", super.toString(), host, guests);
    }
}