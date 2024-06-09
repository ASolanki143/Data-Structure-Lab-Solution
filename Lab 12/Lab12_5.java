import java.util.Scanner;

public class Lab12_5 {
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

        AddGCD aGcd = new AddGCD();
        aGcd.addGCD(ll);

        System.out.println();
        System.out.println("---------- After add GCD ----------");
        ll.display();

        sc.close();
    }
}

class AddGCD{

    public int findGCD(int a , int b){

        int min = Math.min(a, b);
        for(int i = min ; i > 1 ; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }

    public void addGCD(LinkedList ll){
        Node temp = ll.head;
        while(temp.next != null){
            int gcd = findGCD(temp.data, temp.next.data);
            Node n = new Node(gcd);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }
    }
}
