import java.util.Scanner;

public class Lab12_6 {
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

        SwapNode sn = new SwapNode();
        sn.swapNode(ll);

        System.out.println();
        System.out.println("----------- After swap nodes ----------");
        ll.display();

        sc.close();
    }
}

class SwapNode{
    public void swapNode(LinkedList ll){
        Node dummy = new Node();
        Node curr = ll.head;
        Node prev = dummy;
        Node save = curr.next;

        while(save.next != null && save.next.next != null){
            curr.next = save.next;
            save.next = curr;
            prev.next = save;

            prev = curr;
            curr = curr.next;
            save = curr.next;
        }
        curr.next = save.next;
        save.next = curr;
        prev.next = save;

        ll.head = dummy.next;
    }
}
