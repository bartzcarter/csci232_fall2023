/***
 * Class to model the Exception InvalidDateTimeException
 * @author Carter Bartz
 * @version 0.4
 * Date of creation: February 8, 2023
 * Last Date Modified: March 29, 2023
 */
public class InvalidDateTimeException extends Exception{
    /***
    no-arg constructor
    Calls super of Exception with string
    @param  none
    @return none
     */
    public InvalidDateTimeException(){
        super("Invalid Date Format.");
    }
    /***
    1-arg constructor
    Calls super of Exception with message
    @param  message the Exception message to be printed to the user
    @return none
     */
    public InvalidDateTimeException(String message){
        super(message);
    }
}