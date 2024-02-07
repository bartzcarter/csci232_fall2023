/***
 * Class to model the Entity Date
 * @author Carter Bartz
 * @version 0.3
 * Date of creation: February 8, 2023
 * Last Date Modified: March 9, 2023
 */
public class Date implements Comparable<Date>{
    //data members
    private int month;
    private int day;
    private int year;
    /***
    default no-arg constructor
    initializes month to 1, day to 1, and year to 1970
    @param  none
    @return none
     */
    public Date(){
        month = 1;
        day = 1;
        year = 1970;
    }
    /***
    1-arg constructor throws InvalidDateTimeException
    @param  date to validate the date input, and set the data members month, day, and year
    @return none
     */
    public Date(String date) throws InvalidDateTimeException {
        if(date.matches("\\d{2}/\\d{2}/\\d{4}")){
            String[] items = date.split("/");
            month = Integer.parseInt(items[0]);
            if(month < 1 || month > 12)
                throw new InvalidDateTimeException("Invalid month. Month should be from 1 to 12.");
            day = Integer.parseInt(items[1]);
            if(day < 1 || day > 31)
                throw new InvalidDateTimeException("Invalid day. Day should be from 1 to 31.");
            year = Integer.parseInt(items[2]);
            if(year < 1970 || year > 2030)
                throw new InvalidDateTimeException("Invalid year. Month should be from 1970 to 2030.");
        }
        else
          throw new InvalidDateTimeException("Invalid Date Format (mm/dd/yyyy)");
    }
    /***
    Getter method for the month of the Date
    @param  none
    @return the data member month
     */
    public int getMonth() { return month;}
    /***
    Getter method for the day of the Date
    @param  none
    @return the data member day
     */
    public int getDay() { return day;}
    /***
    Getter method for the year of the Date
    @param  none
    @return the data member year
     */
    public int getYear() { return year;}
    /***
    Setter method for the data member month of Date
    throws InvalidDateTimeException
    @param  m to set the month
    @return none
     */
    public void setMonth(int m) throws InvalidDateTimeException{
        if(m < 1 || m > 12)
            throw new InvalidDateTimeException("Invalid month. Month should be from 1 to 12.");
        month = m;
    }
    /***
    Setter method for the data member day of Date
    throws InvalidDateTimeException
    @param  d to set the day
    @return none
     */
    public void setDay(int d) throws InvalidDateTimeException{
        if(d < 1 || d > 31)
           throw new InvalidDateTimeException("Invalid day. Day should be from 1 to 31.");
        day = d;
    }
    /***
    Setter method for the data member year of Date
    throws InvalidDateTimeException
    @param  y to set the year
    @return none
     */
    public void setYear(int y) throws InvalidDateTimeException{
        if(y < 1970 || y > 2030)
                throw new InvalidDateTimeException("Invalid year. Year should be from 1970 to 2030.");
        year = y;
    }
    /***
    Overridden toString() method to return formatted string of data members
    @param  none
    @return formatted string of data members for the Date
     */
    public String toString(){
        return String.format("%02d/%02d/%04d", month, day, year);
    }
    /***
    CompareTo method required by Comparable that allows the sorting of dates
    @param  date the date that is being sorted agianst this
    @return the value that indicates if date is before or after this
     */
    public int compareTo(Date date){
        if(this.getYear() == date.getYear()){
            if(this.getMonth() == date.getMonth()){
                return this.getDay() - date.getDay();
            }
            return this.getMonth() - date.getMonth();
        }
        return this.getYear() - date.getYear();
    }
}