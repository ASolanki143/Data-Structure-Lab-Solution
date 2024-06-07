import java.util.Scanner;

public class Lab3_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names : ");
        int num = sc.nextInt();
        String arr[] = new String[num];
        for(int i = 0 ; i < num ; i++){
            System.out.print("Enter name "+(i+1)+" : ");
            arr[i] = sc.next();
        }
        System.out.println("Old Array");
        for(int i = 0 ; i < num ; i++){
            System.out.println(arr[i]+" ");
        }
        sc.close();
        for(int i = 0 ; i < num ; i++){
            for(int j = i+1 ; j < num ; j++){
                if(arr[i].compareTo(arr[j]) > 0){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("New Array");
        for(int i = 0 ; i < num ; i++){
            System.out.println(arr[i]+" ");
        }

    }
    
}