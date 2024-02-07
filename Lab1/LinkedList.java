// taken from Algorithms, 4th edition by Sedgewick and Wayne

public class LinkedList<E>{

    private Node<E> head;  
    private Node<E> cur;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        cur = head;
    }

    public E getCurData() {
        if (cur != null) {
            return cur.element;
        }
        else {
            return null;
        } 
    }
        

    public boolean nextData() {
        if (cur != null) {
            cur = cur.next;
        }
        return (cur != null); // false means no next data to move to
                              // in other words, at end of list
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(E element) {
        Node<E> oldhead = head;
        head = new Node<E>(element);
        head.next = oldhead;
        cur = head;
        size++;
    }

    public void delete() {
        if (head != null) {
            head = head.next;
        }
        cur = head;
    }

    public boolean atEndOfList() {
        return (cur == null);
    }

    public void goToHead() {
        cur = head;
    }

    public String printListDataType() {
        this.goToHead();
        return cur.element.getClass().getSimpleName();  
    }

    public int size() {
        return size;
    }
}
