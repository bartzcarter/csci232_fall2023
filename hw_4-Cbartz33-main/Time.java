/***
 * Class to model the entity Time
 * @author Carter Bartz
 * @version 0.2
 * Date of creation: February 6, 2023
 * Last Date Modified: March 29, 2023
 */
public class Time implements Comparable<Time>{
    //data members
    private int hours;
    private int minutes;
    /***
    Default no-arg constructor
    @param  none
    initializes both data members, hours and minutes, to 0
    */
    public Time(){
        hours = minutes = 0;
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
        String[] items = time.split(":");
        try{
            int h = Integer.parseInt(items[0]);
            int m = Integer.parseInt(items[1]);
            if(h < 0 || h > 23)
                throw new InvalidDateTimeException("Invalid hours. Hours should be from 0 to 23.");
            if(m < 0 || m > 59)
                throw new InvalidDateTimeException("Invalid minutes. Minutes should be from 0 to 59.");
            hours = h;
            minutes = m;
        }
        catch(NumberFormatException e){
            System.out.println("Error: hours or minutes are not numbers.");
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
        if(h < 0 || h > 23)
                throw new InvalidDateTimeException("Invalid hours. Hours should be from 0 to 23.");
        hours = h;
    }
    /***
    Setter method for the minutes in the time
    validates minutes are 0-59
    @param  m to set the minutes
    @return none
    */
    public void setMinutes(int m) throws InvalidDateTimeException{
        if(m < 0 || m > 59)
                throw new InvalidDateTimeException("Invalid minutes. Minutes should be from 0 to 59.");
        minutes = m;
    }
    /***
    toString method to return the string format of the time 
    format: hours:minutes
    @param  none
    @return string value of time 
    */
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
    public int compareTo(Time time){
        if(this.getHours() == time.getHours()){
            return this.getMinutes() - time.getMinutes();
        }
        return this.getHours() - time.getHours();
    }
    /***
    boolean method to check if two Times are equal 
    @param  obj the object that will be evaluated
    @return true if the Times are equal
    @return false if the Times are not equal
     */
    public boolean equals(Object obj){
        if(obj instanceof Time){
            Time time = (Time) obj;
            return this.hours == time.hours && 
                   this.minutes == time.minutes;
        }
        return false;
    }
    /***
    Method to return the difference in minutes between two Times
    @param  t the time to be evaluated
    @return tMin - thisMin 
    */
    public int diff(Time t){
        int tMin = t.getHours() * 60;
        tMin += t.getMinutes();
        int thisMin = this.getHours() * 60;
        thisMin += this.getMinutes();
        return tMin - thisMin;
    }
    /***
    void Method to tick the time by one minute each time the method is called
    set min to 0 if min == 60
    then increment hours.
    Set hours to 0 if == 24 
    @param  none
    @return none
     */
    public void tick(){
        ++minutes;
        if(minutes == 60){
            ++hours;
            if(hours == 24){
                hours = 0;
            }
            minutes = 0;
        }
    }
}