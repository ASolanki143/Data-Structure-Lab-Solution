// Write a program to find factors of a given number. 

import java.util.Scanner;

public class Lab1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
