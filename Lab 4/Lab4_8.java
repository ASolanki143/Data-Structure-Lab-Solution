// Suppose you are senior developer for an Relational Database Management System   named "Array Database" where everything is implemented using only array, today your task is to implement aggregate function like sum, min, max, avg. For simplicity, assume that your database can only store integers. 

import java.util.Scanner;

public class Lab4_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //take a size of an array from user
        System.out.println("Enter size of array");
        int n = sc.nextInt();

        //declare an array of size n
        int arr[] = new int[n];

        //take elements of array from user
        System.out.println("Enter elements of array");
        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        //find sum , maximum element and minimum element
        int sum=0;
        int min=arr[0];
        int max=arr[0];
        for(int i=0 ; i<n ; i++)
        {
            sum += arr[i];
            if(arr[i]<min)
            {
                min=arr[i];
            }
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }

        //print all 
        System.out.println("Sum = "+sum);
        System.out.println("Avg = "+(double)sum/n);
        System.out.println("Min = "+min);
        System.out.println("Max = "+max);

        sc.close();
    }
}
