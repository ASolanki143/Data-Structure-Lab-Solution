// Read two 2x2 matrices and perform addition of matrices into third matrix and print it 

import java.util.Scanner;

public class Lab5_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] m1 = new int[2][2];
        System.out.println("Enter elements of matrix 1 : ");
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                m1[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }

        int[][] m2 = new int[2][2];
        System.out.println("Enter elements of matrix 2 : ");
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                m2[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                System.out.print(m2[i][j] + " ");
            }
            System.out.println();
        }

        int[][] m3 = new int[2][2];
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("Sum of two matrix is : ");
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}