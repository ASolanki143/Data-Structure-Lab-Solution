import java.util.Scanner;

public class Lab9_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of queue : ");
        int n = sc.nextInt();

        DoubleEndedQueue q = new DoubleEndedQueue(n);

        int x = 1;
        while(x < 6){
            System.out.println("Enter 1 for insert at rear ");
            System.out.println("      2 for insert at front ");
            System.out.println("      3 for delete from front");
            System.out.println("      4 for delete from rear");
            System.out.println("      5 for display");
            System.out.println("      6 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element1 = sc.nextInt();
                    q.insertAtRear(element1);
                    break;
                
                case 2:
                    System.out.println("Enter an element : ");
                    int element2 = sc.nextInt();
                    q.insertAtFront(element2);;
                    break;

                case 3:
                    int y1 = q.deleteAtFront();
                    if(y1 > -1){
                        System.out.println("---------- "+y1+" deleted ----------");
                    }
                    break;
                
                case 4:
                    int y2 = q.deleteAtFront();
                    if(y2 > -1){
                        System.out.println("---------- "+y2+" deleted ----------");
                    }
                    break;

                case 5:
                    q.display();
                    break;

                default:
                    break;
            }
        }

        sc.close();
    }
}

class DoubleEndedQueue{
    int f;
    int r;
    int size;
    int[] dqueue;

    public DoubleEndedQueue(int n){
        f = -1;
        r = -1;
        size = n;
        dqueue = new int[n];
    }
    public void insertAtRear(int element){
        if(r >= size-1){
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        r++;
        dqueue[r] = element;
        if(f == -1){
            f = 0;
        }
        System.out.println("---------- Element Added at Rear ----------");
    }

    public void insertAtFront(int element){
        if(f == -1){
            System.out.println("---------- Empty ----------");
            return;
        }
        if(f == 0){
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        f--;
        dqueue[f] = element;
        System.out.println("---------- Element Added at Front ----------");
    }

    public int deleteAtFront(){
        if(f == -1){
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        int element = dqueue[f];
        if(f == r){
            f = -1;
            r = -1;
        }
        else{
            f++;
        }
        return element;
    }

    public int deleteAtRear(){
        if(r == -1){
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        int y = dqueue[r];
        dqueue[r] = 0;
        if(r == f){
            r = -1;
            f = -1;
        }
        else{
            r--;
        }
        return y;
    }

    public void display(){
        System.out.println("---------- Display ----------");
        for(int i = 0 ; i < size ; i++){
            System.out.print(dqueue[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}
