//Write a program to calculate sum of numbers from m to n. 

import java.util.Scanner;

public class Lab3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value of m : ");
        int m = sc.nextInt();
        System.out.println("Enter a value of n : ");
        int n = sc.nextInt();

        int sum = 0;
        for(int i = m ; i <= n ; i++){
            sum += i;
        }

        System.out.println("Sum = "+sum);
        sc.close();
    }
}
