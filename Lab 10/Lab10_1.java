// Write a program to implement a node structure for singly linked list. Read the data in a node, print the node. 

import java.util.Scanner;

public class Lab10_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node node = new Node();
        System.out.println("Enter a data : ");
        node.data = sc.nextInt();

        node.display();

        sc.close();
    }
}

class Node{
    int data;
    Node next;

    public Node(){
        this.next = null;
    }

    public Node(int data){
        this.data = data;
    }

    public Node(int data , Node next){
        this.data = data;
        this.next = next;
    }

    public void display(){
        System.out.println("Data = "+this.data);
    }
}