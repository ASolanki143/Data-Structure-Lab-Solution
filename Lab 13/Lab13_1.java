import java.util.Scanner;

public class Lab13_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1; // Initialize x to ensure loop execution
        int element;

        CirclularLinkedList cll = new CirclularLinkedList(); // Create circular linked list object

        // Loop to interact with the user and perform operations on the circular linked list
        while (x < 5) {
            // Display menu options
            System.out.println("Enter 1 for insert at first");
            System.out.println("      2 for insert at last");
            System.out.println("      3 for delete at position");
            System.out.println("      4 for display");
            System.out.println("      5 for break");

            x = sc.nextInt(); // Read user choice

            switch (x) {
                case 1:
                    System.out.println("---------- Insert at First ----------");
                    System.out.println("Enter an element : ");
                    element = sc.nextInt();
                    cll.insertAtFirst(element); // Insert element at the beginning of the circular linked list
                    break;
            
                case 2:
                    System.out.println("---------- Insert at Last ----------");
                    System.out.println("Enter an element : ");
                    element = sc.nextInt();
                    cll.insertAtLast(element); // Insert element at the end of the circular linked list
                    break;

                case 3:
                    System.out.println("---------- Delete at Position ----------");
                    System.out.println("Enter a position : ");
                    element = sc.nextInt();
                    cll.deleteAtPosition(element); // Delete element at the specified position in the circular linked list
                    break;

                case 4:
                    System.out.println("---------- Display ----------");
                    cll.display(); // Display the elements of the circular linked list
                    break;
                
                default:
                    break;
            }
        }

        sc.close(); // Close scanner to prevent resource leaks
    }
}

class CirclularLinkedList {
    CNode first; // Head of the circular linked list
    CNode last; // Last node of the circular linked list

    public CirclularLinkedList() {
        first = last = null; // Initialize empty circular linked list
    }

    // Method to insert an element at the beginning of the circular linked list
    public void insertAtFirst(int element) {
        CNode n = new CNode(element);
        if (first == null) {
            first = last = n; // If list is empty, set both first and last to the new node
        } else {
            n.next = first;
            last.next = n;
            first = n; // Set new node as the first node and update links
        }
    }

    // Method to insert an element at the end of the circular linked list
    public void insertAtLast(int element) {
        CNode n = new CNode(element);
        if (first == null) {
            first = last = n; // If list is empty, set both first and last to the new node
        } else {
            n.next = first;
            last.next = n;
            last = n; // Set new node as the last node and update links
        }
    }

    // Method to delete an element at a specified position in the circular linked list
    public void deleteAtPosition(int position) {
        if (first == null) {
            System.out.println("---------- Empty Linked List ----------");
            return; // If list is empty, display message and return
        }
        if (position == 1) {
            if (first == last) {
                first = last = null; // If there's only one node, set first and last to null
            } else {
                first = first.next;
                last.next = first; // Remove first node and adjust links
            }
        }
        int count = 1;
        CNode temp = first.next;
        CNode prev = first;
        while (temp != first) {
            count++;
            if (count == position) {
                prev.next = temp.next;
                if (temp == last) {
                    last = prev; // Remove node at specified position and adjust links
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Method to display the elements of the circular linked list
    public void display() {
        CNode temp = first;
        while (temp.next != first) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data); // Print last node's data
        System.out.println();
    }
}

class CNode {
    int data;
    CNode next;

    public CNode() {
        this.data = 0;
        this.next = null; // Initialize node with default values
    }

    public CNode(int data) {
        this(); // Constructor chaining to initialize node
        this.data = data;
    }

    public CNode(int data, CNode next) {
        this.data = data;
        this.next = next; // Constructor to initialize node with specific data and next pointer
    }
}
