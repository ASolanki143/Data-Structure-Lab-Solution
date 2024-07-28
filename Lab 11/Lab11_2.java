import java.util.Scanner;

public class Lab11_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;

        Queue q = new Queue(); // Create a Queue object

        // Menu-driven loop for queue operations
        while(x < 4){
            System.out.println("Enter 1 for insert : ");
            System.out.println("      2 for delete");
            System.out.println("      3 for display");
            System.out.println("      4 for break");

            x = sc.nextInt(); // Read user input for operation choice

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element = sc.nextInt();
                    q.enqueue(element); // Call enqueue operation on the queue
                    break;
                
                case 2:
                    int y = q.dequeue(); // Call dequeue operation on the queue
                    if(y > -1){
                        System.out.println("---------- "+y+" is deleted ----------");
                    }
                    break;
                
                case 3:
                    q.display(); // Call display operation on the queue
                    break;
            
                default:
                    break;
            }
        }

        sc.close(); // Close scanner object
    }
}

// Queue class to implement queue operations
class Queue{
    Node front; // Pointer to the front of the queue
    Node rear; // Pointer to the rear of the queue

    // Constructor to initialize an empty queue
    public Queue(){
        front = null;
        rear = null;
    }

    // Method to enqueue (insert) an element into the queue
    public void enqueue(int element){
        Node n = new Node(element);
        if(front == null){
            front = n;
            rear = n;
            return;
        }
        rear.next = n;
        rear = n; // Update rear to point to the newly added node
    }

    // Method to dequeue (delete) an element from the queue
    public int dequeue(){
        if(front == null){
            System.out.println("--------- Queue is Empty ----------");
            return -1;
        }
        int y = front.data; // Store the data of the front node to be dequeued
        if(front.next == null){
            front = rear = null; // Reset the queue pointers if there was only one element
        }
        else{
            front = front.next; // Move front pointer to the next node
        }

        return y; // Return the dequeued element
    }

    // Method to display all elements in the queue
    public void display(){
        if(front == null){
            System.out.println("---------- Queue is Empty ----------");
            return;
        }
        Node temp = front;
        while(temp != rear){
            System.out.print(temp.data + " -> ");
            temp = temp.next; // Traverse to the next node in the queue
        }
        System.out.println(temp.data); // Print the last node's data
        System.out.println();
    }
}
