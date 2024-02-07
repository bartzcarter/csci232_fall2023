/***
 * Class to model the entity Date
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 6, 2023
 * Last Date Modified: February 8, 2023
 */
public class Date implements Comparable<Event>{
    //data members
    private int month;
    private int day;
    private int year;
    /***
    Default no-arg constructor
    no parameters
    Initializes month, day, and year to default 0
    */
    public Date(){
        month = 00;
        day = 00;
        year = 0000;
    }
    /***
    1-arg constructor 
    Throws InvalidDateTimeException
    @param  date the string that will be validated
    using regex to match the format mm/dd/yyyy
    Validates that month is 1-12
    day is 1-31
    year is 1970-2030
    */
    public Date(String date) throws InvalidDateTimeException{
        if(date.matches("\\d{2}/\\d{2}/\\d{4}") == true){
            String [] str = date.split("/");
            month = Integer.parseInt(str[0]);
            if(month > 12 || month < 1){
                throw new InvalidDateTimeException("Invalid month, must be (1-12)");
            }
            day = Integer.parseInt(str[1]);
            if(day > 31 || day < 1){
                throw new InvalidDateTimeException("Invalid day, must be (1-31)");
            }
            year = Integer.parseInt(str[2]);
            if(year > 2030 || year < 1970){
                throw new InvalidDateTimeException("Invalid year, must be (1970-2030)");
            }
        }
        else{
            throw new InvalidDateTimeException("Invalid Date format, must be (mm/dd/yyyy)");
        }
    }
    /***
    getter method for the month in the date
    @param  none
    @return month the integer value for month (1-12)
    */
    public int getMonth(){
        return month;
    }
    /***
    getter method for the day in the date
    @param  none
    @return day the integer value for the day (1-31)
    */
    public int getDay(){
        return day;
    }
    /***
    getter method for the year in the date
    @param  none
    @return year the integer value for the year (1970-2030)
    */
    public int getYear(){
        return year;
    }
    /***
    setter method for the month in the date
    @param  m integer m to set the month
    @return none
    */
    public void setMonth(int m) throws InvalidDateTimeException{
        if(m <1 || m >12){
            throw new InvalidDateTimeException("Invalid month");
        }
        month = m;
    }
    /***
     setter method for the day in the date
    @param  d integer d to set the day
    @return none
    */
    public void setDay(int d) throws InvalidDateTimeException{
        if(d <1 || d >31){
            throw new InvalidDateTimeException("Invalid day");
        }
        day = d;
    }
    /***
     setter method for the year in the date
    @param  y integer m to set the year
    @return none
    */
    public void setYear(int y) throws InvalidDateTimeException{
        if(y <1970 || y >2030){
            throw new InvalidDateTimeException("Invalid month");
        }
        year = y;
    }
    /***
    toString method that will return a string 
    formatted to represent the date 
    @return mm/dd/yyyy to represent the date
    */
    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d", month, day, year);
    }
    /***
    Comparable mehtod of type event that will compare two 
    events first by year, then by month, then dy day
    @param  e the event being compared
    @return 0 if the dates are exactly the same 
    @return -1 if the event is before this.event()
    @return 1 if the event is after this.event()
     */
    public int compareTo(Event e){
        if(this.getYear() == e.getDate().getYear()){
            if(this.getMonth() > e.getDate().getMonth()){
                return 1;
            }
            else if(this.getMonth() == e.getDate().getMonth()){
                if(this.getDay() == e.getDate().getDay()){
                    return 0;
                }
                else if(this.getDay() > e.getDate().getDay()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
        else if(this.getYear() > e.getDate().getYear()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
