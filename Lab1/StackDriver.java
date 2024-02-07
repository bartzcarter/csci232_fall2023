import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackDriver{
    public static void main(String[] args){
        //read and print what is popped from the stack
        Stack<String> hamlet = new Stack<String>();
        readHamlet("hamlet.txt", hamlet);

        //print what is left on the stack
        System.out.println();
        System.out.print("Left on stack: ");
        while(!hamlet.isEmpty()){
            System.out.print(hamlet.pop() + " ");
        }

        //psotfix evaluation
        System.out.println();
        Stack<String> postfix = new Stack<String>();
        readAndCalculatePostfixEquation("equation.txt", postfix);
    }
    /*
     * This method reads in the data from the file and inserts it into the stack
     */
    public static void readHamlet(String filename, Stack<String> list){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(filename));
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        while(sc.hasNext()){
            String temp = sc.next();
            if(!temp.equals("$")){
                list.push(temp);
            }
            else{
                System.out.print(list.pop() + " ");
            }
        }
        sc.close();
    }
    /*
     * This method reads in the data from the file and uses the stack to evaluate the postfix equation
     */
    public static void readAndCalculatePostfixEquation(String filename, Stack<String> list){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(filename));
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        while(sc.hasNext()){
            String temp = sc.next();
            if(!temp.equals("+") && !temp.equals("-") && !temp.equals("*") && !temp.equals("/")){
                list.push(temp);
            }
            switch(temp){
                case "+":
                    int temp1 = Integer.parseInt(list.pop());
                    int temp2 = Integer.parseInt(list.pop());
                    int temp3 = temp1 + temp2;
                    list.push(Integer.toString(temp3));
                    break;
                case "-":
                    int temp4 = Integer.parseInt(list.pop());
                    int temp5 = Integer.parseInt(list.pop());
                    int temp6 = temp4 - temp5;
                    list.push(Integer.toString(temp6));
                    break;
                case "*":
                    int temp7 = Integer.parseInt(list.pop());
                    int temp8 = Integer.parseInt(list.pop());
                    int temp9 = temp7 * temp8;
                    list.push(Integer.toString(temp9));
                    break;
                case "/":
                    int temp10 = Integer.parseInt(list.pop());
                    int temp11 = Integer.parseInt(list.pop());
                    int temp12 = temp10 / temp11;
                    list.push(Integer.toString(temp12));
                    break;
            }
        }
        System.out.println("The result of the postfix equation is: " + list.pop());
        sc.close();
    }
}
    

