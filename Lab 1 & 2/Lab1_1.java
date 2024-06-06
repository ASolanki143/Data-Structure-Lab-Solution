// Write a program to calculate area of a Circle 

import java.util.Scanner;

public class Lab1_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a radius : ");
        double radius = sc.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println("Area = "+area);
        sc.close();
    }
}