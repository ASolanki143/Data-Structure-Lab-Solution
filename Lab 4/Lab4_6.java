//Write a program to merge two unsorted arrays.

import java.util.Scanner;

public class Lab4_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //for first array 
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("Enter array's element");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        //for second array
        System.out.println("Enter size of array");
        int m = sc.nextInt();
        int arr2[] = new int[n];
        System.out.println("Enter array's element");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        //declare a new array of size m + n (arr1 length + arr2 length)
        int ans[] = new int[m + n];


        for (int i = 0; i < m + n; i++) {
            //for i = 0 to n-1 add element of array 1
            if (i < n) {
                ans[i] = arr1[i];
            } 
            //for n to m+n-1 add element of array 2
            else {
                ans[i] = arr2[i - n];
            }
        }
        
        //print new merge array
        System.out.println("Display array's elements");
        for (int i = 0; i < m + n; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}
