// Write a menu driven program to implement following operations on the Stack using an Array  PUSH, POP, DISPLAY, PEEP, CHANGE 

import java.util.Scanner;

public class Lab7_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //take a size of array from user
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();

        //declare object of Stack Demo 
        StackDemo s = new StackDemo(n);

        int x = 1;
        while(x > 6){
            System.out.println("Enter 1 for push");
            System.out.println("      2 for pop");
            System.out.println("      3 for peep");
            System.out.println("      4 for change");
            System.out.println("      5 for display");
            System.out.println("      6 for break");

            x = sc.nextInt();

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
        }
        sc.close();
    }
}

class StackDemo{

    //define arr for store element of stack
    int[] arr;
    //define top pointer
    int top;

    //define constructer
    public StackDemo(int n){
        //initalize the array of size n
        arr = new int[n];
        //initalize top pointer to -1
        top = -1;
    }

    //define method for push an element
    public void push(int element){

        //top is pointing to the last element of an array
        if(top >= arr.length-1){
            System.out.println("---------- Stack Overflow ----------");
            return;
        }

        //increment top pointer
        top++;

        //insert element at top index
        arr[top] = element;
        System.out.println("Element pushed");
    }

    //define method for pop an element from stack
    public int pop(){

        //array is empty
        if(top == -1){
            System.out.println("---------- Stack Underflow ----------");
            return -1;
        }

        //decrement top pointer
        top--;

        //return top + 1 element
        return arr[top+1];
    }

    //define method for peep element from stack
    public int peep(int i){

        //check for stack underflow
        if(top - i + 1 < 0){
            System.out.println("---------- Stack Underflow ----------");
            return -1;
        }

        //return ith element from top
        return arr[top - i + 1];
    }

    public void change(int i , int element){

        //check for stack underflow
        if(top - i + 1 < 0){
            System.out.println("---------- Stack Underflow ----------");
            return;
        }

        //change ith element from top
        arr[top - i + 1] = element;
        System.out.println("Element changed");
    }

    //define method from display
    public void display(){
        System.out.println();
        for(int i = top ; i >= 0 ; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}