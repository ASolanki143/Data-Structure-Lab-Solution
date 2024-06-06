import java.util.Scanner;

public class Lab11_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;

        Queue q = new Queue();

        while(x < 4){
            System.out.println("Enter 1 for insert : ");
            System.out.println("      2 for delete");
            System.out.println("      3 for display");
            System.out.println("      4 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element = sc.nextInt();
                    q.enqueue(element);
                    break;
                
                case 2:
                    int y = q.dequeue();
                    if(y > -1){
                        System.out.println("---------- "+y+" is deleted ----------");
                    }
                    break;
                
                case 3:
                    q.display();
            
                default:
                    break;
            }
        }

        sc.close();
    }
}

class Queue{
    Node front;
    Node rear;

    public Queue(){
        front = null;
        rear = null;
    }

    public void enqueue(int element){
        Node n = new Node(element , null);
        if(front == null){
            front = n;
            rear = n;
            return;
        }
        rear.next = n;
        rear = n;    
    }

    public int dequeue(){
        if(front == null){
            System.out.println("--------- Queue is Empty ----------");
            return -1;
        }
        int y = front.data;
        if(front.next == null){
            front = rear = null;
        }
        else{
            front = front.next;
        }

        return y;
    }

    public void display(){
        Node temp = front;
        while(temp != rear){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println();
    }
}
