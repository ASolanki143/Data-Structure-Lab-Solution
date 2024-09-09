//Write a program to insert a number at a given location in an array. 

import java.util.Scanner;

public class Lab4_1{

    static int[] arr;

    public static void insertAtPosition(int position , int element){

        //position is greater then array length => return
        if(position >= arr.length) return;

        //declare new array 
        int[] finalArr = new int[arr.length + 1];

        // //before position

        // for(int i = 0 ; i < position ; i++){
        //     finalArr[i] = arr[i];
        // }

        // //insert element

        // finalArr[position] = element;

        // //after position

        // for(int i = position+1 ; i < finalArr.length ; i++){
        //     finalArr[i] = arr[i-1];
        // }

        int j = 0;
        for(int i = 0 ; i < finalArr.length ; i++){
            if (i == position) {
                finalArr[i] = element;
            }
            else{
                finalArr[i] = arr[j];
                j++;
            }
        }

        arr = finalArr;
    }
    public static void main(String[] args){
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

        System.out.println("Enter element :");
        int element = sc.nextInt();

        insertAtPosition(position, element);

        for(int i : arr){
            System.out.print(i + " ");
        }

        sc.close();
    }
}