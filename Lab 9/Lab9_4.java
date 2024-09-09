import java.util.Scanner;

// Main class
public class Lab9_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a size of an array : ");
        int n = sc.nextInt();

        // Create an instance of PriorityQueue
        PriorityQueue pq = new PriorityQueue(n);
        int x = 1;
        int element;

        while (x < 4) {  // Continue until user chooses option 4
            // Display menu options
            System.out.println("Enter 1 for insert");
            System.out.println("      2 for delete");
            System.out.println("      3 for display");
            System.out.println("      4 for break");

            x = sc.nextInt();  // Read user choice

            switch (x) {
                case 1:
                    System.out.println("---------- Insert Element ----------");
                    System.out.print("Enter an element : ");
                    element = sc.nextInt();
                    pq.insert(element);  // Insert element into priority queue
                    break;

                case 2:
                    System.out.println("---------- Delete Element ----------");
                    element = pq.delete();  // Delete element from priority queue
                    if (element > -1) {
                        System.out.println("---------- " + element + " deleted ----------");
                    }
                    break;

                case 3:
                    System.out.println("---------- Display ----------");
                    pq.display();  // Display elements in the priority queue
                    break;

                default:
                    break;
            }
        }
        sc.close();  // Close scanner object
    }
}

// Priority queue class
class PriorityQueue {
    int[] arr;  // Array to store elements
    int front;  // Front index
    int rear;   // Rear index
    int size;   // Maximum size of the priority queue

    // Constructor to initialize priority queue
    public PriorityQueue(int size) {
        this.size = size;
        this.arr = new int[size];  // Initialize array with given size
        this.rear = this.front = -1;  // Initialize front and rear indices
    }

    // Method to insert element into the priority queue
    public void insert(int element) {
        if (rear - front >= size - 1) {  // Check for queue overflow
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        if (front == -1) {  // If queue is empty
            front = rear = 0;
            arr[front] = element;
            return;
        }
        int j = rear;
        // Find correct position for new element to maintain ascending order
        while (j >= 0 && arr[j] > element) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = element;  // Insert element at correct position
        rear++;  // Increment rear index
        display();  // Display elements after insertion
    }

    // Method to delete element from the priority queue
    public int delete() {
        if (front == -1) {  // Check for queue underflow
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        
        int j = front;
        int element = arr[front];  // Element to be deleted
        // Shift elements to the left to fill the gap
        while (j < rear) {
            arr[j] = arr[j + 1];
            j++;
        }
        arr[j] = 0;  // Clear the last element
        if (front == rear) {  // Reset front and rear indices if queue becomes empty
            front = rear = -1;
        } else {
            rear--;  // Decrement rear index
        }
        display();  // Display elements after deletion
        return element;  // Return deleted element
    }

    // Method to display elements of the priority queue
    public void display() {
        if (front == -1) {  // Check if queue is empty
            System.out.println("---------- Empty Queue ----------");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");  // Print each element
        }
        System.out.println();  // Move to next line after printing elements
    }
}
