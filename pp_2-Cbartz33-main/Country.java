/***
 * Class to model the entity Country
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: April 10, 2023
 * Last Date Modified: April 12, 2023
 */
import java.util.*;
public class Country{
    //data members name, carbonEmission, and carbonCapita
    private String name;
    private ArrayList<Pair<Integer, Double>> carbonEmission;
    private ArrayList<Pair<Integer, Double>> carbonCapita;
    /**
        1-arg constructor to initialize and set data members
        @param  name the name of the country 
     */
    public Country(String name){
        this.name = name;
        carbonEmission = new ArrayList<Pair<Integer, Double>>();
        carbonCapita = new ArrayList<Pair<Integer, Double>>();
    }
    /**
        Getter method to return the name of the country 
        @return name of the country
     */
    public String getName(){
        return name;
    }
    /**
        Setter method to set the name of the country 
        @param n to set the name of the country
     */
    public void setName(String n){
        name = n;
    }
    /**
        Method to add a pair with the year and a carbon emission to the data member ArrayList carbonEmission
        @param  year the year of the data
        @param  tons the amount of emissions
     */
    public void addCarbonEmission(int year, double tons){
        Pair p = new Pair(year, tons);
        carbonEmission.add(p);
    }
    /**
        Method to add a pair with the year and a carbon emission (per capita) to the data member ArrayList carbonCapita
        @param  year the year of the data
        @param  tons the amount of emissions
     */
    public void addCarbonCapita(int year, double tons){
        Pair p = new Pair(year, tons);
        carbonCapita.add(p);
    }
    /**
        method to return a ListIterator<Pair<>> pointing at the index that hold the given year
        @param  year the year of the emission to point the returned iterator at
        @return carbonEmission.listIterator(count) pointing at the index with year
     */
    public ListIterator<Pair<Integer, Double>> getEmission(int year){
        Iterator<Pair<Integer, Double>> iter = carbonEmission.iterator();
        int count = 0;
        while(iter.hasNext()){
            if(iter.next().getFirst().equals(year)){
                return carbonEmission.listIterator(count);
            }
            count++;
        }
        return carbonEmission.listIterator();
    }
     /**
        method to return a ListIterator<Pair<>> pointing at the index that hold the given year
        @param  year the year of the emission to point the returned iterator at
        @return carbonCapita.listIterator(count) pointing at the index with year
     */
    public ListIterator<Pair<Integer, Double>> getCapita(int year){
        Iterator<Pair<Integer, Double>> iter = carbonCapita.iterator();
        int count = 0;
        while(iter.hasNext()){
            if(iter.next().getFirst().equals(year)){
                return carbonCapita.listIterator(count);
            }
            count++;
        }
        return carbonCapita.listIterator();
    }
    /**
        Overriden toString() method to return formatted string of the Country's information/data members
        @return formatted string of name, emissions, and emissions per capita
     */
    public String toString(){
        return String.format("%s\t%s\t%s\t", name, carbonEmission.toString(), carbonCapita.toString());
    }
    /**
        Overriden equals() method to determine if two countries are equal using the name
        @param  o the object to be compared to this
        @return true if equal, false otherwise
     */
    public boolean equals(Object o){
        if(o instanceof Country){
            Country c = (Country)o;
            return this.getName().equals(c.getName());
        }
        return false;
    }
}