import java.util.Scanner;

public class Lab21_2{

    public static void quickSort(int arr[] , int low , int high){
        if(low  < high){
            int pivotIndex = partition(arr , low , high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    //pivot = first element
    public static int partition(int arr[] , int low , int high){
        int pivot = arr[low];
        int j = high;

        for(int i = high ; i >= low ; i--){
            if(pivot < arr[i]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        int temp = arr[j];
        arr[j] = pivot;
        arr[low] = temp;
        return j;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ;

        System.out.println("---------- Unsorted Array ----------");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        ;

        quickSort(arr, 0, n-1);

        
        System.out.println();

        System.out.println("---------- Unsorted Array ----------");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        ;

        sc.close();
    }
}
