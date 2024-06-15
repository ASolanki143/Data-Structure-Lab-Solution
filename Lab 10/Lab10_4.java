import java.util.Scanner;

// Main class to compare two singly linked lists
public class Lab10_4 {

    static SinglyLinkedList linkedList = new SinglyLinkedList(); // Instance of SinglyLinkedList for operations

    // Method to check if two linked lists are identical
    public static boolean checkLinkedLists(Node head1 , Node head2){
        // If both heads are null, lists are identical
        if(head1 == null && head2 == null){
            return true;
        }

        // If one head is null and other is not, lists are not identical
        if(head1 == null || head2 == null){
            return false;
        }

        // Count nodes in both lists
        int size1 = linkedList.countNode(head1);
        int size2 = linkedList.countNode(head2);

        // If sizes differ, lists are not identical
        if(size1 != size2){
            return false;
        }

        Node temp1 = head1;
        Node temp2 = head2;

        // Traverse both lists and compare each node's data
        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // If all nodes are identical, lists are identical
        return true;
    }

    // Main method to demonstrate the comparison of linked lists
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head1 = null; // Head of first linked list
        Node head2 = null; // Head of second linked list

        // Input elements for the first linked list
        System.out.println("Enter elements of first linkedlist\nEnter -1 for break");
        int x;
        while(true){
            x = sc.nextInt();
            if(x == -1) break;
            head1 = linkedList.insertAtLast(head1, x); // Insert element at the end of the first linked list
        }

        // Input elements for the second linked list
        System.out.println("Enter elements of second linkedlist\nEnter -1 for break");
        while(true){
            x = sc.nextInt();
            if(x == -1) break;
            head2 = linkedList.insertAtLast(head2, x); // Insert element at the end of the second linked list
        }

        sc.close(); // Close scanner object
    }
}
