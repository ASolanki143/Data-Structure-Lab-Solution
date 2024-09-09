import java.util.Scanner;

public class Lab22_1 {
    public void heapSort(int[] array) {
        int n = array.length;
        buildMaxHeap(array, n);

        for (int i = n - 1; i > 0; i--) {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public void buildMaxHeap(int[] array, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    public void heapify(int[] array, int n, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int maxIndex = i;

        if (leftChild < n && array[maxIndex] < array[leftChild]) {
            maxIndex = leftChild;
        }

        if (rightChild < n && array[maxIndex] < array[rightChild]) {
            maxIndex = rightChild;
        }

        if (i != maxIndex) {
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            heapify(array, n, maxIndex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the element: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("---------------Display---------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Lab22_1 object = new Lab22_1();
        object.heapSort(array);

        System.out.println("---------After Sort Display---------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}