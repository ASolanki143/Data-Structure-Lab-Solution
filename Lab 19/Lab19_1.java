import java.util.Scanner;

public class Lab19_1 {
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

        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n - i - 1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println();

        System.out.println("---------- Sorted Array ----------");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        ;

        sc.close();
    }
}
