//Write a program to sort elements of a linked list

import java.util.Scanner;

public class Lab12_3{
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

        SortLL s = new SortLL();
        s.sortLinkedList(ll.head);

        System.out.println("---------- After Sort -----------");
        ll.display();

        sc.close();
    }
}

class SortLL{
    public void sortLinkedList(Node head){
        Node p , temp;
        int b;
        p = head;
        while (p!=null) {
            temp = p.next;
            while (temp!=null) {
                if (p.data > temp.data) {
                    b = p.data;
                    p.data = temp.data;
                    temp.data = b;
                }
                temp = temp.next;
            }
            p = p.next;
        }
    }
}