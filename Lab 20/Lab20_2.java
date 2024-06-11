import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Lab20_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxDigit = Integer.toString(max).length();
        // System.out.println(maxDigit);
        int temp = 1;
        while (temp <= maxDigit) {
            radixSort(arr, temp++);
        }
        sc.close();
    }

    public static void radixSort(int[] arr, int digit) {
        int mod = 10 * digit;
        Queue<Integer>[] queues = new PriorityQueue[10];

        // Initialize each queue in the array
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new PriorityQueue<>();
        }

        // Distribute the elements into the queues
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = 1; j < digit; j++) {
                num = num / 10;
            }
            int rem = num % 10;
            queues[rem].add(arr[i]);
        }

        // Collect the elements back from the queues
        int j = 0;
        for (int i = 0; i < queues.length; i++) {
            while (!queues[i].isEmpty()) {
                arr[j] = queues[i].poll();
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}