import java.util.Scanner;

public class Lab13_4 {

    public static CNode[] splitLL(CNode first , CNode last){
        CNode[] heads = new CNode[2];
        
        // If the list is empty
        if(first == null){
            heads[0] = heads[1] = null;
            return heads;
        }
        
        // If there is only one node in the list
        if(first.next == null){
            heads[0] = first;
            heads[0].next = null;
            heads[1] = null;
            return heads;
        }
        
        // Initialize fast and slow pointers for splitting
        CNode fast = first.next.next;
        CNode slow = first.next;
        CNode prev = first;
        
        // Move fast and slow pointers to find the midpoint
        while (fast != first && fast.next != first) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the circular linked list into two halves
        heads[0] = first; // Head of the first half
        prev.next = null; // Break the link to split the list
        heads[1] = slow;  // Head of the second half
        last.next = null; // Break the link to split the list
        
        return heads;
    }

    //display elements of linked list
    public static void display(CNode head){
        if(head == null) return; // If the list is empty, return immediately
        
        CNode temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " -> "); // Print each node's data
            temp = temp.next;
        }
        System.out.println(temp.data); // Print the last node's data
        System.out.println(); // Print a blank line after displaying the list
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of Circular Linked List");
        System.out.println("Enter -1 for break");

        int element;

        CirclularLinkedList cll = new CirclularLinkedList();

        // Read elements from user and insert into circular linked list
        while(true){
            element = sc.nextInt();
            if(element == -1) break;
            cll.insertAtLast(element);
        }

        // Get references to first and last nodes of the circular linked list
        CNode first = cll.first , last = cll.last;

        // Split the circular linked list into two halves
        CNode[] heads = splitLL(first, last);

        // Display the first split linked list
        System.out.println("---------- First Linked List ----------");
        display(heads[0]);

        // Display the second split linked list
        System.out.println("---------- Second Linked List ----------");
        display(heads[1]);

        sc.close(); // Close scanner
    }
}
