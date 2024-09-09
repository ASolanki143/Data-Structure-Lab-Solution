import java.util.Scanner;

public class Lab10_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int x = 1;

        // Loop for menu-driven operations
        while(x < 7){
            System.out.println("Enter 1 for insert at first");
            System.out.println("      2 for insert at end");
            System.out.println("      3 for delete at first");
            System.out.println("      4 for delete at last");
            System.out.println("      5 for delete at position");
            System.out.println("      6 for display");
            System.out.println("      7 for break");
            x = sc.nextInt(); // Read user input for operation choice

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element1 = sc.nextInt(); // Read element to be inserted
                    linkedList.insertAtFirst(element1); // Insert at the beginning of the linked list
                    break;

                case 2:
                    System.out.println("Enter an element : ");
                    int element2 = sc.nextInt(); // Read element to be inserted
                    linkedList.insertAtLast(element2); // Insert at the end of the linked list
                    break;

                case 3:
                    linkedList.deleteAtFirst(); // Delete from the beginning of the linked list
                    break;
            
                case 4:
                    linkedList.deleteAtLast(); // Delete from the end of the linked list
                    break;

                case 5:
                    System.out.println("Enter position ");
                    int position = sc.nextInt(); // Read position to delete
                    linkedList.deleteAtPosition(position); // Delete at specified position in the linked list
                    break;

                case 6:
                    linkedList.display(); // Display all elements in the linked list
                    break;

                default:
                    break;
            }
        }

        sc.close(); // Close scanner object
    }
}

// Singly linked list class
class SinglyLinkedList{

    Node head; // Head of the linked list

    // Constructor to initialize an empty linked list
    public SinglyLinkedList(){
        this.head = null;
    }

    // Method to insert an element at the beginning of the linked list
    public void insertAtFirst(int element){
        Node n = new Node(element); // Create a new node with the given element
        n.next = head; // Point new node's next to current head
        head = n; // Update head to the new node
    }

    // Method to insert an element at the end of the linked list
    public void insertAtLast(int element){
        Node n = new Node(element , null); // Create a new node with the given element and null next
        if(head == null){
            head = n; // If list is empty, make the new node the head
        } else {
            Node temp = head;
            while(temp.next != null){
                temp = temp.next; // Traverse to the last node
            }
            temp.next = n; // Set next of last node to the new node
        }
    }

    // Method to delete the first element of the linked list
    public void deleteAtFirst(){
        if(head == null || head.next == null){
            head = null; // If list is empty or has only one node, set head to null
        } else {
            head = head.next; // Set head to the next node in the list
        }
    }

    // Method to delete the last element of the linked list
    public void deleteAtLast(){
        if(head == null || head.next == null){
            head = null; // If list is empty or has only one node, set head to null
        } else {
            Node prev = head;
            Node curr = head.next;
            while(prev.next != null){
                prev = curr;
                curr = curr.next; // Traverse to the last node
            }
            prev.next = null; // Set next of second last node to null
        }
    }

    // Method to delete an element at a specified position in the linked list
    public void deleteAtPosition(int position){
        if(head == null){
            System.out.println("---------- LinkedList is Empty ----------");
            return; // If list is empty, print message and return
        }
        
        int size = countNode(); // Get size of the linked list

        if(size < position){
            System.out.println("Invalid Position");
            return; // If position is invalid, print message and return
        }

        if(size == position){
            deleteAtLast(); // If position is last, delete last node
            return;
        }

        Node prev = null;
        Node curr = head;
        int count = 0;
        while(count+1 < position){
            count++;
            prev = curr;
            curr = curr.next; // Traverse to the node before position
        }

        prev.next = curr.next; // Skip the node at given position
    }

    // Method to count nodes in the linked list
    public int countNode(){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next; // Traverse through each node and count
        }
        return size; // Return size of the linked list
    }

    // Method to display all elements of the linked list
    public void display(){
        if(head == null){
            System.out.println("LinkedList is Empty"); // If list is empty, print message
            return;
        }
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " -> "); // Print data of each node
            temp = temp.next; // Traverse to the next node
        }
        System.out.println(temp.data); // Print data of last node
        System.out.println(); // Blank line for formatting
    }
}

// Node class for creating nodes of the linked list
class Node {
    int data; // Data of the node
    Node next; // Reference to the next node

    // Constructor to initialize a node with given data and null next reference
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    // Constructor to initialize a node with given data and next node reference
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
