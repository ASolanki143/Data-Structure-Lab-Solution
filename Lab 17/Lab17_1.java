import java.util.Arrays;
import java.util.Scanner;

// Main class to demonstrate hashing with linear probing
public class Lab17_1 {
    static int[] hash = new int[20]; // Hash table of size 20

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15]; // Array to store 15 input integers

        // Read 15 integers from the user and store in arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Store elements from arr into the hash table
        store(arr);

        // Print the hash table
        System.out.println(Arrays.toString(hash));

        sc.close(); // Close the scanner
    }

    // Method to store elements into the hash table
    public static void store(int[] arr) {
        // Loop through each element in arr
        for (int i = 0; i < arr.length; i++) {
            // Get the hash index for the current element
            int index = hashFn(arr[i]);

            // Store the element at the computed hash index
            hash[index] = arr[i];
        }
    }

    // Hash function to compute the index for a given number
    public static int hashFn(int n) {
        // Compute the initial hash index
        int index = (n % 18) + 2;

        // Handle collisions using linear probing
        // Find the next available slot
        while (hash[index] != 0) {
            index = (++index) % 20;
        }

        // Return the computed index
        return index;
    }
}
