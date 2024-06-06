//Write a program to reverse a linked list. 

import java.util.Scanner;

public class Lab12_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        System.out.println("Enter elements of linked list : ");
        System.out.println("---------- Enter -1 for break ----------");

        int element;

        while(true){
            element = sc.nextInt();
            if(element == -1) break;
            ll.insert(element);
        }

        System.out.println();
        System.out.println("---------- Original LinkedList ----------");
        ll.display();

        ReverseLL r = new ReverseLL();
        Node newHead =  r.reverseLinkedList(ll.head);

        LinkedList reversell = new LinkedList();
        reversell.head = newHead;

        System.out.println("---------- Reverse LinkedList ----------");
        reversell.display();

        sc.close();

    }
}

class ReverseLL{

    public Node reverseLinkedList(Node head){
        if(head == null || head.next == null) return head;
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = head.next;

        while(nextNode != null){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }

        currNode.next = prevNode;

        return currNode;
    }
}
