/***
 * Class to model the entity Circle
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 13, 2023
 * Last Date Modified: February 13, 2023
 */
public class Circle extends Shape{
    //data members
    private double radius;
    /***
    Default no-arg constructor 
    no parameters
    calls super(), and sets radius to 1.0
     */
    public Circle(){
        super();
        radius = 1.0;
    }
    /***
    2-arg constructor 
    @param  color to set the color of the circle
    @param  radius to set the radius of the circle
     */
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    /***
    Getter method to get radius of circle
    @param  none
    @return radius of the circle
     */
    public double getRadius(){
        return radius;
    }
    /***
    Setter method for the radius of the circle 
    @param  radius to set the radius of the circle
    @return none
     */
    public void setRadius(double radius){
        this.radius = radius;
    }
    /***
    Overridden method to print string format of shpae information
    @param  none
    @return formatted string containing circle information
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-30.2f\t%-10.2f\t%-10.2f", "Circle",  super.toString(), radius, getArea(), getPerimeter());
    }
    /***
    Getter method required by abstract class 
    @param  none
    @return area of the circle 
     */
    public double getArea(){
        return Math.PI * radius * radius;
    }
    /***
    Getter method required by abstract class
    @param  none
    @return perimeter of the circle
     */
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    /***
    Scalable method that scalses the circle 
    @param  factor the amount to scale the circle by
    @return none
     */
    public void scale(double factor){
        radius = radius * factor;
    }
    /***
    Cloneable method to make a deep copy of the circle
    @param  none
    @return deep copy of circle as a new Circle object
     */
    public Object clone(){
        return new Circle(getColor(), radius);
    }
}
