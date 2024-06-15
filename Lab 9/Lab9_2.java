import java.util.Scanner;

// Main class
public class Lab9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of queue : ");
        int n = sc.nextInt();

        // Create an object of CircularQueue class for circular queue operations
        CircularQueue q = new CircularQueue(n);

        int x = 1;
        while (x < 4) {  // Continue until user chooses option 4
            // Display menu options
            System.out.println("Enter 1 for enqueue ");
            System.out.println("      2 for dequeue ");
            System.out.println("      3 for display");
            System.out.println("      4 for break");

            x = sc.nextInt();  // Read user choice

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element = sc.nextInt();
                    q.circularQueueInsert(element);  // Add element to the circular queue
                    break;

                case 2:
                    int y = q.circluarQueueDelete();  // Remove element from the circular queue
                    if (y > -1) {
                        System.out.println("---------- " + y + " deleted ----------");
                    }
                    break;

                case 3:
                    q.display();  // Display all elements in the circular queue
                    break;

                default:
                    break;
            }
        }

        sc.close();  // Close scanner object
    }
}

// CircularQueue class for implementing circular queue operations
class CircularQueue {

    int r;         // Rear pointer (points to the last element in the circular queue)
    int f;         // Front pointer (points to the first element in the circular queue)
    int size;      // Maximum size of the circular queue
    int[] cqueue;  // Array to store circular queue elements

    // Constructor to initialize the circular queue
    public CircularQueue(int n) {
        r = -1;           // Initialize rear pointer
        f = -1;           // Initialize front pointer
        size = n;         // Set maximum size of the circular queue
        cqueue = new int[n];  // Create an array with given size to store elements
    }

    // Method to insert an element into the circular queue
    public void circularQueueInsert(int element) {
        // Update rear pointer
        if (r == size - 1) {  // If rear pointer is at the last index of the array
            r = 0;            // Wrap around to the beginning of the array
        } else {
            r++;              // Move rear pointer to the next position
        }

        // Check for queue overflow
        if (f == r) {
            System.out.println("---------- Queue Overflow ----------");
            return;
        }

        // Insert element at rear pointer
        cqueue[r] = element;

        // Initialize front pointer if it's not already set
        if (f == -1) {
            f = 0;  // When inserting the first element in the queue
        }

        display();  // Display elements after insertion
    }

    // Method to delete an element from the circular queue
    public int circluarQueueDelete() {
        // Check for queue underflow
        if (f == -1) {
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }

        // Store element at front pointer
        int element = cqueue[f];

        // Clear element at front pointer
        cqueue[f] = 0;

        // Update front and rear pointers
        if (f == r) {  // If queue has only one element
            f = -1;
            r = -1;
        } else if (f == size - 1) {  // If front pointer is at the last index of the array
            f = 0;  // Wrap around to the beginning of the array
        } else {
            f++;  // Move front pointer to the next position
        }

        display();  // Display elements after deletion
        return element;  // Return deleted element
    }

    // Method to display all elements in the circular queue
    public void display() {
        System.out.println("---------- Display ----------");
        for (int i = 0; i < size; i++) {
            System.out.print(cqueue[i] + " ");  // Print each element in the circular queue
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}
