// Write a program to find whether the array contains a duplicate number or not.

import java.util.Scanner;

public class Lab3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter an Element : ");
            arr[i] = sc.nextInt();
        }

        boolean contains_duplicate = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(arr[i] == arr[j]){
                    contains_duplicate = true;
                    break;
                }
            }
        }

        if(contains_duplicate){
            System.out.println("Array contains duplicate element");
        }
        else{
            System.out.println("Array does not contains duplicate element");
        }
        sc.close();
    }
}
