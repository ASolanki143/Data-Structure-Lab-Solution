import java.util.Scanner;

public class Lab10_4 {

    static SinglyLinkedList linkedList = new SinglyLinkedList(); // Instance of SinglyLinkedList for operations

    // Method to check if two linked lists are identical
    public static boolean checkLinkedLists(SinglyLinkedList ll1 , SinglyLinkedList ll2){
        // If both heads are null, lists are identical
        if(ll1.head == null && ll2.head == null){
            return true;
        }

        // If one head is null and other is not, lists are not identical
        if(ll1.head == null || ll2.head == null){
            return false;
        }

        // Count nodes in both lists
        int size1 = ll1.countNode();
        int size2 = ll2.countNode();

        // If sizes differ, lists are not identical
        if(size1 != size2){
            return false;
        }

        Node temp1 = ll1.head;
        Node temp2 = ll2.head;

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
        
        SinglyLinkedList ll1 = new SinglyLinkedList();
        SinglyLinkedList ll2 = new SinglyLinkedList();
        // Input elements for the first linked list
        System.out.println("Enter elements of first linkedlist\nEnter -1 for break");
        int x;
        while(true){
            x = sc.nextInt();
            if(x == -1) break;
            ll1.insertAtLast(x); // Insert element at the end of the first linked list
        }

        // Input elements for the second linked list
        System.out.println("Enter elements of second linkedlist\nEnter -1 for break");
        while(true){
            x = sc.nextInt();
            if(x == -1) break;
            ll2.insertAtLast(x); // Insert element at the end of the second linked list
        }

        if(checkLinkedLists(ll1, ll2)){
            System.out.println("Both Linked List are same");
        }
        else{
            System.out.println("Both Linked List are not same");
        }
        
        sc.close(); // Close scanner object
    }
}
