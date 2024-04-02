package Partition;
/*
 * 
 * Given an array, move all zeros to the beginning of the array
 */


public class AllZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 2, 0, 0, 0, 12, 0, 3, 7, 0, 5, 3, 2, 0, 0, 1, 0};
        partitionFunction(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void partitionFunction(int[] arr) {
        int i = -1;
        int j = 0;

        while (j < arr.length) {
            if (arr[j] == 0) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i + 1, arr.length - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
