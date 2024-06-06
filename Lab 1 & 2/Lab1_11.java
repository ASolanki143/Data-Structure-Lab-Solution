// WAP to find the sum of 1 + (1+2) + (1+2+3) + (1+2+3+4)+ …+(1+2+3+4+….+n). 

import java.util.Scanner;

public class Lab1_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number  : ");
        int n = sc.nextInt();
        int ans = 1;
        for(int i = 2 ; i <= n ; i++ ){
            ans += (i * (i + 1)) / 2;
        }
        System.out.println("Sum = "+ans);
        sc.close();
    }
}
