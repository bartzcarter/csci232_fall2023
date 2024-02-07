/***
 * Class to model the entity Appointment that extends Event.java
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 29, 2023
 * Last Date Modified: January 30, 2023
 */
public class Appointment extends Event {
    // data members
    private String contact;

    /***
     * Default no-arg constructor
     * no parameters
     * calls the super() constructor and initializes data member contact to "null"
     */
    public Appointment() {
        super();
        contact = "null";
    }

    /***
     * 5-arg constructor
     * calls super(String,String,String,String) constructor
     * @param description to describe the event
     * @param location    for the location of the event
     * @param date        for the date of the event
     * @param time        for the time of the event
     * @param contact     for the contact information regarding the Appointment
     */
    public Appointment(String description, String location, String date, String time, String contact) {
        super(description, location, date, time);
        this.contact = contact;
    }

    /***
     * Getter method for the contact of the appointment
     * @param none
     * @return the Contact of the appointment
     */
    public String getContact() {
        return contact;
    }

    /***
     * Setter method for the contact of the appointment
     * @param c to set the data member contact
     * @return none
     */
    public void setContact(String c) {
        contact = c;
    }

    /***
     * Method to get the appointment information
     * @param none
     * @return formatted string containing the value of the data members and
     * super.toString()
     */
    @Override
    public String toString() {
        return String.format("%s\tContact: %s\t", super.toString(), contact);
    }
}