import java.util.Scanner;

// Main class to demonstrate linear search
public class Lab18_1 {

    // Method to perform linear search on the array
    public static int linearSearch(int[] arr, int element, int n) {
        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            // If the current element matches the search element, return the index
            if (arr[i] == element) {
                return i;
            }
        }
        // If the element is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter elements of array");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Display the elements of the array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Prompt the user to enter the element to search for
        System.out.println("Enter a search element ");
        int element = sc.nextInt();

        // Perform linear search and get the index of the search element
        int index = linearSearch(arr, element, n);

        // Print whether the element was found and its index
        if (index == -1)
            System.out.println("---------- Element not found ----------");
        else
            System.out.println("---------- Element found at index : " + index + " ----------");

        // Close the scanner
        sc.close();
    }
}
