import java.util.Scanner;

public class Lab18_2 {

    public static int binarySearch(int[] arr, int element, int n) {
        int start = 0, end = n - 1, mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == element)
                return mid;
            if (arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        
        System.out.println();

        System.out.println("Enter a search element ");
        int element = sc.nextInt();
        int index = binarySearch(arr, element, n);

        if (index == -1)
            System.out.println("---------- Element not found ----------");
        else
            System.out.println("---------- Element found at index : " + index + " ----------");

        sc.close();
    }
}
