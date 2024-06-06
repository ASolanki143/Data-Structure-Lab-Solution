//Write a program to find position of the smallest number & the largest number from given n numbers. 

import java.util.Scanner;

public class Lab3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter an Element : ");
            arr[i] = sc.nextInt();
        }

        int smallest_index = 0, largest_index = 0;

        for(int i = 0 ; i < n ; i++){
            if(arr[i] < arr[smallest_index]){
                smallest_index = i;
            }
            if(arr[i] > arr[largest_index]){
                largest_index = i;
            }
        }

        System.out.println("Position of smallest number : "+smallest_index);
        System.out.println("Position of largest number : "+largest_index);
        sc.close();
    }
}
