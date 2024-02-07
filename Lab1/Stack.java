public class Stack<E>{
    //underlying data structure - LinkedList<E>
    private LinkedList<E> list;
    //constructor
    public Stack(){
        list = new LinkedList<E>();
    }
    /*
     * This method pushes the data onto the stack
     */
    public void push(E data){
        list.insert(data);
    }
    /*
     * This method pops the data off the stack
     */
    public E pop(){
        E temp = list.getCurData();
        list.delete();
        return temp;
    }
    /*
     * This method checks if the stack is empty
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /*
     * This method returns the size of the stack
     */
    public int lenght(){
        return list.size();
    }
}