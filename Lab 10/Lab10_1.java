import java.util.Scanner;

public class Lab10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a new Node object
        Node node = new Node();

        // Prompt user to enter data for the node
        System.out.println("Enter a data : ");
        node.data = sc.nextInt();  // Read integer input and assign it to node's data

        // Display the node's data
        node.display();

        sc.close();  // Close scanner object
    }
}

// Node class for singly linked list
class Node {
    int data;   // Data stored in the node
    Node next;  // Reference to the next node in the list

    // Default constructor
    public Node() {
        this.next = null;  // Initialize next pointer to null
    }

    // Constructor with data parameter
    public Node(int data) {
        this.data = data;  // Initialize data
    }

    // Constructor with both data and next node parameters
    public Node(int data, Node next) {
        this.data = data;  // Initialize data
        this.next = next;  // Initialize next pointer
    }

    // Method to display the data of the node
    public void display() {
        System.out.println("Data = " + this.data);  // Print the data of the node
    }
}
