// Write a program to find factorial of a number. 

import java.util.Scanner;

public class Lab1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        int ans = 1;
        for(int i = 2 ; i <= n ; i++){
            ans *= i;
        }
        System.out.println("factorial = "+ans);
        sc.close();
    }
}
