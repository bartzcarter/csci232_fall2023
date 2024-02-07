/***
 * Class to model the entity Time
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 6, 2023
 * Last Date Modified: February 8, 2023
 */
public class Time implements Comparable<Event>{
    //data members
    private int hours;
    private int minutes;

    /***
    Default no-arg constructor
    @param  none
    initializes both data members, hours and minutes, to 0
    */
    public Time(){
        hours = 0;
        minutes = 0;
    }
    /***
    1-arg constructor 
    Throws InvalidDateTimeException
    @param  time the string that will be validated
    using regex to match the format hh:mm
    Validates that hours is 0-24
    minutes is 0-59
    */
    public Time(String time) throws InvalidDateTimeException{
        if(time.matches("\\d{2}:\\d{2}") == true){
            String [] str = time.split(":");
            hours = Integer.parseInt(str[0]);
            if(hours < 0 || hours > 24){
                throw new InvalidDateTimeException("Invalid hours, must be (0-24)");
            }
            minutes = Integer.parseInt(str[1]);
            if(minutes < 0 || minutes > 59){
                throw new InvalidDateTimeException("Invalid minutes, must be (0-59)");
            }
        }
        else{
            throw new InvalidDateTimeException("Invalid time");
        }
    }
    /***
     Getter method for the hours in the time 
     @param    none
     @return   hours the integer value for hours in time 
    */
    public int getHours(){
        return hours;
    }
    /***
    Getter method for the minutes in the time 
     @param    none
     @return   minutes the integer value for hours in time 
    */
    public int getMinutes(){
        return minutes;
    }
    /***
    Setter method for the hours in the time 
    validates hours are 0-24
    @param  h to set the hours 
    @return none 
    */
    public void setHours(int h) throws InvalidDateTimeException{
        if(hours < 0 || hours > 24){
                throw new InvalidDateTimeException("Invalid hours, must be (0-24)");
        }
        hours = h;
    }
    /***
    Setter method for the minutes in the time
    validates minutes are 0-59
    @param  m to set the minutes
    @return none
    */
    public void setMinutes(int m) throws InvalidDateTimeException{
        if(minutes < 0 || minutes > 59){
                throw new InvalidDateTimeException("Invalid minutes, must be (0-59)");
        }
        minutes = m;
    }
    /***
    toString method to return the string format of the time 
    format: hours:minutes
    @param  none
    @return string value of time 
    */
    @Override
    public String toString(){
        return String.format("%02d:%02d", hours, minutes);
    }
    /***
    Comparable mehtod of type event that will compare two 
    events first by hours, then by minutes
    @param  e the event being compared
    @return 0 if the times are exactly the same 
    @return -1 if the event is before this.event()
    @return 1 if the event is after this.event()
     */
    public int compareTo(Event e){
        if(this.getHours() == e.getTime().getHours()){
            if(this.getMinutes() == e.getTime().getMinutes()){
                return 0;
            }
            else if(this.getMinutes() > e.getTime().getMinutes()){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(this.getHours() > e.getTime().getHours()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
