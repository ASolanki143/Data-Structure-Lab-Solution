//Write a program to sort elements of a linked list

import java.util.Scanner;

public class Lab12_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        System.out.println("Enter elements of linked list : ");
        System.out.println("---------- Enter -1 for break ----------");

        int element;

        while (true) {
            element = sc.nextInt();
            if (element == -1)
                break;
            ll.insert(element);
        }

        System.out.println();
        System.out.println("---------- Original LinkedList ----------");
        ll.display();

        SortLL s = new SortLL();
        s.sortLinkedList(ll.head);

        System.out.println("---------- After Sort -----------");
        ll.display();

        sc.close();
    }
}

class SortLL {

    public void sortLinkedList(Node head) {
        Node p, temp; // Declare two node pointers, p and temp
        int b; 

        p = head; // Start with the head of the linked list

        // Outer loop to traverse each node starting from the head
        while (p != null) {
            temp = p.next; // Assign temp to the next node of p

            // Inner loop to compare p with each subsequent node
            while (temp != null) {
                // Swap data if the current node (p) has greater data than the next node (temp)
                if (p.data > temp.data) {
                    b = p.data; // Store p.data in b
                    p.data = temp.data; // Replace p.data with temp.data
                    temp.data = b; // Replace temp.data with b (original p.data)
                }
                temp = temp.next; // Move to the next node in the inner loop
            }
            p = p.next; // Move to the next node in the outer loop
        }
    }

}