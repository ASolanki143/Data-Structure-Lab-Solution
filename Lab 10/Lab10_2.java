import java.util.Scanner;

public class Lab10_2 {

    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int x = 1;

        while(x < 7){
            System.out.println("Enter 1 for insert at first");
            System.out.println("      2 for insert at end");
            System.out.println("      3 for delete at first");
            System.out.println("      4 for delete at last");
            System.out.println("      5 for delete at position");
            System.out.println("      6 for display");
            System.out.println("      7 for break");
            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element1 = sc.nextInt();
                    head = linkedList.insertAtFirst(head, element1);
                    break;

                case 2:
                    System.out.println("Enter an element : ");
                    int element2 = sc.nextInt();
                    head = linkedList.insertAtLast(head, element2);
                    break;

                case 3:
                    head = linkedList.deleteAtFirst(head);
                    break;
            
                case 4:
                    head = linkedList.deleteAtLast(head);
                    break;

                case 5:
                    System.out.println("Enter position ");
                    int position = sc.nextInt();
                    head = linkedList.deleteAtPosition(head, position);
                    break;

                case 6:
                    linkedList.display(head);
                    break;

                default:
                    break;
            }
        }

        sc.close();

    }
}

class SinglyLinkedList{

    public Node insertAtFirst(Node head , int element){
        Node n = new Node(element);
        if(head == null){
            n.next = null;
        }
        else{
            n.next = head;
        }
        return n;
    }

    public Node insertAtLast(Node head , int element){
        Node n = new Node(element , null);
        if(head == null){
            return n;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = n;
        return head;
    }

    public Node deleteAtFirst(Node head){
        if(head == null || head.next == null){
            return null;
        }

        return head.next;
    }

    public Node deleteAtLast(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node prev = head;
        Node curr = head.next;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        return head;
    }

    public Node deleteAtPosition(Node head , int position){
        if(head == null){
            System.out.println("---------- LinkedList is Empty ----------");
            return null;
        }
        
        int size = countNode(head);

        System.out.println("size ======= "+size);
        if(size < position){
            System.out.println("Invalid Position");
            return head;
        }

        if(size == position){
            return deleteAtLast(head);
        }

        Node prev = null;
        Node curr = head;
        int count = 0;
        while(count+1 < position){
            count++;
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        return head;
    }

    public int countNode(Node head){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void display(Node head){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println();
    }
}