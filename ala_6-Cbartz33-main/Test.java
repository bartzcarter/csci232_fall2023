/***
 * Class to test the Collections Stack and PriorityQueue
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 7, 2023
 * Last Date Modified: March 7, 2023
 */
import java.util.Stack;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;
public class Test{
    /***
    Main method to test Stack and PriorityQueue 
    @param  args comand line
    @return none
    */
    public static void main(String[] args){
        //Testing Stack
        Stack<Integer> postfixStack = new Stack<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String postfix = keyboard.nextLine();
        String[] tokens = postfix.split(" ");
    try{
        for(int i = 0; i<tokens.length; i++){
            if(tokens[i].matches("\\d{1,}")){
                int operand = Integer.parseInt(tokens[i]);
                postfixStack.push(operand);
            }
            else{
                int operand1 = postfixStack.pop();
                int operand2 = postfixStack.pop();
                switch(tokens[i]){
                    case "+":
                    postfixStack.push(operand1 + operand2);
                    break;
                    case "-":
                    postfixStack.push(operand2 - operand1);
                    break;
                    case "*":
                    postfixStack.push(operand1 * operand2);
                    break;
                    case "/": 
                    postfixStack.push(operand2 / operand1);
                    break;
                    default: System.out.println("Invalid ");
                }
            }
        }
    }
    catch(NoSuchElementException e){
        System.out.println("Postfix expression malformed");
    }
        int result = postfixStack.pop();
        if(postfixStack.isEmpty()){
            System.out.println("Result:  " + result);
        }
        else{
            System.out.println("Postfix expression malformed");
        }

        //Testing PriorityQueue

        PriorityQueue<PrintRequest> printQueue = new PriorityQueue<>();
        File file = new File("requests.txt");
        try{
            Scanner read = new Scanner(file);
            while(read.hasNext()){
                int id = read.nextInt();
                String group = read.next();
                long size = read.nextLong();
                PrintRequest pr = new PrintRequest(id, group, size);
                printQueue.offer(pr);
            }
            read.close();
            System.out.println(String.format("%-10s\t%-10s\t%-10s\t%-10s", "User Id", "Group", "Size", "Completion Time"));
            long size = 0;
            while(!printQueue.isEmpty()){
                PrintRequest pr = printQueue.poll();
                size += pr.getSize();
                System.out.println(pr);
            }
            double n = size/10000;
            double days = (n)/(24*3600);
            n = n % (24 * 3600);
            double hours = n/3600;
            n %= 3600;
            double minutes = n/60;
            n %= 60;
            double seconds = n;
            System.out.println(String.format("Total Printing Time: %02.0f:%02.0f:%02.0f:%02.0f", days, hours, minutes, seconds));
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}