import java.util.Scanner;

public class Lab11_3 {

    // Method to remove duplicates from the linked list
    public static Node removeDuplicates(Node head){

        Node temp1 = head; // Pointer to iterate through the linked list
        Node temp2; // Pointer to compare with temp1
        Node prev; // Pointer to keep track of the previous node
        
        // Iterate through the linked list with temp1
        while(temp1 != null){
            prev = temp1; // Set prev to temp1 initially
            temp2 = temp1.next; // Start temp2 from the node next to temp1
            
            // Iterate through the rest of the list with temp2
            while(temp2 != null){
                // If duplicate found, remove temp2 from the list
                if(temp1.data == temp2.data){
                    prev.next = temp2.next; // Link prev to temp2.next, effectively removing temp2
                } else {
                    prev = temp2; // Move prev to temp2 for next comparisons
                }
                temp2 = temp2.next; // Move temp2 to the next node
            }
            temp1 = temp1.next; // Move temp1 to the next node for next iteration
        }
        return head; // Return the head of the modified linked list
    }
    
    // Main method to demonstrate and test the functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node dummy = new Node(); // Dummy node to start the linked list
        Node prev = dummy; // Pointer to the previous node for linking new nodes
        Node curr;

        System.out.println("Enter elements of linked list \nEnter -1 for break");
        int x = 0;

        // Reading input elements and creating the linked list
        while(true) {
            x = sc.nextInt();
            if(x == -1) break;
            curr = new Node(x); // Create new node with data x
            prev.next = curr; // Link the previous node to the new node
            prev = curr; // Move prev to the new node
        }

        Node head = dummy.next; // Set head to the start of the linked list
        Node temp = head;

        // Display original linked list
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        head = removeDuplicates(head); // Remove duplicates from the linked list

        temp = head;

        System.out.println();

        // Display linked list after removing duplicates
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
        sc.close(); // Close the scanner object
    }
}
