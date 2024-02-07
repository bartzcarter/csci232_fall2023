/**
 * Date class held within Data class for Program 2
 * @author Carter Bartz
 * @version 1.0
 */

public class Date implements Comparable<Date>{
    //The day of the month
    private int day;
    //The month of the year
    private int month;
    //The year
    private int year;
    
    /**
     * Constructor for Date class
     * @param day The day of the month
     * @param month The month of the year   
     * @param year The year
     */
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    /**
     * Returns the day of the month
     * @return The day of the month
     */
    public int getDay(){
        return day;
    }
    
    /**
     * Returns the month of the year
     * @return The month of the year
     */
    public int getMonth(){
        return month;
    }
    
    /**
     * Returns the year
     * @return The year
     */
    public int getYear(){
        return year;
    }
    
    /**
     * Returns a string representation of the date
     * @return A string representation of the date
     */
    public String toString(){
        switch (month){
            case 1:
                return "Jan " + day + ", " + year;
            case 2:
                return "Feb " + day + ", " + year;
            case 3:
                return "Mar " + day + ", " + year;
            case 4:
                return "Apr " + day + ", " + year;
            case 5:
                return "May " + day + ", " + year;
            case 6:
                return "June " + day + ", " + year;
            case 7:
                return "July " + day + ", " + year;
            case 8:
                return "Aug " + day + ", " + year;
            case 9:
                return "Sep " + day + ", " + year;
            case 10:
                return "Oct " + day + ", " + year;
            case 11:
                return "Nov " + day + ", " + year;
            case 12:
                return "Dec " + day + ", " + year;
            default:
                return "Invalid date";
        }
    }
    
    /**
     * Compares two dates
     * @param other The date to compare to
     * @return -1 if this date is before the other date, 1 if this date is after the other date, 0 if they are the same
     */
    public int compareTo(Date other){
        if (this.year < other.year){
            return -1;
        } else if (this.year > other.year){
            return 1;
        } else {
            if (this.month < other.month){
                return -1;
            } else if (this.month > other.month){
                return 1;
            } else {
                if (this.day < other.day){
                    return -1;
                } else if (this.day > other.day){
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}