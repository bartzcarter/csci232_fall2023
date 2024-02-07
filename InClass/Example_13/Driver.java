import java.util.Scanner;

class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        LinkedList<String> ll = new LinkedList<String>();

        while(in.hasNext()){
           ll.insert(in.next());
        }
        System.out.print("List is ");
        while (ll.getCurData() != null) {
            System.out.print(ll.getCurData() + " ");
            if (ll.nextData() == false) {
                break;
            }
            
        } 
        in.close();
    }
}