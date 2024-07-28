// Write a program to convert infix notation to postfix notation using stack. 

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Lab8_1{

    public static int stackG(char a){
        if (a=='+' || a=='-') {
            return 2;
        }
        else if(a=='*' || a=='/'){
            return 4;
        }
        else if(a=='^'){
            return 5;
        }
        else if(a=='('){
            return 0;
        }
        else{
            return 8;
        }
    }

    public static int inputF(char a){
        if (a=='+' || a=='-') {
            return 1;
        }
        else if(a=='*' || a=='/'){
            return 3;
        }
        else if(a=='^'){
            return 6;
        }
        else if(a=='('){
            return 9;
        }
        else if(a==')'){
            return 0;
        }
        else{
            return 7;
        }
    }

    public static int rank(char a){
        if (a=='+' || a=='-' || a=='*' || a=='/' || a=='^'){
            return -1;
        }
        return 1;
    }

    public static void convPostfix(String infix){
        infix += ')';
        System.out.println(infix);
        Stack<Character> s = new Stack<>();
        s.push('(');
        char c , temp;
        String polish = "";
        int r = 0;
        for(int i=0 ; i<infix.length() ; i++){
            c = infix.charAt(i);
            
            while (stackG(s.peek()) > inputF(c)) {
                temp = s.pop();
                polish = polish +  temp;
                r = r + rank(temp);
                if (r<1) {
                    break;
                }
            }
            if (stackG(s.peek()) != inputF(c)) {
                s.push(c);
            }
            else{
                s.pop();
            }
        }
        System.out.println(polish);
        if (!s.isEmpty() || r!=1  ) {
            System.out.println("Invalid");
        }
        else{
            System.out.println(polish);
        }
    }
    public static void main(String[] args) throws EmptyStackException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Infix Expression : ");
        String infix = sc.nextLine();
        convPostfix(infix);
        sc.close();
    }
}