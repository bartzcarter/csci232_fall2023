/***
 * This class represents a line of data read from the file "lab6in.txt"
 * @author  Carter Bartz
 * Lab6
 */

public class Data {
    // The name, type, and value of the data
    private String name;
    private String type;
    private double value; // You can use a double to store both float and int values

    /***
     * Constructor for the Data class
     * @param name The name of the data
     * @param type The type of the data
     * @param value The value of the data
     * @return A new Data object
     */
    public Data(String name, String type, double value) {
        this.name = name.replace(";", "");
        this.type = type;
        this.value = value;
    }
    
    /***
     * Getters and setters for the Data class
     * @return The name, type, or value of the data
     * @param name The name of the data
     * @param type The type of the data
     * @param value The value of the data
     */
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    /***
     * toString method for the Data class
     * @return A string representation of the data
     */
   @Override
    public String toString() {
        String valueStr;
        if (type.equals("int")) {
            // If the type is "int", cast the value to int
            valueStr = Integer.toString((int) value);
        } else {
            // Otherwise, leave it as is
            valueStr = Double.toString(value);
        }

        return name + " " + type + " " + valueStr;
    }
}
