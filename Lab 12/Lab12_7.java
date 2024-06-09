import java.util.Scanner;

public class Lab12_7 {
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

        RemoveDuplicate rd = new RemoveDuplicate();
        rd.removeDuplicate(ll);
        
        System.out.println();
        System.out.println("----------- After delete dublicte element -----------");
        ll.display();

        sc.close();
    }
}

class RemoveDuplicate{
    public void removeDuplicate(LinkedList ll){
        Node prev = ll.head;
        Node temp = prev.next;

        while(temp != null){
            Node save = temp;
            while(save != null && prev.data == save.data){
                save = save.next;
            }
            prev.next = save;
            prev = save;
            if(save == null) break;
            temp = save;
        }
    }
}
