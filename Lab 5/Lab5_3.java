import java.util.Arrays;
import java.util.Scanner;

public class Lab5_3{

    public static boolean checkAnagram(String str , String anagram){

        if(str.length() != anagram.length()) return false;

        char[] s1 = str.toCharArray();
        char[] s2 = anagram.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        for(int i = 0 ; i < s1.length ; i++){
            if(s1[i] != s2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();

        String[] arr = new String[n];

        System.out.println("Enter strings : ");

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.next();
        }

        int randomIndex = (int)(Math.random() * n);

        System.out.println("---------- Word is "+arr[randomIndex]+" ----------");

        System.out.println("Enter anagram : ");
        String anagram = sc.next();

        boolean isAnagram  = checkAnagram(arr[randomIndex] , anagram);

        if(isAnagram){
            System.out.println("-----------Congratulation-----------");
            System.out.println("You guess the right anagram");
        }
        else{
            System.out.println("You not guess right anagram");
        }

        sc.close();
    } 
}