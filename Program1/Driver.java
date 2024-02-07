/**
 * Driver class for the Covid-19 data project. This class reads the data from the csv file, stores it in a minPQ, and then writes the top three new cases from each country to an output file.
 * @version 1.0
 * @author Carter Bartz
 */
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        //instantiate MinPQ
        MinPQ<Data> minPQ = new MinPQ<>(new DataComparator());
        BST<Long, Data> bst = new BST<Long, Data>();
        readFile("owid-covid-data.csv", minPQ, bst);
        //write to output file
        writeFile("output.txt", bst);
    }

    /**
     * Method to read the data from the csv file and store it in a minPQ
     * @param file the name of the file to be read
     * @param minPQ the minPQ to store the data in
     * @return void
     */
    public static void readFile(String file, MinPQ<Data> minPQ, BST<Long, Data> bst) {
        //try-catch block to read the file
        try {
            //create a new file object
            File f = new File(file);
            //create a new scanner object
            Scanner sc = new Scanner(f);
            //while the file has another line
            sc.nextLine();
        String temp = null; // Initialize temp to null
        int count = 0; // Initialize count to 0

        while (sc.hasNextLine()) {
            // Create a new string array to store the data
            String[] data = sc.nextLine().split(",");
            // Check if count is 0, first time iterating through new country
            if(count == 0){
                ++count;
                temp = data[1];
            }
            
            // Check if data[1] is the same as the last read value in temp
            if (temp != null && data[1].equals(temp)) {
                Data d = new Data(data[0], data[1], data[2], Long.parseLong(data[3]), Long.parseLong(data[4]), Long.parseLong(data[5]));
                //only insert the first instance of the new cases
                if(minPQ.containsKey(d.getNewCases()) == false){
                    minPQ.insert(d);
                }
            }
            //else add top three new cases from minPQ to BST
            else{
                Data d;
                for(int i = 0; i < 3; i++){
                    if(!minPQ.isEmpty()){
                        d = minPQ.removeMin();
                        while(bst.put(d.getNewCases(), d) == false && !minPQ.isEmpty()){
                            d = minPQ.removeMin();
                        }
                    }
                    else{
                        break;
                    }
                }
                //finished processing the previous country, so clear the minPQ and reset the count to process the next country
                minPQ.clear();
                count = 0;
                //case where the last data read was the first set of information for the new country
                d = new Data(data[0], data[1], data[2], Long.parseLong(data[3]), Long.parseLong(data[4]), Long.parseLong(data[5]));
                //only insert the first instance of the new cases
                if(minPQ.containsKey(d.getNewCases()) == false){
                    minPQ.insert(d);
                }
            }   
    
            // Update the value of temp for the next iteration
            temp = data[1];
        }       
            //close the scanner
            sc.close();
        } catch (FileNotFoundException e) {
            //print the error message
            System.out.println("File not found.");
        }
    }

    public static void writeFile(String file, BST<Long, Data> bst) {
        //try-catch block to write to the file
        try {
            //create a new file object
            File f = new File(file);
            //create a new print writer object
            PrintWriter pw = new PrintWriter(f);
            //create a new array list
            ArrayList<Data> list = new ArrayList<>();
            //add the data from the bst to the array list
            bst.inOrder(list);
            //for each data object in the array list
            for (Data d : list) {
                //write the data to the file
                pw.println("New cases: " + d.getNewCases() + " at " + d.getCountry() + "/" + d.getContinent() + " on " + d.getDay() + " Total: " + d.getTotalCases() + " Pop: " + d.getPopulation());
            }
            //close the print writer
            pw.close();
        } catch (FileNotFoundException e) {
            //print the error message
            System.out.println("File not found.");
        }
    }    
}
