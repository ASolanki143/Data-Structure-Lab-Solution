import java.util.Scanner;

public class Lab12_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList(); // Create a new instance of LinkedList

        System.out.println("Enter elements of linked list : ");
        System.out.println("---------- Enter -1 for break ----------");

        int element;

        // Input loop to insert elements into the linked list
        while(true){
            element = sc.nextInt();
            if(element == -1) break; // Break the loop if -1 is entered
            ll.insert(element); // Insert the element into the linked list
        }

        System.out.println();
        System.out.println("---------- Original LinkedList ----------");
        ll.display(); // Display the original linked list

        SwapNode sn = new SwapNode(); // Create an instance of SwapNode to perform node swapping
        sn.swapNode(ll); // Call method to swap nodes in the linked list

        System.out.println();
        System.out.println("----------- After swap nodes ----------");
        ll.display(); // Display the linked list after swapping nodes

        sc.close(); // Close the scanner object
    }
}

// Class SwapNode contains method to swap nodes in a LinkedList
class SwapNode{
    public void swapNode(LinkedList ll){
        Node dummy = new Node(); // Create a dummy node to assist in swapping
        Node curr = ll.head; // Initialize current node to the head of the linked list
        Node prev = dummy; // Initialize previous node to the dummy node
        Node save = curr.next; // Save the next node of current node

        // Loop through the linked list and swap pairs of nodes
        while(save != null && save.next != null){
            curr.next = save.next; // Adjust current node's next to skip to next pair
            save.next = curr; // Reverse the direction of the saved node
            prev.next = save; // Link previous node to the swapped pair

            // Move to the next pair of nodes
            prev = curr;
            curr = curr.next;
            if(curr != null)
                save = curr.next;
        }

        // Connect the remaining nodes after swapping
        curr.next = save; // Connect the last pair (if any)
        prev.next = save; // Connect the last swapped pair to the previous node

        ll.head = dummy.next; // Update the head of the linked list
    }
}