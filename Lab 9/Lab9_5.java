import java.util.Scanner;

public class Lab9_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input size : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter input separeted by space : ");
        String input = sc.nextLine();

        String[] inputs = input.split(" ");
        for(String str : inputs) System.out.println(str);
        Peacock p = new Peacock(n);

        for(int i = 0 ; i < inputs.length ; i++){
            if(inputs[i].indexOf("buy") > -1){
                String color = inputs[i].substring(inputs[i].indexOf("_")+1);
                p.buyCloth(color);
            }
            else{
                String color = p.fetch();
                System.out.println("---------- "+color+" -----------");
            }
        }
        sc.close();
    }
}

class Peacock{
    String[] arr;
    int front;
    int rear;
    int size;

    public Peacock(int size){
        this.size = size;
        this.arr = new String[size];
        this.front = this.rear = -1;
    }

    public void buyCloth(String color){
        rear++;
        if(rear >= size){
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        arr[rear] = color;
        if(front == -1){
            front = 0;
        }
    }

    public String fetch(){
        if(front == -1){
            System.out.println("---------- Queue is Empty ----------");
            return "";
        }
        String color = arr[front];
        int j = front;
        while(j < rear){
            arr[j] = arr[j+1];
            j++;
        }
        arr[j] = color;
        return color;
    }
}