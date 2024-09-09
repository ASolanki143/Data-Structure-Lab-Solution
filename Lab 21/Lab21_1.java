import java.util.Scanner;

public class Lab21_1 {

    public static void mergeSort(int[] arr , int left , int right){
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr , left , right , mid);

    }

    public static void merge(int arr[] , int left , int right , int mid){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int larr[] = new int[n1];
        int rarr[] = new int[n2];

        for(int i = 0 ; i < n1 ; i++) larr[i] = arr[left+i];
        for(int i = 0 ; i < n2 ; i++) rarr[i] = arr[mid+i+1];

        int i = 0 , j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(larr[i] < rarr[j]){
                arr[k] = larr[i];
                i++;
            }
            else{
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = larr[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = rarr[j];
            j++;
            k++;
        }
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

        mergeSort(arr, 0, n-1);

        System.out.println();

        System.out.println("---------- Sorted Array ----------");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        ;

        sc.close();
    }
}
