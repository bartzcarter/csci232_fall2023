/***
 * Class to model the Exception InvalidDateTimeException
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 6 2023
 * Last Date Modified: February 08, 2023
 */ 
public class InvalidDateTimeException extends Exception{
    public InvalidDateTimeException(){
        super("Invalid Date/Time");
    }
    public InvalidDateTimeException(String message){
        super(message);
    }
}