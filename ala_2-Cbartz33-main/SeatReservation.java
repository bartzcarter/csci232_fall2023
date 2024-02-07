/***
 * Class to model the reservation of seats on a seatmap.txt file for an airplane
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 31, 2023
 * Last Date Modified: February 05, 2023
 */
import java.util.Scanner; 
public class SeatReservation{
    /***
    main method to interact with the user and reserve/free a seat
    on the seatmap.txt file
    @param  args an array of string
    @return none
    Incorporates the use of the Airplane.java class 
    that will edit, create, and save the seatmap.txt file.
    Also catches/handles and throws InvaldidSeatException as well as other Excpetions
    that are thrown.
     */
    public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        Airplane plane = new Airplane("seatmap.txt");
        int choice = 0;
        while(choice !=3){
        System.out.println(plane.toString());
        System.out.println("Please select an option:");
        System.out.println("1: Reserve a seat");
        System.out.println("2: Free a seat");
        System.out.println("3: Quit");

        try{
        choice = keyboard.nextInt();
        if(choice < 0 || choice > 3){
            throw new Exception();
        }
        }
        catch(Exception e){
            System.out.println("Must enter 1, 2, or 3");
            break;
        }
            if(choice == 1 || choice == 2){
                System.out.println("Enter a seat number: ");
                boolean good = true;
                while(good){
                    try{
                        String seat = keyboard.next();
                        if(choice == 1){
                            boolean reserve = plane.reserveSeat(seat);
                            if(reserve == true){
                                System.out.println("Seat " + seat + " was succesfully reserved.");
                                good = false;
                            }
                            else{
                                System.out.println("Seat already taken, please select another: ");
                            }

                        }
                        else if(choice == 2){
                            boolean free = plane.freeSeat(seat);
                            if(free == true){
                                System.out.println("Seat " + seat + " was succesfully freed.");
                                good = false;
                            }
                            else{
                                System.out.println("Seat already free, please select another: ");
                            }
                        }
                    }
                    catch(InvalidSeatException e){
                        System.out.println("Invalid seat number (row[1-9]column[A-H]). Please try again: ");
                    }
                }
            }
            else{
                    plane.saveMap("seatmap.txt");
                }
        }
    }
}