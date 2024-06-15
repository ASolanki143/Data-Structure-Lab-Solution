import java.util.Scanner;

// Main class
public class Lab9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of queue : ");
        int n = sc.nextInt();

        // Create an object of QueueDemo class for queue operations
        QueueDemo q = new QueueDemo(n);

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
                    q.enqueue(element);  // Add element to the queue
                    break;

                case 2:
                    int y = q.dequeue();  // Remove element from the queue
                    if (y > -1) {
                        System.out.println("---------- " + y + " deleted ----------");
                    }
                    break;

                case 3:
                    q.display();  // Display all elements in the queue
                    break;

                default:
                    break;
            }
        }

        sc.close();  // Close scanner object
    }
}

// QueueDemo class to implement a basic queue
class QueueDemo {

    int r;       // Rear pointer (points to the last element in the queue)
    int f;       // Front pointer (points to the first element in the queue)
    int size;    // Maximum size of the queue
    int[] queue; // Array to store queue elements

    // Constructor to initialize the queue
    public QueueDemo(int n) {
        this.r = -1;        // Initialize rear pointer
        this.f = -1;        // Initialize front pointer
        this.size = n;      // Set maximum size of the queue
        queue = new int[n]; // Create an array with given size to store elements
    }

    // Method to enqueue (add) an element to the queue
    public void enqueue(int element) {
        if (r >= size - 1) {  // Check if queue is full (queue overflow)
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        r++;             // Move rear pointer to next position
        queue[r] = element;  // Add element at rear
        if (f == -1) {   // If queue was empty, adjust front pointer
            f = 0;
        }
        System.out.println("---------- Element Added ----------");
        display();       // Display elements after insertion
    }

    // Method to dequeue (remove) an element from the queue
    public int dequeue() {
        if (f == -1) {   // Check if queue is empty (queue underflow)
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        int element = queue[f];  // Get element at front
        if (f == r) {    // If queue has only one element
            f = -1;      // Reset front and rear pointers
            r = -1;
        } else {
            f++;         // Move front pointer to next position
        }
        display();       // Display elements after deletion
        return element;  // Return deleted element
    }

    // Method to display all elements in the queue
    public void display() {
        if (f == -1 || r == -1) {  // Check if queue is empty
            System.out.println("---------- Empty Queue ----------");
            return;
        }
        System.out.println("---------- Display ----------");
        for (int i = f; i <= r; i++) {
            System.out.print(queue[i] + " - ");  // Print each element in the queue
        }
        System.out.println();  // Move to next line after printing elements
        System.out.println("-----------------------------");
    }
}
