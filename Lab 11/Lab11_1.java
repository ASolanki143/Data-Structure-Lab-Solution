import java.util.Scanner;

public class Lab11_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack(); // Create a Stack object

        int x = 1;

        // Menu-driven loop for stack operations
        while(x < 6){
            System.out.println("Enter 1 for push");
            System.out.println("      2 for pop");
            System.out.println("      3 for peep");
            System.out.println("      4 for change");
            System.out.println("      5 for display");
            System.out.println("      6 for break");

            x = sc.nextInt(); // Read user input for operation choice

            switch (x) {
                case 1:
                    System.out.println("Enter an element");
                    int element = sc.nextInt();
                    s.push(element); // Call push operation on the stack
                    break;
            
                case 2:
                    int y = s.pop(); // Call pop operation on the stack
                    if(y > -1){
                        System.out.println("---------- "+y+" is deleted ----------");
                    }
                    break;

                case 3:
                    System.out.println("Enter a position");
                    int position = sc.nextInt();
                    int n = s.peep(position); // Call peep operation on the stack
                    if(n > -1){
                        System.out.println("---------- Element is "+n+ " ----------");
                    }
                    break;

                case 4:
                    System.out.println("Enter a position");
                    int position1 = sc.nextInt();
                    System.out.println("Enter element ");
                    int element1 = sc.nextInt();
                    s.change(position1, element1); // Call change operation on the stack
                    break;

                case 5:
                    s.display(); // Call display operation on the stack
                    break;

                default:
                    break;
            }
        }
        sc.close(); // Close scanner object
    }
}

// Stack class to implement stack operations
class Stack{
    Node first; // Pointer to the first node in the stack
    Node top; // Pointer to the top of the stack

    // Constructor to initialize the stack
    public Stack(){
        this.first = null;
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int element){
        Node n = new Node(element , null);
        top = n; // Update top to point to the newly pushed node
        if(first == null){
            first = n; // If stack is empty, set first to point to the new node
            return;
        }
        Node temp = first;
        while(temp.next != null){
            temp = temp.next; // Traverse to the end of the stack
        }
        temp.next = n; // Link the new node at the end of the stack
    }

    // Method to pop an element from the stack
    public int pop(){
        if(first == null){
            System.out.println("---------- Stack is Empty -----------");
            return -1;
        }

        Node prev = first;
        Node curr = first.next;
        while(curr.next != null){
            prev = curr;
            curr = curr.next; // Traverse to the end of the stack
        }
        int y = curr.data; // Store the data of the node to be popped
        top = prev; // Update top to point to the new top of the stack
        prev.next = null; // Remove the last node from the stack
        return y; // Return the popped element
    }

    // Method to peep (view) an element at a specific position in the stack
    public int peep(int position){
        if(first == null){
            System.out.println("---------- Stack is Empty -----------");
            return -1;
        }

        int size = countNode();
        if(position > size){
            System.out.println("---------- Invalid Position ----------");
            return -1;
        }

        if(position == 1) return top.data; // Return the top element of the stack
        if(position == size) return first.data; // Return the bottom element of the stack

        Node temp = first;
        int count = 0;

        // Traverse to the node at the specified position from the bottom of the stack
        while(count < size - position){
            count++;
            temp = temp.next;
        }

        return temp.data; // Return the data of the node at the specified position
    }

    // Method to change the element at a specific position in the stack
    public void change(int position , int element){
        if(first == null){
            System.out.println("---------- Stack is Empty -----------");
            return;
        }

        int size = countNode();
    
        if(position > size){
            System.out.println("---------- Invalid Position ----------");
            return;
        }

        if(position == 1) {
            first.data = element; // Change the data of the first node
            return;
        }
        if(position == size) {
            top.data = element; // Change the data of the top node
            return;
        }

        Node temp = first;
        int count = 0;

        // Traverse to the node at the specified position from the bottom of the stack
        while(count < size - position){
            count++;
            temp = temp.next;
        }

        temp.data = element; // Change the data of the node at the specified position
        return;
    }

    // Method to display all elements in the stack
    public void display(){
        Node temp = first;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to count the number of nodes in the stack
    public int countNode(){
        if(first == null) return 0;
        Node temp = first;
        int count = 1;
        while(temp != top){
            count++;
            temp = temp.next; // Traverse to the next node
        }
        return count; // Return the count of nodes
    }
}

// Node class to represent a node in the stack
class Node{
    int data; // Data of the node
    Node next; // Reference to the next node

    // Constructors
    public Node(){
        this.data = 0;
        this.next = null;
    }

    public Node(int data){
        this.data = data;
    }

    public Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
}
