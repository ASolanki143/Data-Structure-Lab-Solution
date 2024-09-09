import java.util.*;

public class Lab22_2 {
    public int[] shellSort(int[] array, int N) {

        for (int gap = N / 2; gap >= 1; gap = gap / 2) {

            for (int j = gap; j < N; j++) {

                for (int i = j - gap; i >= 0; i = i - gap) {

                    if (array[i + gap] > array[i]) {
                        break;
                    } else {
                        int temp = array[i + gap];
                        array[i + gap] = array[i];
                        array[i] = temp;
                    }

                }

            }

        }

        return array;
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

        Lab22_2 object = new Lab22_2();
        object.shellSort(array, array.length);

        System.out.println("---------After Sort Display---------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}