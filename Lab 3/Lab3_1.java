// Write a program to read and display n numbers using an array.

import java.util.Scanner;

public class Lab3_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter an Element : ");
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}