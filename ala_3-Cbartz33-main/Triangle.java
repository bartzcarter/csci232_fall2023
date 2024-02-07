/***
 * Class to model the entity Triangle
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 13, 2023
 * Last Date Modified: February 13, 2023
 */
public class Triangle extends Shape{
    //data members
    private double side1, side2, side3;
    /***
    Default no-arg constructor
    no parameters
    Initializes each side of the triangle to 1.0
    */
    public Triangle(){
        super();
        side1 = side2 = side3 = 1.0;
    }
    /***
    4-arg constructor 
    @param  color to set the color of the triangle
    @param  s1 to set one side length 
    @param  s2 to set the second side length
    @param  s3 to set the third side length
     */
    public Triangle(String color, double s1, double s2, double s3){
        super(color);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    /***
    Getter method for side 1
    @param  none
    @return length of side 1
     */
    public double getSide1(){
        return side1;
    }
    /***
    Getter method for side 2
    @param  none
    @return length of side 2
     */
    public double getSide2(){
        return side2;
    }
    /***
    Getter method for side 3
    @param  none
    @return length of side 3
     */
    public double getSide3(){
        return side3;
    }
    /***
    Setter method for side 1
    @param  s to set side 1
    @return none
     */
    public void setSide1(double s){
        side1 = s;
    }
     /***
    Setter method for side 2
    @param  s to set side 2
    @return none
     */
    public void setSide2(double s){
        side2 = s;
    }
     /***
    Setter method for side 3
    @param  s to set side 3
    @return none
     */
    public void setSide3(double s){
        side3 = s;
    }
    /***
    Overridden method to return formatted string of Triangle information
    @param  none
    @return formatted string of data members and triangle info
     */
    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Triangle", super.toString(), side1, side2, side3, getArea(), getPerimeter());
    }
    /***
    Getter method required by abstract class 
    @param  none
    @return area of the triangle 
     */
    public double getArea(){
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p-side1) * (p-side2) * (p-side3));
    }
    /***
    Getter method required by abstract class
    @param  none
    @return perimeter of the triangle
     */
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    /***
    Scalable method that scales the trianlge 
    @param  factor the amount to scale the triangles sides by
    @return none
     */
    public void scale(double  factor){
        side1 *= factor;
        side2 *= factor;
        side3 *= factor;
    }
    /***
    Cloneable method to make a deep copy of the triangle
    @param  none
    @return deep copy of triangle as a new Triangle object
     */
    public Object clone(){
        return new Triangle(getColor(), side1, side2, side3);
    }
}

