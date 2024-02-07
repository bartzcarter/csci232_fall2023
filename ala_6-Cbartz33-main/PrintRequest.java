/***
 * Class to model the entity PrintRequest
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 7, 2023
 * Last Date Modified: March 7, 2023
 */
import java.util.*;
public class PrintRequest implements Comparable<PrintRequest>{
    //data members
    private int id;
    private String group;
    private long size;
    /***
    default no-arg constructor
    set id to 0, group to "batch", and size to 0
    @param  none
    @return none
     */
    public PrintRequest(){
        id = 0;
        group = "batch";
        size = 0;
    }
    /***
    3-arg constructor
    @param  id to set id
    @param  group to set groupt name
    @param  size to set size of request
    @return none
     */
    public PrintRequest(int id, String group, long size){
        this.id = id;
        this.group = group;
        this.size = size;
    }
    /***
    Getter method for id 
    @param  none
    @return id the id of the request
     */
    public int getId(){
        return id;
    }
    /***
    Getter method for the group 
    @param  none
    @return group the group name 
     */
    public String getGroup(){
        return group;
    }
    /***
    Getter method for the size of the request
    @param  none
    @return size of the request
     */
    public long getSize(){
        return size;
    }
    /***
    Setter method to set id
    @param id to set id
    @return none
     */
    public void setId(int id){
        this.id = id;
    }
    /***
    Setter method for group 
    @param  group to set group
    @return none
     */
    public void setGroup(String group){
        this.group = group;
    }
    /***
    Setter method for the size of request
    @param  size of the request
    @return none
     */
    public void setSize(long size){
        this.size = size;
    }
    @Override
    /***
    Overridden method to print in formated string the details of 
    the request in a specified way.
    @param  none
    @return formatted string of request informaton
     */
    public String toString(){
        String s = "";
        if(size > 1000000000){
                double d = size / 1000000000.00;
                 s = String.format("%.2f Gbytes", d);
            }
            else if(size > 1000000){
                double d = size / 1000000.00;
                 s = String.format("%.2f Mbytes", d);
            }
            else if(size > 1000){
                double d = size / 1000.00;
                 s = String.format("%.2f Kbytes", d);
            }
        double n = size/10000;
        double days = (n)/(24*3600);
        n = n % (24 * 3600);
        double hours = n/3600;
        n %= 3600;
        double minutes = n/60;
        n %= 60;
        double seconds = n;
        return String.format("%-10d\t%-10s\t%-10s\t%02.0f:%02.0f:%02.0f:%02.0f", id, group, s, days, hours, minutes, seconds);
    }
    /***
    getter method to get the priority of the request determined by group
    @param  none
    @return the index value that represents the priority of the request
     */
    private int getPriority(){
        String[] priorities = {"root", "admin", "user", "batch"};
        for(int i=0; i<priorities.length; i++){
            if(group.equals(priorities[i])){
                return i;
            }
        }
        return -1;
    }
    /***
    compareTo method that will compare two PrintRequests by their priority 
    @param  pr the PrintRequest to be compared
    @return the value signifying which pr has higher priority
    */
    public int compareTo(PrintRequest pr){
        int pr1 = this.getPriority();
        int pr2 = pr.getPriority();
        return pr1 - pr2;
    }
}