import java.util.Scanner;

public class Lab9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of queue : ");
        int n = sc.nextInt();

        CircularQueue q = new CircularQueue(n);

        int x = 1;
        while(x < 4){
            System.out.println("Enter 1 for enqueue ");
            System.out.println("      2 for dequeue ");
            System.out.println("      3 for display");
            System.out.println("      4 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter an element : ");
                    int element = sc.nextInt();
                    q.circularQueueInsert(element);
                    break;
                
                case 2:
                    int y = q.circluarQueueDelete();
                    if(y > -1){
                        System.out.println("---------- "+y+" deleted ----------");
                    }
                    break;

                case 3:
                    q.display();
                    break;
                
                default:
                    break;
            }
        }

        sc.close();
    }
}

class CircularQueue{
    int r;
    int f;
    int size;
    int[] cqueue;

    public CircularQueue(int n){
        r = -1;
        f = -1;
        size = n;
        cqueue = new int[n]; 
    }

    public void circularQueueInsert(int element){
        if(r == size-1){
            r = 0;
        }
        else{
            r++;
        }

        if(f == r){
            System.out.println("---------- Queue Overflow ----------");
            return;
        }

        cqueue[r] = element;

        if(f == -1){
            f = 0;
        }
        display();
    }

    public int circluarQueueDelete(){
        if(f == -1){
            System.out.println("--------- Queue Underflow ----------");
            return -1;
        }

        int element = cqueue[f];
        cqueue[f] = 0;

        if(f == r){
            f = -1;
            r = -1;
        }
        else if(f == size - 1){
            f = 0;
        }
        else{
            f++;
        }
        display();
        return element;
    }

    public void display(){
        System.out.println("---------- Display ----------");
        for(int i = 0 ; i < size ; i++){
            System.out.print(cqueue[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}
