import java.util.Scanner;

public class Lab13_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int x = 1;
        int element;

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
                    dll.insertAtFirst(element);
                    break;
            
                case 2:
                    System.out.println("---------- Insert at Last ----------");
                    System.out.println("Enter an element : ");
                    element = sc.nextInt();
                    dll.insertAtLast(element);
                    break;

                case 3:
                    System.out.println("---------- Delete at Position ----------");
                    System.out.println("Enter a position : ");
                    element = sc.nextInt();
                    dll.deleteAtPosition(element);
                    break;

                case 4:
                    System.out.println("---------- Display ----------");
                    dll.display();
                    break;
                
                default:
                    break;
            }
        }

        sc.close();
    }
}
class DoublyLinkedList{
    DNode left;
    DNode right;

    public DoublyLinkedList(){
        this.left = this.right = null;
    }

    public void insertAtFirst(int element){
        DNode n = new DNode(element);
        if(left == null){
            left = right = n;
        }
        else{
            n.rptr = left;
            left.lptr = n;
            left = n;
        }
    }

    public void insertAtLast(int element){
        DNode n = new DNode(element);
        if(left == null){
            left = right = n;
        }
        else{
            right.rptr = n;
            n.lptr = right;
            right = n;
        }
    }

    public void deleteAtPosition(int position){
        if(left == null){
            System.out.println("---------- Empty Linked List ----------");
            return;
        }
        if(position == 1){
            if(left == right){
                left = right = null;
            }
            else{
                left = left.rptr;
                left.lptr = null;
            }
            return;
        }

        int count = 1;
        DNode prev = left;
        DNode temp = left.rptr;

        while(temp != null){
            count++;
            if(count == position){
                prev.rptr = temp.rptr;
                if(temp == right){
                    right = prev;
                    right.rptr = null;
                }
                else{
                    temp.rptr.lptr = temp.lptr;
                }
                return;
            }
            prev = temp;
            temp = temp.rptr;
        }
    }

    public void deleteAlternateNode(){
        if(left == null || left.rptr == null){
            return;
        }
        if(left.rptr.rptr == null){
            left.rptr = null;
            right = left;
            return;
        }

        DNode temp = left;

        while(temp.rptr != null){
            temp.rptr = temp.rptr.rptr;
            if(temp.rptr == null) break;
            temp.rptr.lptr = temp;
            temp = temp.rptr;
        }
    }

    public void display(){
        DNode temp = left;
        while(temp.rptr != null){
            System.out.print(temp.data + " -> ");
            temp = temp.rptr;
        }
        System.out.println(temp.data);
        System.out.println();
    }
}

class DNode{
    int data;
    DNode lptr;
    DNode rptr;

    public DNode(){
        this.data = 0;
        this.lptr = this.rptr = null;
    }

    public DNode(int data){
        this();
        this.data = data;
    }
}
