import java.util.Scanner;

public class Lab12_5 {
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

        AddGCD aGcd = new AddGCD(); // Create an instance of AddGCD to calculate and add GCD nodes
        aGcd.addGCD(ll); // Call method to add GCD nodes to the linked list

        System.out.println();
        System.out.println("---------- After add GCD ----------");
        ll.display(); // Display the linked list after adding GCD nodes

        sc.close(); // Close the scanner object
    }
}

// Class AddGCD contains methods to find GCD and add GCD nodes to a LinkedList
class AddGCD{

    // Method to find the greatest common divisor (GCD) of two numbers
    public int findGCD(int a , int b){
        int min = Math.min(a, b);
        for(int i = min ; i > 1 ; i--){
            if(a % i == 0 && b % i == 0){
                return i; // Return the GCD if found
            }
        }
        return 1; // Return 1 if no common divisor greater than 1 is found
    }

    // Method to add GCD nodes between existing nodes in the LinkedList
    public void addGCD(LinkedList ll){
        Node temp = ll.head; // Start from the head of the linked list
        while(temp.next != null){
            int gcd = findGCD(temp.data, temp.next.data); // Calculate GCD of current node and next node
            Node n = new Node(gcd); // Create a new node with the GCD value
            n.next = temp.next; // Link the new node to the next node
            temp.next = n; // Link current node to the new GCD node
            temp = temp.next.next; // Move to the node after the newly added GCD node
        }
    }
}