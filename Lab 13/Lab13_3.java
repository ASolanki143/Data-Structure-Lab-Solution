import java.util.Scanner;

public class Lab13_3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int x = 1;
        int element;

        while(x < 5){
            System.out.println("Enter 1 for insert at first");
            System.out.println("      2 for insert at last");
            System.out.println("      3 for delete atlernate");
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
                    System.out.println("---------- Delete atternate node ----------");
                    dll.deleteAlternateNode();
                    dll.display();
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