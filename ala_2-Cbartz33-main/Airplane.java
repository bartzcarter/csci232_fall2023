/***
 * Class to model the entity Airplane
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 31, 2023
 * Last Date Modified: February 05, 2023
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Airplane{
    //data members
    private char[][] seatMap;
     /***
    Default no-arg constructor
    no parameters
    Initializes seatMap to a 9 * 8 character array of '.'
    */
    public Airplane(){
        seatMap = new char[9][8];
        for(int i=0; i<9; i++){
            for(int j=0; j<8; j++){
                seatMap[i][j] = '.';
            }
        }
    }
    /***
    1-arg constructor 
    @param  filename to send a string through the method readMap
     */
    public Airplane(String filename){
        seatMap = new char[9][8];
        readMap(filename);
    }
    /***
    void method that will read the string file name and initialize a File
    readMap(String) will read the file and throw FileNotFoundException if needed
    @param  filename to initialize new File file
    @return none
     */
    private void readMap(String filename){
        File file = new File(filename); 
        try{
            Scanner readFile = new Scanner(file);
            for(int i=0; i<9; i++){
                for(int j=0; j<8; j++){
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }  
            readFile.close(); 
        }
        catch(FileNotFoundException e){
            for(int i=0; i<9; i++){
                for(int j=0; j<8; j++){
                    seatMap[i][j] = '.';
                }
            }   
        }
    }
    /***
    boolean method that will check seat numbers for valid input
    if seatNumber is not in appropriate format, will throw an InvalidSeatException
    @param  seatNumber string whose format is validated
    @return true if no InvalidSeatException is thrown
     */
    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException{
        if(!seatNumber.matches("[1-9][A-H]")){
            throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]). Please try again.");
        }
        else{
            return true;
        }
    }
    /***
    boolean method that will reserve a seat on file seatmap.txt
    First will check seat number, if it is free, will replace '.' with 'X' indicating 
    the seat was succesfully taken and will return true. 
    If seat already has 'X' will return false.
    @param  seatNumber to first check and then reserve that seat number if open
    @return true if seat succesfully reserved, false if seat already taken
     */
    public boolean reserveSeat(String seatNumber) throws InvalidSeatException{
        checkSeatNumber(seatNumber);
        char rowc = seatNumber.charAt(0);
        char colc = seatNumber.charAt(1);
        int row = rowc - '1';
        int col = colc - 'A';
        if(seatMap[row][col] == 'X'){
            return false;
        }
        else{
            seatMap[row][col] = 'X';
            return true;        
        }
    }
    /***
    boolean method that will free a seat on file seatmap.txt
    First will check seat number, if it is taken, will replace 'X' with '.' indicating 
    the seat was succesfully freed and will return true. 
    If seat already has '.' will return false.
    @param  seatNumber to first check and then free that seat number if taken
    @return true if seat succesfully freed, false if seat already free
     */
    public boolean freeSeat(String seatNumber) throws InvalidSeatException{
        checkSeatNumber(seatNumber);
        char rowc = seatNumber.charAt(0);
        char colc = seatNumber.charAt(1);
        int row = rowc - '1';
        int col = colc - 'A';
        if(seatMap[row][col] == '.'){
            return false;
        }
        else{
            seatMap[row][col] = '.';
            return true;        
        }
    }
    /***
    void method that will save the string filename by  
    using PrintWriter to write to the file seatmap.txt
    @param  filename to write the string to seatmap.txt
    @return none
    Will catch FileNotFoundException if thrown
    */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i=0; i<9; i++){
                for(int j=0; j<8; j++){
                    writeFile.print(seatMap[i][j] + " ");
                }
                writeFile.println();
            }   
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("cannot write to file " + filename);
        }
    }
    /***
    Overriden toString() method to return the string containing
    the format of a simple airplane map.
    @param  none
    @return out containing airplane map string used in SeatReservation.java progaram
     */
    public String toString(){
        String out = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for(int i=0; i<9; i++){
            out += (i+1) + "\t";
            for(int j=0; j<8; j++){
                out += seatMap[i][j] + "\t";
            }
            out += "\n";
        }
        return out;
    }
}