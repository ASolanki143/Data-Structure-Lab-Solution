// WAP to replace lowercase characters by uppercase & vice-versa in a user specified string

import java.util.Scanner;

public class Lab4_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        String changedString = changeCase(input);

        System.out.println("Toggled case string: " + changedString);

        sc.close();
    }

    public static String changeCase(String str) {
        StringBuilder temp = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                temp.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                temp.append(Character.toLowerCase(c));
            } else {
                temp.append(c);
            }
        }

        return temp.toString();
    }
}
