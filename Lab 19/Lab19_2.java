import java.util.Scanner;

public class Lab19_2 {
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

        int j , curr;
        for(int i = 1 ; i < n ; i++){
            j = i - 1;
            curr = arr[i];
            while(j >= 0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=curr;
        }

        System.out.println();

        System.out.println("---------- Unsorted Array ----------");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        ;

        sc.close();
    }
}
