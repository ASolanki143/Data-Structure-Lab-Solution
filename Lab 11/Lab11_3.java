import java.util.Scanner;

public class Lab11_3 {

    public static Node removeDublicates(Node head){

        Node temp1 = head;
        Node temp2;
        Node prev;

        while(temp1 != null){
            prev = temp1;
            temp2 = temp1.next;
            while(temp2 != null){
                if(temp1.data == temp2.data){
                    prev.next = temp2.next;
                }
                else{
                    prev = temp2;
                }
            
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node dummy = new Node();
        Node prev = dummy;
        Node curr;

        System.out.println("Enter elements of linked list \nEnter -1 for break");
        int x = 0;

        while(true)
        {
            x = sc.nextInt();
            if(x == -1) break;
            curr = new Node(x , null);
            prev.next = curr;
            prev = curr;
        }

        Node head = dummy.next;
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        head = removeDublicates(head);

        temp = head;

        System.out.println();

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        sc.close();
    }
}


