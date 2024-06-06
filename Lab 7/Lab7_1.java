// Write a menu driven program to implement following operations on the Stack using an Array  PUSH, POP, DISPLAY, PEEP, CHANGE 

import java.util.Scanner;

public class Lab7_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        StackDemo s = new StackDemo(n);

        while(true){
            System.out.println("Enter 1 for push");
            System.out.println("      2 for pop");
            System.out.println("      3 for peep");
            System.out.println("      4 for change");
            System.out.println("      5 for display");
            System.out.println("      6 for break");

            int x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter a element : ");
                    int element = sc.nextInt();
                    s.push(element);
                    break;
                
                case 2:
                    int d = s.pop();
                    if(d > -1){
                        System.out.println("Element "+d+ " deleted");
                    }
                    break; 

                case 3:
                    System.out.println("Enter index :");
                    int i = sc.nextInt();
                    int y = s.peep(i);
                    if(y > -1){
                        System.out.println("Element is = "+y);
                    }
                    break;

                case 4:
                    System.out.println("Enter index : ");
                    int j = sc.nextInt();
                    System.out.println("Enter element : ");
                    int m = sc.nextInt();
                    s.change(j, m);
                    break;
                
                case 5:
                    s.display();
                    break;
                
                default:
                    break;
            }

            if(x >= 6) break;
        }
        sc.close();
    }
}

class StackDemo{
    int[] arr;
    int top;

    public StackDemo(int n){
        arr = new int[n];
        top = -1;
    }

    public void push(int element){
        if(top >= arr.length-1){
            System.out.println("---------- Stack Overflow ----------");
            return;
        }
        top++;
        arr[top] = element;
        System.out.println("Element pushed");
    }

    public int pop(){
        if(top == -1){
            System.out.println("---------- Stack Underflow ----------");
            return -1;
        }
        top--;
        return arr[top+1];
    }

    public int peep(int i){
        if(top - i + 1 < 0){
            System.out.println("---------- Stack Underflow ----------");
            return -1;
        }
        return arr[top - i + 1];
    }

    public void change(int i , int element){
        if(top - i + 1 < 0){
            System.out.println("---------- Stack Underflow ----------");
            return;
        }
        arr[top - i + 1] = element;
        System.out.println("Element changed");
    }

    public void display(){
        System.out.println();
        for(int i = top ; i >= 0 ; i--){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}