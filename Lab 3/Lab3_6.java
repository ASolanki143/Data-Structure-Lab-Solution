// Read n numbers in an array then read two different numbers, replace 1st number with 2nd number in an array and print its index and final array. 

import java.util.Scanner;

public class Lab3_6 {

    public static int findIndex(int[] arr , int target){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter an Element : ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter first number :");
        int a = sc.nextInt();
        System.out.println("Enter second number : ");
        int b = sc.nextInt();

        int first_index = findIndex(arr , a);
        int second_index = findIndex(arr , b);

        if(first_index == -1 || second_index == -1){
            System.out.println("Element not found");
        }

        else{
            int temp = arr[first_index];
            arr[first_index] = arr[second_index];
            arr[second_index] = temp;

            for(int i = 0 ; i < n ;i++){
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
    }
}
