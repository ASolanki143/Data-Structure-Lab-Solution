// WAP to convert seconds into hours, minutes & seconds and print in HH:MM:SS 

import java.util.Scanner;

public class Lab1_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a second : ");
        int s = sc.nextInt();

        int h = s / 3600;
        int m = (s - (h * 3600)) / 60;
        s = (s - (h * 3600) - (m * 60));

        System.out.println(h + " : " + m + " : " + s);
        sc.close();
    }
}
