// Write a program to find factorial of a number. 

import java.util.Scanner;

public class Lab1_5 {

    public static int factorial(int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        int factorial = factorial(n);
        System.out.println("factorial = "+factorial);
        sc.close();
    }
}
