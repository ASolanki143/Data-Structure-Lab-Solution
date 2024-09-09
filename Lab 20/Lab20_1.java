import java.util.Scanner;

public class Lab20_1 {
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

        for(int i = 0 ; i < n - 1 ; i++){
            int minIndex = i;
            for(int j = i + 1 ; j < n ; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println();

        System.out.println("---------- Unsorted Array ----------");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        ;

        sc.close();
    }
}
