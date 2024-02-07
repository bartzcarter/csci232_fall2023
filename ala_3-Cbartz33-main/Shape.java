/***
 * Class to model the entity Shape
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 13, 2023
 * Last Date Modified: February 13, 2023
 */
public abstract class Shape implements Comparable<Shape>, Cloneable, Scalable{
    //data members
    private String color;
    /***
    Default no-arg constructor
    no parameters
    Initializes color to "none"
    */
    protected Shape(){
        color = "none";
    }
    /***
    1-arg constructor 
    @param  color to set the color of the shape
     */
    protected Shape(String color){
        this.color = color;
    }
    /***
    Getter method for the data member color
    @param  none
    @return color the color of the shape
     */
    public String getColor(){
        return color;
    }
    /***
    Setter method for the color of the shape
    @param  color the color of the shape
     */
    public void setColor(String color){
        this.color = color;
    }
    /***
    Overridden method to return a string 
    formatted to display the data member color.
    @param  none
    @return formatted string 
     */
    @Override
    public String toString(){
        return String.format("%10s", color);
    }
    /***
    Abstract method for concrete classes to get area
    @param  none
    @return nothing to return here
     */
    public abstract double getArea();
    /***
    Abstract mehtod for concrete classes to get perimeter
    @param  none
    @return nonthing to return here 
     */
    public abstract double getPerimeter();
    /***
    Abstract method for concrete classes to compare 
    the areas of two shapes
    @param  shape the shape whos area is being compared
    @return -1,0, or 1 depending on results when shapes area is compared
     */
    public int compareTo(Shape shape){
        if(this.getArea() == shape.getArea()){
            return 0;
        }
        else if(this.getArea() > shape.getArea()){
            return 1;
        }
        else{
            return -1;
        }
    }
    /***
    Abstract method for concrete classes to make a deep copy of a shape
    @param  none
    @return nothing to return here
     */
    public abstract Object clone();
    /***
    Abstract method for concrete classes to scale a shape by a given factor
    @param  factor the factor that the shape will be scaled by
    @return nothing to return here
     */
    public abstract void scale(double factor);
}