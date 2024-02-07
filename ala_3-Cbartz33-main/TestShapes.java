/***
 * Class to test the classes Shape.java, Circle.java, Triangle,.java
    Rectangle.java, and Pentagon.java.
    Tests the interface Scalable, and Colonable
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 13, 2023
 * Last Date Modified: February 13, 2023
 */
public class TestShapes{
    //Main method
    public static void main(String[]args){
        Shape[] shapes = new Shape[8];
        shapes[0] = new Circle("Black", 2.5);
        shapes[1] = new Triangle("Green", 6.0, 6.0, 6.0);
        shapes[2] = new Rectangle("Red", 5.0, 3.0);
        shapes[3] = new Pentagon("Yellow", 7.0);
        shapes[4] = (Shape)shapes[0].clone();
        shapes[5] = (Shape)shapes[1].clone();
        shapes[6] = (Shape)shapes[2].clone();
        shapes[7] = (Shape)shapes[3].clone();

        shapes[4].scale(2.0);
        shapes[5].setColor("Orange");
        ((Rectangle)shapes[6]).setLength(10.0);
        ((Pentagon)shapes[7]).setSide(4.0);
        System.out.println();
        System.out.println("Original List: ");
        printArray(shapes);
        java.util.Arrays.sort(shapes);
        System.out.println();
        System.out.println("Sorted List: ");
        printArray(shapes);
        System.out.printf("\nAverage Perimeter: %.2f\n" , getAveragePerimeter(shapes));
    }
    /***
    Void method that prints the objects within the Shape[] list
    @param list the Shape array that holds different shape objects
    @return none
     */
    public static void printArray(Shape[] list){
        for(Shape s : list){
            System.out.println(s);
        }
    }
    /***
    Getter method for the average perimeter of the shape objects within Shape[]list
    @param  list the Shape array that holds different shape objects
    @return average perimeter (p divided by the length of the list array) 
     */
    public static double getAveragePerimeter(Shape [] list){
        double p=0;
        for(Shape s: list){
            p += s.getPerimeter();
        }
        return p / list.length;
    }
}

