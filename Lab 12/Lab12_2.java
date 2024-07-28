import java.util.Scanner;

public class Lab12_2 {
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

        ReverseLL r = new ReverseLL(); // Creating an instance of ReverseLL

        // Reversing the linked list
        Node newHead =  r.reverseLinkedList(ll.head); // Calling reverseLinkedList method

        LinkedList reversell = new LinkedList();
        reversell.head = newHead;

        // Displaying reversed linked list
        System.out.println("---------- Reverse LinkedList ----------");
        reversell.display();

        sc.close(); // Closing Scanner object
    }
}

// Class to handle operations on linked list
class ReverseLL {
    // Method to reverse a linked list
    public Node reverseLinkedList(Node head) {
        // If the list is empty or has only one node, return the head as it is already reversed
        if(head == null || head.next == null) return head;

        Node prevNode = null; // Pointer to the previous node in the reversed list
        Node currNode = head; // Pointer to the current node in the original list
        Node nextNode = head; // Pointer to the next node in the original list

        // Traverse through the original list and reverse the pointers
        while(currNode != null){
            nextNode = nextNode.next; // Move nextNode to the next node in the original list
            currNode.next = prevNode; // Reverse the pointer to point backwards
            prevNode = currNode; // Move prevNode to currNode
            currNode = nextNode; // Move currNode to nextNode
        }

        // Handle the last node in the list

        return prevNode; // Return the new head of the reversed list
    }
}


