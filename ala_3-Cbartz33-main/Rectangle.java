/***
 * Class to model the entity Rectangle
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 13, 2023
 * Last Date Modified: February 13, 2023
 */
public class Rectangle extends Shape{
    //data members
    private double length, width;
    /***
    Default no-arg constructor
    no parameters
    Initializes length and width each to 1.0
    */
    public Rectangle(){
        super();
        length = width = 1.0;
    }
    /***
    3-arg constructor 
    @param  color to set the color of the triangle
    @param  length to set the length of the rectangle 
    @param  width to set the with of the rectangle
     */
    public Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }
    /***
    Getter method for the length of the rectangle
    @param  none
    @return length of the rectangle
     */
    public double getLenght(){
        return length;
    }
    /***
    Getter method for the width of the rectangle
    @param  none
    @return width of the rectangle
     */
    public double getWidth(){
        return width;
    }
    /***
    Setter method for the length of the rectangle
    @param  l to set the length
    @return none
     */
    public void setLength(double l){
        length = l;
    }
    /***
    Setter method for the width of the rectangle
    @param  w to set the length
    @return none
     */
    public void setWidth(double w){
        width = w;
    }
    /***
    Overridden method to return formatted string of Recatngle Information
    @param  none
    @return formatted string of the data members and Rectangle info
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-15.2f\t%-15.2f\t%-15.2f\t%-15.2f", "Rectangle" ,super.toString(), length, width, getArea(), getPerimeter());
    }
    /***
    Getter method required by abstract class 
    @param  none
    @return area of the rectangle 
     */
    public double getArea(){
        return length * width;
    }
     /***
    Getter method required by abstract class
    @param  none
    @return perimeter of the rectangle
     */
    public double getPerimeter(){
        return 2 * (length + width);
    }
    /***
    Scalable method that scales the rectangle 
    @param  factor the amount to scale the rectangle width and length by
    @return none
     */
    public void scale(double factor){
        length *= factor;
        width *= factor;
    }
    /***
    Cloneable method to make a deep copy of the rectangle
    @param  none
    @return deep copy of rectangle as a new Rectangle object
     */
    public Object clone(){
        return new Rectangle(getColor(), getLenght(), getWidth());
    }
}
