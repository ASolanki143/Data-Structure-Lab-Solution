import java.util.Scanner;

public class Lab10_4 {

    static SinglyLinkedList linkedList = new SinglyLinkedList();

    public static boolean checkLinkedLists(Node head1 , Node head2){
        if(head1 == null && head2 == null){
            return true;
        }

        if(head1 == null) return false;
        if(head2 == null) return false;

        int size1 = linkedList.countNode(head1);
        int size2 = linkedList.countNode(head2);

        if(size1 != size2) return false;

        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head1 = null;
        Node head2 = null;

        System.out.println("Enter elements of first linkedlist\nEnter -1 for break");

        int x;
        while(true){
            x = sc.nextInt();
            if(x == -1) break;
            head1 = linkedList.insertAtLast(head1, x);
        }

        System.out.println("Enter elements of second linkedlist\nEnter -1 for break");

        while(true){
            x = sc.nextInt();
            if(x == -1) break;
            head2 = linkedList.insertAtLast(head2, x);
        }

        sc.close();
    }
}
