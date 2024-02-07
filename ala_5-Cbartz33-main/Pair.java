/***
 * Class to model the General entity Pair
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: February 28, 2023
 * Last Date Modified: February 28, 2023
 */
public class Pair<E1, E2>{
    //data members 
    private E1 first;
    private E2 second;
    /***
    no-arg default constructor
    Initialize first and second both to null
    @param  none
    @return none
     */
    public Pair(){
        first = null;
        second = null;
    }
    /***
    2-arg constructor
    Initialize first and second with passed object type
    @param  f the type E1 to set first
    @param  s the type E2 to set second
    @return none
     */
    public Pair(E1 f, E2 s){
        first = f;
        second = s;
    }
    /***
    Getter method to return the first object in the pair
    @param  none
    @return first, the first object in pair
     */
    public E1 getFirst(){
        return first;
    }
    /***
    Getter method to return the second object in the pair
    @param  none
    @return second, the second object in pair
    */
    public E2 getSecond(){
        return second;
    }
    /***
    Setter method to set the first object in the pair
    @param  f of type E1 to set first
    @return none
     */
    public void setFirst(E1 f){
        first = f;
    }
    /***
    Setter method to set the second object in the pair
    @param  s of type E2 to set second
    @return none
     */
    public void setSecond(E2 s){
        second = s;
    }
    /***
    Overriden toString method to return the pair in string format
    @param none
    @return String format (first, second)
     */
     @Override
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
    /***
    equals method that will return either true or false regarding the equality of two pairs
    @param o an object to check for type pair and compare
    @return true if the pairs are equal
    @return false if the pairs are not equal
     */
    public boolean equals(Object o){
        if(o instanceof Pair){
            Pair<E1, E2> pair = (Pair)o;
            return this.getFirst().equals(pair.getFirst()) && this.getSecond().equals(pair.getSecond());
        }
        return false;
    }
}