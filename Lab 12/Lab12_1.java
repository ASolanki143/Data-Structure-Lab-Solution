import java.util.Scanner;

public class Lab12_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList(); // Creating an instance of LinkedList

        // Prompting user to enter elements for the linked list
        System.out.println("Enter elements of linked list : ");
        System.out.println("---------- Enter -1 for break ----------");

        int element;

        // Reading user input and inserting elements into the linked list
        while(true){
            element = sc.nextInt();
            if(element == -1) break;
            ll.insert(element);
        }

        // Displaying original linked list
        System.out.println();
        System.out.println("---------- Original LinkedList ----------");
        ll.display();

        CopyLL c = new CopyLL(); // Creating an instance of CopyLL

        // Copying the linked list
        Node newHead = c.copyLinkedList(ll.head); // Calling copyLinkedList method

        LinkedList copyll = new LinkedList();
        copyll.head = newHead;

        // Displaying copied linked list
        System.out.println("---------- Copy LinkedList ----------");
        copyll.display();

        sc.close(); // Closing Scanner object
    }
}

// Class to handle operations on linked list
class CopyLL {
    // Method to copy a linked list
    public Node copyLinkedList(Node head) {
        if(head == null){
            return null;
        }

        Node dummyNode = new Node(); // Dummy node to start the copied linked list
        Node prev = dummyNode; // Pointer to the previous node in the copied list
        Node temp = head; // Pointer to traverse the original linked list

        // Traverse the original linked list and create a copy node for each element
        while(temp != null){
            Node n = new Node(temp.data); // Create a new node with data from original list
            prev.next = n; // Link the previous node to the new node
            prev = n; // Move prev to the new node
            temp = temp.next; // Move temp to the next node in the original list
        }

        return dummyNode.next; // Return the head of the copied linked list (skip dummyNode)
    }
}
