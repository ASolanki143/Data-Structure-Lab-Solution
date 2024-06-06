import java.util.Scanner;

public class Lab9_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of queue : ");
        int n = sc.nextInt();

        QueueDemo q = new QueueDemo(n);

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
                    q.enqueue(element);
                    break;
                
                case 2:
                    int y = q.dequeue();
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

class QueueDemo{
    int r;
    int f;
    int size;
    int[] queue;

    public QueueDemo(int n){
        this.r = -1;
        this.f = -1;
        this.size = n;
        queue = new int[n];
    }

    public void enqueue(int element){
        if(r >= size-1){
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        r++;
        queue[r] = element;
        if(f == -1){
            f = 0;
        }
        System.out.println("---------- Element Added ----------");
        display();
    }

    public int dequeue(){
        if(f == -1){
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        int element = queue[f];
        if(f == r){
            f = -1;
            r = -1;
        }
        else{
            f++;
        }
        display();
        return element;
    }

    public void display(){
        if(f == -1 || r == -1) return;
        System.out.println("---------- Display ----------");
        for(int i = f ; i <= r ; i++){
            System.out.print(queue[i] + " - ");
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}