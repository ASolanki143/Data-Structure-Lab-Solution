import java.util.Scanner;

public class Lab9_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a size of an array : ");  
        int n = sc.nextInt();
        
        PriorityQueue pq = new PriorityQueue(n);
        int x = 1;
        int element;

        while (x < 4) {
            System.out.println("Enter 1 for insert");
            System.out.println("      2 for delete");
            System.out.println("      3 for display");
            System.out.println("      4 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("---------- Insert Element ----------");
                    System.out.print("Enter an element : ");
                    element = sc.nextInt();
                    pq.insert(element);
                    break;
                
                case 2:
                    System.out.println("---------- Delete Element ----------");
                    element = pq.delete();
                    if(element > -1){
                        System.out.println("---------- "+element+" deleted ----------");
                    }
                    break;

                case 3:
                    System.out.println("---------- Display ----------");
                    pq.display();
                    break;
                
                default:
                    break;
            }
        }
        sc.close();
    }
}

class PriorityQueue{
    int[] arr;
    int front;
    int rear;
    int size;

    public PriorityQueue(int size){
        this.size = size;
        this.arr = new int[size];
        this.rear = this.front = -1;
    }

    public void insert(int element){
        if(rear - front >= size - 1){
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        if(front == -1){
            front = rear = 0;
            arr[front] = element;
            return;
        }
        int j = rear;
        while(j >= 0 && arr[j] > element){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = element;
        rear++;
        display();
    }

    public int delete(){
        if(front == -1){
            System.out.println("---------- Queue Underflow ----------");
            return -1;
        }
        
        // int index = findIndex(element);
        // if(index == -1){
        //     System.out.println("---------- Element Not Found ----------");
        //     return;
        // }
        // while(index < rear){
        //     arr[index] = arr[index + 1];
        //     index++;
        // }
        // arr[index] = 0;

        int j = front;
        int element = arr[front];
        while(j < rear){
            arr[j] = arr[j+1];
            j++;
        }
        arr[j] = 0;
        if(front == rear){
            front = rear = -1;
        }
        else{
            rear--;
        }
        display();
        return element;
    }

    public void display(){
        if(front == -1){
            System.out.println("---------- Empty Queue ----------");
            return;
        }
        for(int i = front; i <= rear ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}