import java.util.Scanner;
import java.util.Stack;

public class Lab7_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = sc.next();

        Stack<Character> s = new Stack<>();

        s.push(str.charAt(0));

        boolean isValid = true;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (!s.isEmpty() && s.lastElement() == '(') {
                    s.pop();
                } 
                else {
                    isValid = false;
                    break;
                }
            }
            else if (str.charAt(i) == '}') {
                if (!s.isEmpty() && s.lastElement() == '{') {
                    s.pop();
                } 
                else {
                    isValid = false;
                    break;
                }
            }
            else if (str.charAt(i) == ']') {
                if (!s.isEmpty() && s.lastElement() == '[') {
                    s.pop();
                } 
                else {
                    isValid = false;
                    break;
                }
            }
            else{
                s.push(str.charAt(i));
            }
        }

        if(s.isEmpty() && isValid){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
        sc.close();
    }
}