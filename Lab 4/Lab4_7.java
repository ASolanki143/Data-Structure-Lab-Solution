// WAP to replace lowercase characters by uppercase & vice-versa in a user specified string

import java.util.Scanner;

public class Lab4_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //take a string from user
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        //call method to change case
        String changedString = changeCase(input);

        //print new string
        System.out.println("Toggled case string: " + changedString);

        sc.close();
    }

    public static String changeCase(String str) {

        //make a object of string builder
        StringBuilder temp = new StringBuilder();

        //loop of all char in string
        for (char c : str.toCharArray()) {

            //if char is lower case 
            if (Character.isLowerCase(c)) {
                //convert to uppercase and append in new string
                temp.append(Character.toUpperCase(c));
            }

            //if char is upper case 
            else if (Character.isUpperCase(c)) {
                //convert to lowercase and append in new string
                temp.append(Character.toLowerCase(c));
            } 

            //append in new string
            else {
                temp.append(c);
            }
        }

        //convert stringbuilder to string and return 
        return temp.toString();
    }
}
