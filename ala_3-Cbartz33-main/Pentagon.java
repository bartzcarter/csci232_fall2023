/***
 * Class to model the entity Rectangle
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 13, 2023
 * Last Date Modified: February 13, 2023
 */
public class Pentagon extends Shape{
    //data members
    private double side;
    /***
    Default no-arg constructor
    no parameters
    Initializes side to 1.0
    */
    public Pentagon(){
        super();
        side = 1.0;
    }
    /***
    2-arg constructor 
    @param  color to set the color of the triangle
    @param  s to set the side lengths of the pentagon
     */
    public Pentagon(String color, double s){
        super(color);
        side = s;
    }
    /***
    Getter method for the side length of the pentagon
    @param  none
    @return side the lenght of the sides
     */
    public double getSide(){
        return side;
    }
    /***
    Setter method for the side length of the pentagon
    @param  side to set the side length of pentagon
    @return none
     */
    public void setSide(double side){
        this.side = side;
    }
    /***
    Overridden method to return formatted string of Pentagon information
    @param  none
    @return formatted string of data members and pentagon info
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-30.2f\t%-10.2f\t%-10.2f","Pentagon", super.toString(), side, getArea(), getPerimeter());
    }
    /***
    Getter method required by abstract class 
    @param  none
    @return area of the pentagon
     */
    public double getArea(){
        double a = 1/4.0 * Math.sqrt(5 * (5+2*Math.sqrt(5)));
        a *= side * side;
        return a;
    }
    /***
    Getter method required by abstract class
    @param  none
    @return perimeter of the pentagon
     */
    public double getPerimeter(){
        return side * 5;
    }
    /***
    Scalable method that scales the pentagon
    @param  factor the amount to scale the pentagons sides by
    @return none
     */
    public void scale(double factor){
        side *= factor;
    }
    /***
    Cloneable method to make a deep copy of the pentagon
    @param  none
    @return deep copy of pentagon as a new Pentagon object
     */
    public Object clone(){
        return new Pentagon(getColor(), side);
    }
}
