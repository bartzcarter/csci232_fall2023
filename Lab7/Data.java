/**
 * Data class that stores the data from the csv file
 * @author Carter Bartz
 * @version 1.0
 */
public class Data{
    //private instance variables
    private String continent;
    private String country;
    private String day;
    private long totalCases;
    private long newCases;
    private long population;

    //constructor
    public Data(String continent, String country, String day, long totalCases, long newCases, long population){
        this.continent = continent;
        this.country = country;
        this.day = day;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.population = population;
    }

    //getters and setters
    public String getContinent(){
        return continent;
    }
    public String getCountry(){
        return country;
    }
    public String getDay(){
        return day;
    }
    public long getTotalCases(){
        return totalCases;
    }
    public long getNewCases(){
        return newCases;
    }
    public long getPopulation(){
        return population;
    }

    public void setContinent(String continent){
        this.continent = continent;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setDay(String day){
        this.day = day;
    }
    public void setTotalCases(long totalCases){
        this.totalCases = totalCases;
    }
    public void setNewCases(long newCases){
        this.newCases = newCases;
    }
    public void setPopulation(long population){
        this.population = population;
    }

    //toString method
    @Override
    public String toString(){
        String st = ("Continent: " + continent + " Country: " + country + " Day: " + day + " Total Cases: " + totalCases + " New Cases: " + newCases + " Population: " + population);
        return st;
    }
}