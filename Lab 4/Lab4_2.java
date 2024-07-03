// Write a program to delete a number from a given location in an array. 

import java.util.Scanner;

public class Lab4_2 {

    static int[] arr;

    public static void deleteAtPosition(int position){

        //position is greater then array length => return
        if(position >= arr.length) {
            return;
        }

        //declare new array ( size - 1 )
        int[] tempArr = new int[arr.length-1];

        // //before position

        // for(int i = 0 ; i < position ; i++){
        //     tempArr[i] = arr[i];
        // }

        // //after position

        // for(int i = position+1 ; i < arr.length ; i++){
        //     tempArr[i-1] = arr[i];
        // }

        int j = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i != position){
                tempArr[j] = arr[i];
                j++;
            }
        }

        arr = tempArr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println("Enter position :");
        int position = sc.nextInt();

        deleteAtPosition(position);

        for(int i : arr){
            System.out.print(i + " ");
        }

        sc.close();
    }
}
