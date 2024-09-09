import java.util.Scanner;

public class Lab12_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        // Prompt user to enter elements of linked list
        System.out.println("Enter elements of linked list:");
        System.out.println("---------- Enter -1 to stop ----------");

        int element;

        // Read elements until -1 is entered
        while(true){
            element = sc.nextInt();
            if(element == -1) break;
            ll.insert(element);
        }

        System.out.println();
        System.out.println("---------- Original LinkedList ----------");
        ll.display(); // Display original linked list

        RemoveDuplicate rd = new RemoveDuplicate();
        rd.removeDuplicate(ll); // Remove duplicates from linked list
        
        System.out.println();
        System.out.println("----------- After deleting duplicates -----------");
        ll.display(); // Display linked list after removing duplicates

        sc.close();
    }
}

class RemoveDuplicate {
    // Method to remove duplicates from a linked list
    public void removeDuplicate(LinkedList ll) {
        Node prev = ll.head;
        Node temp = prev.next;

        // Iterate through the linked list
        while (temp != null) {
            Node save = temp;
            // Remove nodes with duplicate data
            while (save != null && prev.data == save.data) {
                save = save.next;
            }
            prev.next = save; // Update the next pointer of previous node
            prev = save;
            if (save == null) break;
            temp = save;
        }
    }
}
