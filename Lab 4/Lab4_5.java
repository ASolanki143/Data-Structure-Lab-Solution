//Write a program to delete duplicate numbers from an array. 

import java.util.HashSet;
import java.util.Scanner;

public class Lab4_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //enter a size of an array 
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        //declare a array of size n
        int[] array = new int[n];

        //take a input from user
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        //call mathod for removing dublicate
        int[] uniqueArray = removeDuplicates(array);
        
        System.out.println("Array without duplicates: ");

        for(int x : uniqueArray){
            System.out.print(x + " ");
        }

        sc.close();

    }
    public static int[] removeDuplicates(int[] array) {

        //define hashset (that contains only unique element)
        HashSet<Integer> set = new HashSet<>();

        //add all element of array in set
        for (int num : array) {
            set.add(num);
        }

        //declare a array of set size
        int[] uniqueArray = new int[set.size()];
        int index = 0;

        //add all element of set in array
        for (int num : set) {
            uniqueArray[index] = num;
            index++;
        }

        //return array
        return uniqueArray;
    }
}