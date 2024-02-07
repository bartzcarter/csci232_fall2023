/***
 * Class to model the entity Flight
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 26, 2023
 * Last Date Modified: March 29, 2023
 */
public class Flight{
    //data members
    private String flight;
    private Time departure;
    private Time arrival;
    /***
    3-arg Constructor to initialize flight, departure, and arrival
    @param f to set data member flight
    @param d to set data member departure
    @param  a to set data member arrival
    @return none
     */
    public Flight(String f, Time d, Time a){
        flight = f;
        departure = d;
        arrival = a;
    }
    /***
    Getter method for the data member flight
    @param  none
    @return flight
     */
    public String getFlight(){
        return flight;
    }
    /***
    Getter method for the data member departure
    @param  none
    @return departure
     */
    public Time getDeparture(){
        return departure;
    }
    /***
    Getter method for the data member arrival
    @param  none
    @return arrival
     */
    public Time getArrival(){
        return arrival;
    }
    /***
    Setter method for the data member flight
    @param  f to set flight
    @return none
     */
    public void setFlight(String f){
        flight = f;
    }
    /***
    Setter method for the data member departure
    @param  d to set departure
    @return none
     */
    public void setDeparture(Time d){
        departure = d;
    }
    /***
    Setter method for the data member arrival
    @param  a to set arrival
    @return none
     */
    public void setArrival(Time a){
        arrival = a;
    }
    /***
    toString() method to return a formatted string of the Flight data memnbers
    @param  none
    @return formatted string of flight, departure, and arrival
     */
    public String toString(){
        return String.format("%-10s\t%-10s\t%-10s\t", flight, departure.toString(), arrival.toString());
    }
}