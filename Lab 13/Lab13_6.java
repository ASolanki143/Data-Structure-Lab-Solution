import java.util.Scanner;

public class Lab13_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        Polynomial p1 = new Polynomial(); // Create the first polynomial
        Polynomial p2 = new Polynomial(); // Create the second polynomial

        int exponent, coefficient; // Variables to hold the exponent and coefficient
        int x = 1; // Control variable for the while loop

        // Input for the first polynomial
        System.out.println("---------- Enter first polynomial ----------");
        while(x < 2){
            System.out.println("Enter 1 for insert");
            System.out.println("      2 for break");

            x = sc.nextInt(); // Read the user's choice

            switch (x) {
                case 1:
                    System.out.print("Enter coefficient : ");
                    coefficient = sc.nextInt(); // Read the coefficient
                    System.out.print("Enter exponent : ");
                    exponent = sc.nextInt(); // Read the exponent
                    p1.insert(coefficient, exponent); // Insert the term into the first polynomial
                    break;

                default:
                    break; // Exit the loop if the user enters 2
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println();
        
        // Input for the second polynomial
        System.out.println("---------- Enter second polynomial ----------");
        x = 1; // Reset control variable for the second polynomial input

        while(x < 2){
            System.out.println("Enter 1 for insert");
            System.out.println("      2 for break");

            x = sc.nextInt(); // Read the user's choice

            switch (x) {
                case 1:
                    System.out.print("Enter coefficient : ");
                    coefficient = sc.nextInt(); // Read the coefficient
                    System.out.print("Enter exponent : ");
                    exponent = sc.nextInt(); // Read the exponent
                    p2.insert(coefficient, exponent); // Insert the term into the second polynomial
                    break;

                default:
                    break; // Exit the loop if the user enters 2
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println();

        Polynomial sum = new Polynomial(); // Create a polynomial to hold the sum
        sum.sumOfTwo(p1.head, p2.head); // Compute the sum of the two polynomials

        System.out.println("First polynomial equation");
        p1.display(); // Display the first polynomial

        System.out.println("Second polynomial equation");
        p2.display(); // Display the second polynomial

        System.out.println("Sum of two polynomials");
        sum.display(); // Display the sum of the two polynomials
        
        sc.close(); // Close the scanner
    }
}

class Polynomial {
    Node head; // Head node of the polynomial linked list

    public Polynomial() {
        this.head = null; // Initialize the polynomial as empty
    }

    // Method to insert a term into the polynomial
    public void insert(int coefficient, int exponent) {
        Node n = new Node(coefficient, exponent); // Create a new node
        if (head == null) { // If the list is empty, set head to the new node
            head = n;
            n.next = null;
            return;
        }

        if (head.exponent < n.exponent) { // Insert at the beginning if the new node has the highest exponent
            n.next = head;
            head = n;
            return;
        }

        Node temp = head;
        Node prev = null;

        // Traverse the list to find the correct position to insert
        while (temp != null && temp.exponent > n.exponent) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null && temp.exponent == n.exponent) { // If a term with the same exponent exists, add the coefficients
            temp.coefficient += coefficient;
            return;
        }
        // Insert the new node in the correct position
        prev.next = n;
        n.next = temp;
    }

    // Method to sum two polynomials
    public void sumOfTwo(Node p1, Node p2) {
        Node temp1 = p1; // Pointer to traverse the first polynomial
        Node temp2 = p2; // Pointer to traverse the second polynomial

        Node dummy = new Node(); // Dummy node to start the new polynomial
        Node prev = dummy;

        // Traverse both polynomials and add terms
        while (temp1 != null && temp2 != null) {
            Node n = new Node();
            if (temp1.exponent == temp2.exponent) { // If exponents are equal, add coefficients
                n.coefficient = temp1.coefficient + temp2.coefficient;
                n.exponent = temp1.exponent;
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.exponent > temp2.exponent) { // If temp1 has higher exponent, take its term
                n.coefficient = temp1.coefficient;
                n.exponent = temp1.exponent;
                temp1 = temp1.next;
            } else { // If temp2 has higher exponent, take its term
                n.coefficient = temp2.coefficient;
                n.exponent = temp2.exponent;
                temp2 = temp2.next;
            }
            prev.next = n; // Add the new node to the result polynomial
            prev = n;
        }

        // Add remaining terms from the first polynomial
        while (temp1 != null) {
            Node n = new Node(temp1.coefficient, temp1.exponent);
            prev.next = n;
            prev = n;
            temp1 = temp1.next;
        }

        // Add remaining terms from the second polynomial
        while (temp2 != null) {
            Node n = new Node(temp2.coefficient, temp2.exponent);
            prev.next = n;
            prev = n;
            temp2 = temp2.next;
        }

        this.head = dummy.next; // Set the head of the result polynomial
    }

    // Method to display the polynomial
    public void display() {
        Node temp = head;
        char sign;
        sign = (temp.coefficient > 0) ? '+' : '-';
        if(temp.exponent == 0){
            System.out.print(Math.abs(temp.coefficient) +" ");
        }
        else{
            System.out.print(Math.abs(temp.coefficient) + "x^" + temp.exponent + " ");
        }
        temp = temp.next;
        while (temp != null) {
            sign = (temp.coefficient > 0) ? '+' : '-';
            if(temp.exponent == 0){
                System.out.print(sign + " " + Math.abs(temp.coefficient) + " ");
            }
            else{
                System.out.print(sign + " " + Math.abs(temp.coefficient) + "x^" + temp.exponent + " ");
            }
            temp = temp.next;
        }
        
        System.out.println();
    }
}

class Node {
    int coefficient; // Coefficient of the term
    int exponent; // Exponent of the term
    Node next; // Reference to the next node

    public Node() {
        this.coefficient = 0;
        this.exponent = 0;
        this.next = null;
    }

    public Node(int coefficient , int exponent) {
        this();
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
}