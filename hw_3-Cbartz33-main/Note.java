/***
 * Class to model the Entity Note
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 6, 2023
 * Last Date Modified: March 9, 2023
 */
import java.util.*;
public class Note implements Comparable<Note>{
    //data members
    private Date date;
    private String title;
    private String description;
    /***
    3-arg constructor that initializes date, title, and description
    @param  date to set the date of the note
    @param  title to set the title of the note
    @param  description to set the description of the note
    @return none
     */
    public Note(Date date, String title, String description){
        this.date = date;
        this.title = title;
        this.description = description;
    }
    /***
    Getter method for the data member date
    @param  none
    @return the date of the note
     */
    public Date getDate(){
        return date;
    }
    /***
    Getter method for the data member title
    @param  none
    @return the title of the note
     */
    public String getTitle(){
        return title;
    }
    /***
    Getter method for the data member description
    @param  none
    @return the description of the note
     */
    public String getDescr(){
        return description;
    }
    /***
    Setter method for the data member date
    @param  d to set the date of the note
    @return none
     */
    public void setDate(Date d){
        date = d;
    }
    /***
    Setter method for the data member title
    @param  t to set the title of the note
    @return none
     */
    public void setTitle(String t){
        title = t;
    }
    /***
    Setter method for the data member description
    @param  d to set the description of the note
    @return none
     */
    public void setDescr(String d){
        description = d;
    }
    /***
    Overridden toString() method to return formated stirng of data members
    @param  none
    @return formatted string of data members for the note
     */
    @Override
    public String toString(){
        return String.format("%-20s\t%-20s\t%-20s", date.toString(), title, description);
    }
    /***
    equals method to determine if two notes are equal to eachother
    @param  o the object that will be checked for type Note and compared 
    @return true if the Notes are equal
    @return false if the Notes are not equal, or o is not an instanceof Note
     */
    public boolean equals(Object o){
        if(o instanceof Note){
            Note n = (Note)o;
            return this.getTitle().equals(n.getTitle()) && this.getDate().equals(n.getDate()) && this.getDescr().equals(n.getDescr());
        }
        else{
            return false;
        }
    }
    /***
    compareTo method required by Comparable 
    @param  n the note that will be compared to this
    @return the value that determines if this comes before n
    */
    public int compareTo(Note n){
        return this.getDate().compareTo(n.getDate());
    }
}