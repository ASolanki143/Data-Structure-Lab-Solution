import java.util.Scanner;

public class Lab12_4 {
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

        int x ;

        KthNode kn = new KthNode();

        while(true){
            System.out.println("Enter 1 for swap node");
            System.out.println("     -1 for break");

            x = sc.nextInt();

            if(x == 1){
                System.out.println("Enter a k : ");
                int k = sc.nextInt();

                kn.kthNode(ll, k);

                System.out.println();
                System.out.println("---------- After swap node LinkedList ----------");
                ll.display();
            }
            else{
                break;
            }
        }
        
        sc.close();
       
    }
}

class KthNode{

    public void kthNode(LinkedList ll , int k){
        int size = ll.countNode();
        Node temp = ll.head;
        Node firstNode = ll.head;
        Node secondNode = ll.head;
        int count = 0;
        while(temp != null){
            count++;
            
            if(count == k){
                firstNode = temp;
            }
            if(count == size - k + 1){
                secondNode = temp;
            }
            temp = temp.next;
        }
        int val = firstNode.data;
        firstNode.data = secondNode.data;
        secondNode.data = val;

    }
}
