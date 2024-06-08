import java.util.Scanner;

public class Lab13_4 {

    public static CNode[] splitLL(CNode first , CNode last){
        CNode[] heads = new CNode[2];
        if(first == null){
            heads[0] = heads[1] = null;
            return heads;
        }
        if(first.next == null){
            heads[0] = first;
            heads[0].next = null;
            heads[1] = null;
            return heads;
        }
        // if(first.next == last){
        //     heads[0] = first;
        //     heads[0].next = null;
        //     heads[1] = last;
        //     heads[1].next = null;
        //     return heads;
        // }
        CNode fast = first.next.next;
        CNode slow = first.next;
        CNode prev = first;
        while (fast != first && fast.next != first) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        heads[0] = first;
        prev.next = null;
        heads[1] = slow;
        last.next = null;
        return heads;
    }

    public static void display(CNode head){
        if(head == null) return;
        CNode temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of Circular Linked List");
        System.out.println("Enter -1 for break");

        int element;

        CirclularLinkedList cll = new CirclularLinkedList();

        while(true){
            element = sc.nextInt();
            if(element == -1) break;
            cll.insertAtLast(element);
        }

        CNode first = cll.first , last = cll.last;

        CNode[] heads = splitLL(first, last);

        System.out.println("---------- First Linked List ----------");
        display(heads[0]);
        System.out.println("---------- Second Linked List ----------");
        display(heads[1]);

        sc.close();
    }
}
