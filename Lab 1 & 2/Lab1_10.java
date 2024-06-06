// WAP to convert number of days into year, week & days 

import java.util.Scanner;

public class Lab1_10 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter days : ");
        int d = sc.nextInt();
        int y = d / 365;
        int m = (d - (y * 365)) / 12;
        d = d - (y * 365) - (m * 12);
        System.out.println(y + " years " + m + " months " + d + " days");
        sc.close();
    }
}
