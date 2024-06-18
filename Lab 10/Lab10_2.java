import java.util.Scanner;

public class Lab10_2 {

    public static void main(String[] args) {
        Node head = null; // Initialize head of the linked list to null
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList linkedList = new SinglyLinkedList(); // Create instance of SinglyLinkedList class
        int x = 1; // Initialize loop control variable

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
                    head = linkedList.insertAtFirst(head, element1); // Insert at the beginning
                    break;

                case 2:
                    System.out.println("Enter an element : ");
                    int element2 = sc.nextInt(); // Read element to be inserted
                    head = linkedList.insertAtLast(head, element2); // Insert at the end
                    break;

                case 3:
                    head = linkedList.deleteAtFirst(head); // Delete from the beginning
                    break;
            
                case 4:
                    head = linkedList.deleteAtLast(head); // Delete from the end
                    break;

                case 5:
                    System.out.println("Enter position ");
                    int position = sc.nextInt(); // Read position to delete
                    head = linkedList.deleteAtPosition(head, position); // Delete at specified position
                    break;

                case 6:
                    linkedList.display(head); // Display all elements in the linked list
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

    // Method to insert an element at the beginning of the linked list
    public Node insertAtFirst(Node head , int element){
        Node n = new Node(element); // Create a new node with given element
        if(head == null){
            n.next = null; // If list is empty, set next of new node to null
        }
        else{
            n.next = head; // Otherwise, set next of new node to current head
        }
        return n; // Return new head of the linked list
    }

    // Method to insert an element at the end of the linked list
    public Node insertAtLast(Node head , int element){
        Node n = new Node(element , null); // Create a new node with given element and null next
        if(head == null){
            return n; // If list is empty, return the new node as head
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next; // Traverse to the last node
        }

        temp.next = n; // Set next of last node to the new node
        return head; // Return head of the linked list
    }

    // Method to delete the first element of the linked list
    public Node deleteAtFirst(Node head){
        if(head == null || head.next == null){
            return null; // If list is empty or has only one node, return null
        }

        return head.next; // Return the next node as the new head
    }

    // Method to delete the last element of the linked list
    public Node deleteAtLast(Node head){
        if(head == null || head.next == null){
            return null; // If list is empty or has only one node, return null
        }

        Node prev = head;
        Node curr = head.next;
        while(curr.next != null){
            prev = curr;
            curr = curr.next; // Traverse to the last node
        }

        prev.next = null; // Set next of second last node to null
        return head; // Return head of the linked list
    }

    // Method to delete an element at a specified position in the linked list
    public Node deleteAtPosition(Node head , int position){
        if(head == null){
            System.out.println("---------- LinkedList is Empty ----------");
            return null; // If list is empty, print message and return null
        }
        
        int size = countNode(head); // Get size of the linked list

        if(size < position){
            System.out.println("Invalid Position");
            return head; // If position is invalid, print message and return head
        }

        if(size == position){
            return deleteAtLast(head); // If position is last, delete last node
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
        return head; // Return head of the linked list
    }

    // Method to count nodes in the linked list
    public int countNode(Node head){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next; // Traverse through each node and count
        }
        return size; // Return size of the linked list
    }

    // Method to display all elements of the linked list
    public void display(Node head){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " -> "); // Print data of each node
            temp = temp.next; // Traverse to the next node
        }
        System.out.println(temp.data); // Print data of last node
        System.out.println(); // Blank line for formatting
    }
}
