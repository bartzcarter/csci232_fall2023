/**
 * Driver Method to read in the data from the files and print out the results for Program 2
 * @author Carter Bartz
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.FileWriter;
import java.io.IOException;

public class Driver{
    public static void main(String[]args){
        //create 3 RBTs one for each data set
        RBT<Data> temp = new RBT<Data>();
        RBT<Data> Co2 = new RBT<Data>();
        RBT<Data> SeaLevel = new RBT<Data>();
        
        //read in the files and insert the data for the world into each RBT
        readTempFile(temp, "temperature_anomaly.csv");
        readCo2File(Co2, "co2.csv");
        readSeaLevelFile(SeaLevel, "sea_level.csv");

        //Decimal format for the output
        DecimalFormat df = new DecimalFormat("#.##");

        //results for the lowest temperature anomaly
        Data data = temp.findMin();
        Date date = data.getDate();
        String text = ("Lowest Temperature anomaly (F): " + df.format(data.getValue()*1.8) + " on " + date.toString() + "\n");
        writeFile(text, "output.txt");
        //check if co2 has records for the same date
        ArrayList<Data> list = Co2.inOrder();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getDate().compareTo(date) == 0){
                text = "On that same date, the average Co2 concentration was " + list.get(i).getValue() + "\n";
                writeFile(text, "output.txt");
            }
        }
        //check if seaLevel has records for the same date
        ArrayList<Data> list2 = SeaLevel.inOrder();
        for(int i = 0; i < list2.size(); i++){
            if(list2.get(i).getDate().compareTo(date) == 0){
                text = ("On that same date, the Sea Level Rise was " + list2.get(i).getValue() + "\n");
                writeFile(text, "output.txt");
            }
        }
        
        //print out a new line for the output file spacing
        text = "\n";
        //write the results to the output file
        writeFile(text, "output.txt");

        //results for the highest temperature anomaly
        Data data2 = temp.findMax();
        Date date2 = data2.getDate();
        text = ("Highest Temperature anomaly (F): " + df.format(data2.getValue()*1.8) + " on " + date2.toString() + "\n");
        writeFile(text, "output.txt");
        //check if co2 has records for the same date
        ArrayList<Data> list3 = Co2.inOrder();
        for(int i = 0; i < list3.size(); i++){
            if(list3.get(i).getDate().compareTo(date2) == 0){
                text = ("On that same date, the average Co2 concentration was " + list3.get(i).getValue() + "\n");
                writeFile(text, "output.txt");
            }
        }
        //check if seaLevel has records for the same date
        ArrayList<Data> list4 = SeaLevel.inOrder();
        for(int i = 0; i < list4.size(); i++){
            if(list4.get(i).getDate().compareTo(date2) == 0){
                text = ("On that same date, the Sea Level Rise was " + list4.get(i).getValue() + "\n");
            }
        }

        //print out a new line for the output file spacing
        text = "\n";   
        //write the results to the output file
        writeFile(text, "output.txt");

        //results for the lowest sea level rise
        Data data3 = SeaLevel.findMin();
        Date date3 = data3.getDate();
        text = ("Lowest Sea Level Rise: " + data3.getValue() + " on " + date3.toString() + "\n");
        writeFile(text, "output.txt");
        //check if temp has records for the same date
        ArrayList<Data> list5 = temp.inOrder();
        for(int i = 0; i < list5.size(); i++){
            if(list5.get(i).getDate().compareTo(date3) == 0){
                text = ("On that same date, the Temperature Anomaly (F) was " + df.format(list5.get(i).getValue()*1.8 ) + "\n");
                writeFile(text, "output.txt");
            }
        }
        //check if co2 has records for the same date
        ArrayList<Data> list6 = Co2.inOrder();
        for(int i = 0; i < list6.size(); i++){
            if(list6.get(i).getDate().compareTo(date3) == 0){
                text = ("On that same date, the Average Co2 concentration " + list6.get(i).getValue() + "\n");
                writeFile(text, "output.txt");
            }
        }

        //print out a new line for the output file spacing
        text = "\n";
        //write the results to the output file
        writeFile(text, "output.txt");   

        //results for the highest sea level rise
        Data data4 = SeaLevel.findMax();
        Date date4 = data4.getDate();
        text = ("Highest Sea Level Rise: " + data4.getValue() + " on " + date4.toString() + "\n");
        writeFile(text, "output.txt");
        //check if temp has records for the same date
        ArrayList<Data> list7 = temp.inOrder();
        for(int i = 0; i < list7.size(); i++){
            if(list7.get(i).getDate().compareTo(date4) == 0){
                text = ("On that same date, the Temperature Anomaly (F) was " + df.format(list7.get(i).getValue()*1.8) + "\n");
                writeFile(text, "output.txt");
            }
        }
        //check if co2 has records for the same date
        ArrayList<Data> list8 = Co2.inOrder();
        for(int i = 0; i < list8.size(); i++){
            if(list8.get(i).getDate().compareTo(date4) == 0){
                text = ("On that same date, the Average Co2 concentration was " + list8.get(i).getValue() + "\n");
                writeFile(text, "output.txt");
            }
        }

        //print out a new line for the output file spacing
        text = "\n";
        //write the results to the output file
        writeFile(text, "output.txt");

        //results for the lowest average co2
        Data data5 = Co2.findMin();
        Date date5 = data5.getDate();
        text = ("Lowest Average Co2 concentration: " + data5.getValue() + " on " + date5.toString() + "\n");
        writeFile(text, "output.txt");
        //check if temp has records for that date
        ArrayList<Data> list9 = temp.inOrder();
        for(int i = 0; i < list9.size(); i++){
            if(list9.get(i).getDate().compareTo(date5) == 0){
                text = ("On that same date, the Temperature Anomaly (F) was " + df.format(list9.get(i).getValue()*1.8) + "\n");
                writeFile(text, "output.txt");
            }
        }
        //check if seaLevel has records for that date
        ArrayList<Data> list10 = SeaLevel.inOrder();
        for(int i = 0; i < list10.size(); i++){
            if(list10.get(i).getDate().compareTo(date5) == 0){
                text = ("On that same date, the Sea Level Rise was " + list10.get(i).getValue() + "\n");
                writeFile(text, "output.txt");
            }
        }

        //print out a new line for the output file spacing
        text = "\n";
        //write the results to the output file
        writeFile(text, "output.txt");

        //results for the highest average co2
        Data data6 = Co2.findMax();
        Date date6 = data6.getDate();
        text = ("Highest Average Co2 concentration: " + data6.getValue() + " on " + date6.toString() + "\n");
        writeFile(text, "output.txt");
        //check if temp has records for that date
        ArrayList<Data> list11 = temp.inOrder();
        for(int i = 0; i < list11.size(); i++){
            if(list11.get(i).getDate().compareTo(date6) == 0){
                text = ("On that same date, the Temperature Anomaly (F) was " + df.format(list11.get(i).getValue()*1.8) + "\n");
                writeFile(text, "output.txt");
            }
        }
        //check if seaLevel has records for that date
        ArrayList<Data> list12 = SeaLevel.inOrder();
        for(int i = 0; i < list12.size(); i++){
            if(list12.get(i).getDate().compareTo(date6) == 0){
                text = ("On that same date, the Sea Level Rise was " + list12.get(i).getValue() + "\n");
                writeFile(text, "output.txt");
            }
        }
    }

    /**
     * Reads the temperature file and inserts the data into the RBT
     * @param temp the RBT to insert the data into
     * @param fileName the name of the file to read from
     * @return void
     */
    public static void readTempFile(RBT<Data> temp, String fileName) {
        try {
            Scanner scnr = new Scanner(new File(fileName));
            while (scnr.hasNextLine()) {
                // Split the line by commas, and check if the first field is "World"
                String[] line = scnr.nextLine().split(",");
                if (line.length >= 4 && line[0].equals("World")) {
                    String dateField = line[2].trim(); // Trim to remove leading/trailing spaces
                    // Check if the date field matches the format
                    if (dateField.matches("^(\\d{1,2}/\\d{2}/\\d{4})$")) {
                        String[] date = dateField.split("/");
                        Date d = new Date(Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(date[2]));
                        Data data = new Data("Temperature Anomaly", d, Double.parseDouble(line[3]));
                        temp.insert(data);
                    } 
                    //check if the date field matches the format
                    else if (dateField.matches("^(\\d{4}-\\d{2}-\\d{2})$")) {
                        String[] date = dateField.split("-");
                        Date d = new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                        Data data = new Data("Temperature Anomaly", d, Double.parseDouble(line[3]));
                        temp.insert(data);
                    } else {
                        System.out.println("Invalid date format in line: " + String.join(",", line));
                    }
                }
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }   

    /**
     * Reads the co2 file and inserts the data into the RBT
     * @param temp the RBT to insert the data into
     * @param fileName the name of the file to read from
     * @return void
     */
    public static void readCo2File(RBT<Data> temp , String fileName){
        try {
            Scanner scnr = new Scanner(new File(fileName));
            while (scnr.hasNextLine()) {
                // Split the line by commas, and check if the first field is "World"
                String[] line = scnr.nextLine().split(",");
                if (line.length >= 4 && line[0].equals("World")) {
                    String dateField = line[2].trim(); // Trim to remove leading/trailing spaces
                    // Check if the date field matches the format
                    if (dateField.matches("^(\\d{1,2}/\\d{2}/\\d{4})$")) {
                        String[] date = dateField.split("/");
                        Date d = new Date(Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(date[2]));
                        Data data = new Data("Average Co2 concentration", d, Double.parseDouble(line[3]));
                        temp.insert(data);
                    } 
                    // Check if the date field matches the format
                    else if (dateField.matches("^(\\d{4}-\\d{2}-\\d{2})$")) {
                        String[] date = dateField.split("-");
                        Date d = new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                        Data data = new Data("Average Co2 concentration", d, Double.parseDouble(line[3]));
                        temp.insert(data);
                    } else {
                        System.out.println("Invalid date format in line: " + String.join(",", line));
                    }
                }
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Reads the sea level file and inserts the data into the RBT
     * @param temp the RBT to insert the data into
     * @param fileName the name of the file to read from
     * @return void
     */
    public static void readSeaLevelFile(RBT<Data> temp , String fileName){
        try {
            Scanner scnr = new Scanner(new File(fileName));
            while (scnr.hasNextLine()) {
                // Split the line by commas, and check if the first field is "World"
                String[] line = scnr.nextLine().split(",");
                if (line.length >= 4 && line[0].equals("World")) {
                    String dateField = line[2].trim(); // Trim to remove leading/trailing spaces
                    // Check if the date field matches the format
                    if (dateField.matches("^(\\d{1,2}/\\d{2}/\\d{4})$")) {
                        String[] date = dateField.split("/");
                        Date d = new Date(Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(date[2]));
                        Data data = new Data("Sea Level Risey", d, Double.parseDouble(line[3]));
                        temp.insert(data);
                    } 
                    // Check if the date field matches the format
                    else if (dateField.matches("^(\\d{4}-\\d{2}-\\d{2})$")) {
                        String[] date = dateField.split("-");
                        Date d = new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                        Data data = new Data("Sea Level Rise", d, Double.parseDouble(line[3]));
                        temp.insert(data);
                    } else {
                        System.out.println("Invalid date format in line: " + String.join(",", line));
                    }
                }
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Writes the text to the file
     * @param text the text to write to the file
     * @param fileName the name of the file to write to
     * @return void
     */
    public static void writeFile(String text, String fileName){
        try {
            FileWriter writer = new FileWriter(fileName, true); // The "true" parameter enables append mode
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + fileName);
            e.printStackTrace();
        }
    }
}