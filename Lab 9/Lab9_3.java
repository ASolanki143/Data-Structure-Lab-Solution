import java.util.Scanner;

// Main class
public class Lab9_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of queue : ");
        int n = sc.nextInt();

        // Create an instance of DoubleEndedQueue
        DoubleEndedQueue q = new DoubleEndedQueue(n);

        int x = 1;
        while (x < 6) {  // Continue until user chooses option 6
            // Display menu options
            System.out.println("Enter 1 for insert at rear ");
            System.out.println("      2 for insert at front ");
            System.out.println("      3 for delete from front");
            System.out.println("      4 for delete from rear");
            System.out.println("      5 for display");
            System.out.println("      6 for break");

            x = sc.nextInt();  // Read user choice

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element1 = sc.nextInt();
                    q.insertAtRear(element1);  // Insert at rear of the queue
                    break;

                case 2:
                    System.out.println("Enter an element : ");
                    int element2 = sc.nextInt();
                    q.insertAtFront(element2); // Insert at front of the queue
                    break;

                case 3:
                    int y1 = q.deleteAtFront();  // Delete from front of the queue
                    if (y1 > -1) {
                        System.out.println("---------- "+y1+" deleted ----------");
                    }
                    break;

                case 4:
                    int y2 = q.deleteAtRear();  // Delete from rear of the queue
                    if (y2 > -1) {
                        System.out.println("---------- "+y2+" deleted ----------");
                    }
                    break;

                case 5:
                    q.display();  // Display the elements in the queue
                    break;

                default:
                    break;
            }
        }

        sc.close();  // Close scanner object
    }
}

// Double-ended queue class
class DoubleEndedQueue {

    int f;  // Front index
    int r;  // Rear index
    int size;  // Size of the queue
    int[] dqueue;  // Array to store queue elements

    // Constructor to initialize the queue
    public DoubleEndedQueue(int n) {
        f = -1;  // Initialize front index
        r = -1;  // Initialize rear index
        size = n;  // Set size of the queue
        dqueue = new int[n];  // Create array for queue elements
    }

    // Method to insert element at the rear of the queue
    public void insertAtRear(int element) {
        if (r >= size - 1) {  // Check for queue overflow
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        r++;  // Increment rear index
        dqueue[r] = element;  // Insert element at rear
        if (f == -1) {  // Adjust front index if first element
            f = 0;
        }
        System.out.println("---------- Element Added at Rear ----------");
    }

    // Method to insert element at the front of the queue
    public void insertAtFront(int element) {
        if (f == -1) {  // Check if queue is empty
            System.out.println("---------- Empty ----------");
            return;
        }
        if (f == 0) {  // Check for queue overflow
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        f--;  // Decrement front index
        dqueue[f] = element;  // Insert element at front
        System.out.println("---------- Element Added at Front ----------");
    }

    // Method to delete element from the front of the queue
    public int deleteAtFront() {
        if (f == -1) {  // Check for queue underflow
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        int element = dqueue[f];  // Get element at front
        if (f == r) {  // Reset indices if only one element
            f = -1;
            r = -1;
        } else {
            f++;  // Increment front index
        }
        return element;  // Return deleted element
    }

    // Method to delete element from the rear of the queue
    public int deleteAtRear() {
        if (r == -1) {  // Check for queue underflow
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        int y = dqueue[r];  // Get element at rear
        dqueue[r] = 0;  // Clear element at rear
        if (r == f) {  // Reset indices if only one element
            r = -1;
            f = -1;
        } else {
            r--;  // Decrement rear index
        }
        return y;  // Return deleted element
    }

    // Method to display elements of the queue
    public void display() {
        System.out.println("---------- Display ----------");
        for (int i = 0; i < size; i++) {
            System.out.print(dqueue[i] + " ");  // Print each element
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}
