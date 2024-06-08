import java.util.Scanner;

public class Lab13_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        int element;

        CirclularLinkedList cll = new CirclularLinkedList();

        while(x < 5){
            System.out.println("Enter 1 for insert at first");
            System.out.println("      2 for insert at last");
            System.out.println("      3 for delete at positon");
            System.out.println("      4 for display");
            System.out.println("      5 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("---------- Insert at First ----------");
                    System.out.println("Enter an element : ");
                    element = sc.nextInt();
                    cll.insertAtFirst(element);
                    break;
            
                case 2:
                    System.out.println("---------- Insert at Last ----------");
                    System.out.println("Enter an element : ");
                    element = sc.nextInt();
                    cll.insertAtLast(element);
                    break;

                case 3:
                    System.out.println("---------- Delete at Position ----------");
                    System.out.println("Enter a position : ");
                    element = sc.nextInt();
                    cll.deleteAtPosition(element);
                    break;

                case 4:
                    System.out.println("---------- Display ----------");
                    cll.display();
                    break;
                
                default:
                    break;
            }
        }

        sc.close();
    }
}

class CirclularLinkedList{
    CNode first;
    CNode last;

    public CirclularLinkedList(){
        first = last = null;
    }

    public void insertAtFirst(int element){
        CNode n = new CNode(element);
        if(first == null){
            first = last = n;
        }
        else{
            n.next = first;
            last.next = n;
            first = n;
        }
    }

    public void insertAtLast(int element){
        CNode n = new CNode(element);
        if(first == null){
            first = last = n;
        }
        else{
            n.next = first;
            last.next = n;
            last = n;
        }
    }

    public void deleteAtPosition(int position){
        if(first == null) {
            System.out.println("---------- Empty Linked List ----------");
            return;
        }
        if(position == 1){
            if(first == last){
                first = last = null;
            }
            else{
                first = first.next;
                last.next = first;
            }
        }
        int count = 1;
        CNode temp = first.next;
        CNode prev = first;
        while(temp != first){
            count++;
            if(count == position){
                prev.next = temp.next;
                if(temp == last){
                    last = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void display(){
        CNode temp = first;
        while(temp.next != first){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println();
    }
}

class CNode{
    int data;
    CNode next;

    public CNode(){
        this.data = 0;
        this.next = null;
    }

    public CNode(int data){
        this();
        this.data = data;
    }

    public CNode(int data , CNode next){
        this.data = data;
        this.next = next;
    }
}
