//Write a program to determine if an input character string is of the form a^ib^i
//where i >= 1 i.e., Number of ‘a’ should be equal to number of ‘b’.
import java.util.Scanner;
import java.util.Stack;

public class Lab7_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        Stack<Character> stack=new Stack<Character>();
        
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='a'){ // if character is a the push it in the stack 
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i)=='b'){ // if the character is 'b' pop it from the stack
                stack.pop();
            }
            else { // any other character except 'a' or 'b' then it is an invalid string
                System.out.println("Invalid String");
                return;
            }
        }
        if(stack.empty()) // if the stack.empty returns true then number of 'a' is equal to number of 'b'
        {
            System.out.println("Number of a  equal to number of b.");
        }
        else // otherwise there are not
        {
            System.out.println("Number of a is not  equal to number of b.");
        }
    }
}