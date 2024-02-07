/***
 * Class to model the Exception InvalidSeatException
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 31, 2023
 * Last Date Modified: February 05, 2023
 */
public class InvalidSeatException extends Exception{
    /***
    Default no-arg constructor
    No parameters
    Calls super(String) Exception with message "Invalid seat Number"
     */
    public InvalidSeatException(){
        super("Invalid seat Number");
    }
    /***
    1-arg constructor
    @param  message that is used to call super(String) Exception
    Calls super(String) Exception with String message 
     */
    public InvalidSeatException(String message){
        super(message);
    }
}