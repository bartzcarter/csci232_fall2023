/**
 * Data class that stores the type, date, and value of a data point for Program 2
 * @author Carter Bartz
 * @version 1.0
 */

public class Data{
    //The type of data - temp, Co2, or sea level    
    private String type;
    //The date of the data point
    private Date date;
    //The value of the data point
    private double value;

    /**
     * Constructor for Data class
     * @param type The type of data - temp, Co2, or sea level
     * @param date The date of the data point
     * @param value The value of the data point
     */
    public Data(String type, Date date, double value){
        this.type = type;
        this.date = date;
        this.value = value;
    }

    /**
     * Returns the type of data
     * @return The type of data
     */
    public String getType(){
        return type;
    }

    /**
     * Returns the date of the data point
     * @return The date of the data point
     */
    public Date getDate(){
        return date;
    }

    /**
     * Returns the value of the data point
     * @return The value of the data point
     */
    public double getValue(){
        return value;
    }
}