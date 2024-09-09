import java.util.Scanner;
import java.util.Stack;

public class Lab7_2 {

    public static boolean checkString(String str){
        // Use of Generic Stack Class from Java for implementation
        Stack<Character> s = new Stack<>();

        int index = 0;
        s.push('c');
        char next = str.charAt(index);
        //Loop is continuously iterating until the character 'c' is not found in the string
        while(next != 'c'){
            if(next == ' '){  // if there is any space in between the characters then it will 
                return false; // consider false
            }
            s.push(next); // insert character next in stack
            index++;
            next = str.charAt(index);
        }

        index++;
        // Loop is continuously iterating until the character 'c' not the topmost element in the stack or the until it reaches the end of the stirng
        while(s.peek() != 'c' && index < str.length()){
            next = str.charAt(index);
            //if the topmost element from the stack and next character from the stack is not same then is it is not valid
            if(next != s.pop()){
                return false;
            }
            index++;
        }

        next = str.charAt(index-1);
        if(next != ' ' && s.peek() != 'c'){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string : ");
        String str = sc.nextLine();

        if(checkString(str)){
            System.out.println("Given String is Valid");
        }
        else{
            System.out.println("Given String is not valid");
        }

        sc.close();
    }
}