import java.util.Scanner;

public class Lab11_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        int x = 1;

        while(x < 6){
            System.out.println("Enter 1 for push");
            System.out.println("      2 for pop");
            System.out.println("      3 for peep");
            System.out.println("      4 for change");
            System.out.println("      5 for display");
            System.out.println("      6 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter an element");
                    int element = sc.nextInt();
                    s.push(element);
                    break;
            
                case 2:
                    int y = s.pop();
                    if(y > -1){
                        System.out.println("---------- "+y+" is deleted ----------");
                    }
                    break;

                case 3:
                    System.out.println("Enter a position");
                    int position = sc.nextInt();
                    int n = s.peep(position);
                    if(n > -1){
                        System.out.println("---------- Element is"+n+ " ----------");
                    }
                    break;

                case 4:
                    System.out.println("Enter a posititon");
                    int position1 = sc.nextInt();
                    System.out.println("Enter element ");
                    int element1 = sc.nextInt();
                    s.change(position1, element1);
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}

class Stack{
    Node first;
    Node top;

    public Stack(){
        this.first = null;
        this.top = null;
    }

    public void push(int element){
        Node n = new Node(element , null);
        top = n;
        if(first == null){
            first = n;
            return;
        }
        Node temp = first;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
    }

    public int pop(){
        if(first == null){
            System.out.println("---------- Stack is Empty -----------");
            return -1;
        }

        Node prev = first;
        Node curr = first.next;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        int y = curr.data;
        top = prev;
        prev.next = null;
        return y;
    }

    public int peep(int position){
        if(first == null){
            System.out.println("---------- Stack is Empty -----------");
            return -1;
        }

        int size = countNode();
        if(position > size){
            System.out.println("---------- Invalid Position ----------");
            return -1;
        }

        if(position == 1) return top.data;
        if(position == size) return first.data;

        Node temp = first;
        int count = 0;

        while(count < size - position){
            count++;
            temp = temp.next;
        }

        return temp.data;
    }

    public void change(int position , int element){
        if(first == null){
            System.out.println("---------- Stack is Empty -----------");
            return;
        }

        int size = countNode();
    
        if(position > size){
            System.out.println("---------- Invalid Position ----------");
            return;
        }

        if(position == 1) {
            first.data = element;
            return;
        }
        if(position == size) {
            top.data = element;
            return;
        }

        Node temp = first;
        int count = 0;

        while(count < size - position){
            count++;
            temp = temp.next;
        }

        temp.data = element;
        return;
    }

    public void display(){
        Node temp = first;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int countNode(){
        if(first == null) return 0;
        Node temp = first;
        int count = 1;
        while(temp != top){
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class Node{
    int data;
    Node next;

    public Node(){
        this.data = 0;
        this.next = null;
    }

    public Node(int data){
        this.data = data;
    }

    public Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
}