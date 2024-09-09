/*
 * Chef has a string which contains only the characters '{', '}', '[', ']', '(' and ')'. Now
Chef wants to know if the given string is balanced or not. If is balanced then
print 1, otherwise print 0.
 A balanced parenthesis string is defined as follows:
o The empty string is balanced
o If P is balanced then (P), {P}, [P] is also balanced
o if P and Q are balanced PQ is also balanced
o "([])", "({})[()]" are balanced parenthesis strings
o "([{]})", "())" are not balanced.
 Input: The first line of the input contains a single integer T denoting the
number of test cases. The description of T test cases follows. The first
and only line of each test case contains a single string
 Output: For each test case, print a single line containing the answer.
 Example of Input & Output
o Input:
 Enter No of Test Cases: 4
 ()
 ([)]
 ([{}()])[{}]
 [{{}]
o Output
 1
 0
 1
 0
 */

import java.util.Scanner;
import java.util.Stack;

public class Lab7_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = sc.next();

        Stack<Character> s = new Stack<>();
        // Pushing one character from the string into the the stack
        s.push(str.charAt(0));

        boolean isValid = true;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {   // if the character is ')' then only go through its block 
                if (!s.isEmpty() && s.lastElement() == '(') {  // the character is only pop if the the the 
                    s.pop();                                    //topmost character of the stack is opening of the same style bracket
                } 
                else {                                          // if not then then it is not valid parenthesis
                    isValid = false;
                    break;
                }
            }
            else if (str.charAt(i) == '}') {  // if the character is '}' then only go through its block 
                if (!s.isEmpty() && s.lastElement() == '{') {
                    s.pop();
                } 
                else {
                    isValid = false;
                    break;
                }
            }
            else if (str.charAt(i) == ']') {  // if the character is ']' then only go through its block 
                if (!s.isEmpty() && s.lastElement() == '[') {
                    s.pop();
                } 
                else {
                    isValid = false;
                    break;
                }
            }
            else{ // if there are not any type of opening bracket then push into the the stack
                s.push(str.charAt(i));
            }
        }

        if(s.isEmpty() && isValid){  
            System.out.println("1");  // return 1 only if the stack is empty and the string is valid throughout the process
        }
        else{
            System.out.println("0");
        }
        sc.close();
    }
}