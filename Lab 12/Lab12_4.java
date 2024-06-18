import java.util.Scanner;

public class Lab12_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList(); // Create a new instance of LinkedList

        System.out.println("Enter elements of linked list : ");
        System.out.println("---------- Enter -1 for break ----------");

        int element;

        // Input loop to insert elements into the linked list
        while (true) {
            element = sc.nextInt();
            if (element == -1)
                break; // Break the loop if -1 is entered
            ll.insert(element); // Insert the element into the linked list
        }

        System.out.println();
        System.out.println("---------- Original LinkedList ----------");
        ll.display(); // Display the original linked list

        int x;

        KthNode kn = new KthNode(); // Create an instance of KthNode for swapping nodes

        // Menu loop to perform operations on the linked list
        while (true) {
            System.out.println("Enter 1 for swap node");
            System.out.println("     -1 for break");

            x = sc.nextInt();

            if (x == 1) {
                System.out.println("Enter a k : ");
                int k = sc.nextInt();

                kn.kthNode(ll, k); // Call method to swap kth nodes

                System.out.println();
                System.out.println("---------- After swap node LinkedList ----------");
                ll.display(); // Display the linked list after swapping nodes
            } else {
                break; // Break the loop if -1 is entered
            }
        }

        sc.close(); // Close the scanner object
    }
}

// Class KthNode contains method to swap kth nodes in a LinkedList
class KthNode {

    public void kthNode(LinkedList ll, int k) {
        int size = ll.countNode(); // Get the size of the linked list
        Node temp = ll.head; // Initialize temporary node to traverse the linked list
        Node firstNode = ll.head; // Initialize first node to be swapped
        Node secondNode = ll.head; // Initialize second node to be swapped
        int count = 0;

        // Traverse the linked list to find the kth and (size-k+1)th nodes
        while (temp != null) {
            count++;

            if (count == k) {
                firstNode = temp; // Store kth node
            }
            if (count == size - k + 1) {
                secondNode = temp; // Store (size-k+1)th node
            }
            temp = temp.next; // Move to the next node
        }

        // Swap the data of kth and (size-k+1)th nodes
        int val = firstNode.data;
        firstNode.data = secondNode.data;
        secondNode.data = val;

    }
}