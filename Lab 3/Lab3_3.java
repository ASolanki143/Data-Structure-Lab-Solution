// Write a program to calculate average of first n numbers

import java.util.Scanner;

public class Lab3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();

        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += i;
        }

        double avg = (double)sum / (double)n;
        System.out.println("Average = "+avg);
        sc.close();
    }
}
