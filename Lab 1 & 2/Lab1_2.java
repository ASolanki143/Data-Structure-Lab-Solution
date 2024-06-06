// Write a program to find whether a number is odd or even 

import java.util.Scanner;

public class Lab1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        if(n%2==0){
            System.out.println(n + " is Even Number");
        }
        else{
            System.out.println(n + " is Odd Number");
        }
        sc.close();
    } 
}
