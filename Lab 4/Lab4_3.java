//. Write a program to insert a number in an array that is already sorted in an ascending order. 

import java.util.Scanner;

public class Lab4_3 {

    static int[] arr;

    public static void insertElement(int element){
        int[] tempArr = new int[arr.length + 1];
        int i = 0;

        while(i < arr.length && arr[i] < element){
            tempArr[i] = arr[i];
            i++;
        }

        tempArr[i] = element;

        while(i < arr.length){
            tempArr[i+1] = arr[i];
            i++;
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

        System.out.println("Enter an element : ");
        int element = sc.nextInt();

        insertElement(element);

        for(int i : arr){
            System.out.print(i + " ");
        }

        sc.close();
    }
}
