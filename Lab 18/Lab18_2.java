import java.util.Scanner;

// Main class to demonstrate binary search
public class Lab18_2 {

    // Method to perform binary search on the array
    public static int binarySearch(int[] arr, int element, int n) {
        int start = 0, end = n - 1, mid;

        // Loop until the search space is exhausted
        while (start <= end) {
            // Calculate the mid-point of the current search space
            mid = (start + end) / 2;

            // If the element is found at mid, return its index
            if (arr[mid] == element)
                return mid;

            // If the element is less than the mid-element, search in the left half
            if (arr[mid] > element)
                end = mid - 1;
            // If the element is greater than the mid-element, search in the right half
            else
                start = mid + 1;
        }

        // If the element is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.println("Enter a size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Display the elements of the array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Prompt the user to enter the element to search for
        System.out.println("Enter a search element: ");
        int element = sc.nextInt();

        // Perform binary search and get the index of the search element
        int index = binarySearch(arr, element, n);

        // Print whether the element was found and its index
        if (index == -1)
            System.out.println("---------- Element not found ----------");
        else
            System.out.println("---------- Element found at index: " + index + " ----------");

        // Close the scanner
        sc.close();
    }
}
