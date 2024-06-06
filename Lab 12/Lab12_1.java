import java.util.Scanner;

public class Lab12_1 {
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

        CopyLL c = new CopyLL();

        Node newHead = c.copyLinkedList(ll.head);

        LinkedList copyll = new LinkedList();
        copyll.head = newHead;

        System.out.println("---------- Copy LinkedList ----------");
        copyll.display();

        sc.close();
    }
}

class CopyLL{
    public Node copyLinkedList(Node head){
        if(head == null){
            return null;
        }

        Node dummyNode = new Node();
        Node prev = dummyNode;
        Node temp = head;

        while(temp != null){
            Node n = new Node(temp.data);
            prev.next = n;
            prev = n;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
