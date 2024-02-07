/***
 * Class to Test the operations of Airport
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 26, 2023
 * Last Date Modified: March 29, 2023
 */
import java.util.*;
import java.io.*;
public class Airport{
    /***
    Main method to test the operations of an Airport 
    with a singular runway keeping track of arrivals/departures
    @param  args String[]
    @return none
     */
    public static void main(String[]args){
        //data members
        Queue<Flight> landingQueue = new LinkedList<Flight>();
        Queue<Flight> takeoffQueue = new LinkedList<Flight>();
        ArrayList<Flight> landingList = new ArrayList<Flight>();
        ArrayList<Flight> takeoffList = new ArrayList<Flight>();
        //reading landing.txt and takeoff.txt
        readFlights(landingList, "landing.txt");
        readFlights(takeoffList, "takeoff.txt");
        //Flight simulation 
        try{
            Time time = new Time("12:00"); //time of simulation
            int landingTime = 12;  //time it takes to land
            int takeoffTime = 7;  //time it takes to takeoff
            int runway = 0;  //runway full or not
            // to print results
            String landing = "";
            String takeoff = "";
            //found landing/takeoff at certain time or not
            int foundLanding = 0;
            int foundTakeoff = 0;
            //to find avg waiting time
            int avgWaitL = 0;
            int avgWaitT = 0;
            int avgCountL = 0;
            int avgCountT = 0;
            for(int i=0; i<480; i++){
                int count = 0;
                do{
                foundLanding = findLanding(landingList, time);
                foundTakeoff = findTakeoff(takeoffList, time);
                if(foundLanding != -1){
                    landingQueue.offer(landingList.get(foundLanding));
                    System.out.println("A landing request has been added to the landing queue at " + time.toString());
                    landingList.remove(foundLanding);
                }
                if(foundTakeoff != -1){
                    takeoffQueue.offer(takeoffList.get(foundTakeoff));
                    System.out.println("A takeoff request has been added to the takeoff queue at " + time.toString());
                    takeoffList.remove(foundTakeoff);
                }
                if(count !=0){  //make sure we arnt ticking time for duplicate arrival/departure times
                    break;
                }
                if(runway !=0){  //runway full or not
                    runway--;
                }
                else{
                    if(!landingQueue.isEmpty()){  //add to landing Queue
                        Flight flight = landingQueue.poll();
                        int waitingTime = flight.getArrival().diff(time);
                        avgWaitL += waitingTime;
                        avgCountL++;
                        landing += (flight.toString() + time + "\t\t" + waitingTime + "\n");
                        runway = landingTime;
                    }
                    else{
                        if(!takeoffQueue.isEmpty()){ //add to takeoff queue
                            Flight flight = takeoffQueue.poll();
                            int waitingTime = flight.getDeparture().diff(time);
                            avgWaitT += waitingTime;
                            avgCountT++;
                            takeoff += (flight.toString() + time + "\t\t" + waitingTime + "\n");
                            runway = takeoffTime;
                        }
                    }
                }
                count++;
                }while(foundLanding != -1 || foundTakeoff != -1); //check for duplicate arrival/departure times
                time.tick();
            }
            //Display landing report
            System.out.println("\n" + "Landing Report");
            System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n", "Flight", "Departure", "Arrival", "Arrived", "Waiting Time");
            System.out.println(landing);
            System.out.println("Average waiting time for landing requests: " + avgWaitL/avgCountL + " minutes");
            System.out.println("\n" + "Takeoff Report");
            System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n", "Flight", "Departure", "Arrival", "Departed", "Waiting Time");
            System.out.println(takeoff);
            System.out.println("Average waiting time for takeoff requests: " + avgWaitT/avgCountT + " minutes");
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
    }
    /***
    Method to read and fill the ArrayList's in the main method with 
    information from landing.txt and takeoff.txt
    @param  list the ArrayList<String> to read to 
    @param  filename the file to read from
    @return none
     */
    public static void readFlights(ArrayList<Flight> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            String flight = "";
            String arrival = "";
            String departure = "";
            while(read.hasNextLine()){
                flight = read.next();
                departure = read.next();
                Time d = new Time(departure);
                arrival = read.next();
                Time a = new Time(arrival);
                Flight f = new Flight(flight, d, a);
                list.add(f);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
    }
    /***
    method to find an arrival at a given time, then remove it if found
    @param  list ArrayList<String> to search through
    @param  time to search for
    @return the index of the found flight
    @return -1 if no flight found 
     */
    public static int findLanding(ArrayList<Flight> list, Time time){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getArrival().equals(time)){
                return i;
            }
        }
        return -1;
    }
    /***
    method to find a departure at a given time, then remove it if found
    @param  list ArrayList<String> to search through
    @param  time to search for
    @return the index of the found flight
    @return -1 if no flight found 
     */
    public static int findTakeoff(ArrayList<Flight> list, Time time){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getDeparture().equals(time)){
                return i;
            }
        }
        return -1;
    }
}