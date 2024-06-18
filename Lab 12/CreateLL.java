public class CreateLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Creating an instance of LinkedList

        // Example operations on LinkedList
        ll.insert(10); // Inserting elements
        ll.insert(20);
        ll.insert(30);

        System.out.println("---------- Displaying LinkedList ----------");
        ll.display(); // Displaying elements

        int nodeCount = ll.countNode(); // Counting nodes
        System.out.println("Number of nodes: " + nodeCount);
    }
}

// Class representing a linked list
class LinkedList {
    Node head; // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        head = null;
    }

    // Method to insert a new node at the end of the linked list
    public void insert(int element) {
        Node n = new Node(element); // Creating a new node with the given data
        if (head == null) {
            head = n; // If the list is empty, new node becomes the head
            return;
        }

        Node temp = head;

        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n; // Link the last node to the new node
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("---------- Empty LinkedList ----------");
            return;
        }

        Node temp = head;

        // Traverse and print each node's data
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println(temp.data); // Print the last node's data
        System.out.println();
    }

    // Method to count the number of nodes in the linked list
    public int countNode() {
        if (head == null)
            return 0; // If the list is empty, return 0

        int count = 0;
        Node temp = head;

        // Traverse the list and count each node
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}

// Class representing a node in the linked list
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the linked list

    // Constructors
    public Node() {
        next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
