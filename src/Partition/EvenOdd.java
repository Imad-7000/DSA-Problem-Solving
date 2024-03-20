package Partition;
import java.util.Arrays;

public class EvenOdd {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 56, 78, 1, 58, 90, 33, 32, 11};
        printArray(arr, "Before");
        partitionFunction(arr, 0, arr.length - 1);
        System.out.println();
    }

    public static void printArray(int[] arr, String val) {
        System.out.print(val + " ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void partitionFunction(int[] arr, int low, int high) {
        int i = low - 1;
        int j = low;

        while (j <= high) {
            if (arr[j] % 2 == 0) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i + 1, high);
        System.out.println("Number of Even Elements = " + ((i - low) + 1));
        System.out.println(" Number of odd elements = " + (high - i));
        System.out.println("Total = " + arr.length);
        j = i + 1;
        System.out.println();
        if (i == high - (i + 1) || i == high - (i + 2)) {
            Arrays.sort(arr);
            printArray(arr, " Sorted final");
        } else
            System.out.print("Not Possible");

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
