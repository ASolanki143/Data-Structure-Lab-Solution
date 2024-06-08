import java.util.Scanner;

public class Lab13_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        int exponent , coefficient;
        int x = 1;

        System.out.println("---------- Enter first polynomial ----------");
        while(x < 2){
            System.out.println("Enter 1 for insert");
            System.out.println("      2 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.print("Enter coefficient : ");
                    coefficient = sc.nextInt();
                    System.out.print("Enter exponent : ");
                    exponent = sc.nextInt();
                    p1.insert(coefficient, exponent);
                    break;

                default:
                    break;
            }
        }

        
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("---------- Enter second polynomial ----------");

        x = 1;

        while(x < 2){
            System.out.println("Enter 1 for insert");
            System.out.println("      2 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.print("Enter coefficient : ");
                    coefficient = sc.nextInt();
                    System.out.print("Enter exponent : ");
                    exponent = sc.nextInt();
                    p2.insert(coefficient, exponent);
                    break;

                default:
                    break;
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println();

        Polynomial sum = new Polynomial();
        sum.sumOfTwo(p1.head, p2.head);

        System.out.println("First polynomial equation");
        p1.display();

        System.out.println("Second polynomial equation");
        p2.display();

        System.out.println("Sum of two polynomial ");
        sum.display();
        sc.close();
    }
}

class Polynomial{
    Node head;

    public Polynomial(){
        this.head = null;
    }

    public void insert(int coefficient , int exponent){
        Node n = new Node(coefficient, exponent);
        if(head == null){
            head = n;
            n.next = null;
            return;
        }

        if(head.exponent < n.exponent){
            n.next = head;
            head = n;
            return;
        }

        Node temp = head;
        Node prev = null;

        while(temp != null && temp.exponent > n.exponent){
            prev = temp;
            temp = temp.next;
        }
        if(temp != null && temp.exponent == n.exponent){
            temp.exponent = exponent;
            temp.coefficient += coefficient;
            return;
        }
        prev.next = n;
        n.next = temp;
    }

    public void sumOfTwo(Node p1 , Node p2){
        Node temp1 = p1;
        Node temp2 = p2;

        Node dummy = new Node();
        Node prev = dummy;

        while(temp1 != null && temp2 != null){
            Node n = new Node();
            if(temp1.exponent == temp2.exponent){
                n.coefficient = temp1.coefficient + temp2.coefficient;
                n.exponent = temp1.exponent;
                temp1 = temp1.next;
                temp2 =temp2.next;
            }
            else if(temp1.exponent > temp2.exponent){
                n.coefficient = temp1.coefficient;
                n.exponent = temp1.exponent;
                temp1 = temp1.next;
            }
            else{
                n.coefficient = temp2.coefficient;
                n.exponent = temp2.exponent;
                temp2 = temp2.next;
            }
            prev.next = n;
            prev = n;
        }

        while(temp1 != null){
            Node n = new Node(temp1.coefficient, temp1.exponent);
            prev.next = n;
            prev = n;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            Node n = new Node(temp2.coefficient, temp2.exponent);
            prev.next = n;
            prev = n;
            temp2 = temp2.next;
        }

        this.head = dummy.next;
    }

    public void display(){
        Node temp = head;
        while(temp.next != null){
            char sign = (temp.next.coefficient > 0) ? '+' : '-';
            System.out.print(temp.coefficient+"x^"+temp.exponent + " " +sign + " ");
            temp = temp.next;
        }
        System.out.println(temp.coefficient+"x^"+temp.exponent + " ");
        System.out.println();
    }
}

class Node{
    int coefficient;
    int exponent;
    Node next;

    public Node(){
        this.coefficient = 0;
        this.exponent = 0;
        this.next = null;
    }

    public Node(int coefficient , int exponent){
        this();
        this.coefficient= coefficient;
        this.exponent = exponent;
    }
}
