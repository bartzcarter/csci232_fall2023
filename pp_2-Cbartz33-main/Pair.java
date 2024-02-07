/***
 * @author Carter Bartz/Lehigh Professors
 * @version 0.1
 * Date of creation: April 10, 2023
 * Last Date Modified: April 12, 2023
 */
public class Pair<E1,E2>{
    //data members
    private E1 first;
    private E2 second;
    /**
        no-arg constructor to set first and second to null
     */
    public Pair(){
        first = null;
        second = null;
    }
    /**
        2-arg constructor to initialize first and second
     */
    Pair(E1 f, E2 s){
        first = f;
        second = s;
    }
    /**
        getter method for the data member first
        @param  none
        @return first the first in the pair
     */
    public E1 getFirst(){
        return first;
    }
    /**
        getter method for the data member second
        @return second the second in the pair
     */
    public E2 getSecond(){
        return second;
    }
    /**
        setter method for the data member first
        @param  f to set first
     */
    public void setFirst(E1 f){
        first = f;
    }
    /**
        setter method for the data member second
        @param  s to set second
     */
    public void setSecond(E2 s){
        second = s;
    }
    /**
        Overriden toString() method
        @return string to fit the formatting of a pair (P1, P2)
     */
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
    /**
        Overriden equals() method
        @return true if two Pairs are equal
        @return false if they are not equal
     */
    public boolean equals(Object o){
        // downcast o to Pair
        if(o instanceof Pair){//safe downcasting
            Pair<E1,E2> pair = (Pair) o;// downcasting
            return this.getFirst().equals(pair.getFirst()) && // equals for type E1
                   this.getSecond().equals(pair.getSecond()); // equals() for type E2
        }
        return false;
    }
}