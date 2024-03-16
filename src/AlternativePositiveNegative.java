import java.util.ArrayList;
import java.util.Arrays;

public class AlternativePositiveNegative {
    public static void main(String[] args) {
        int[] ar = new int[]{-5, -2, 3, 4, -1, 9, -7, -10};
        alternatePandE(ar);
    }

    public static void alternatePandE(int[] ar) {
        int i = -1;
        int j = 0;

        while (j < ar.length) {
            if (ar[j] < 0) {
                i++;
                swap(ar, i, j);
            }
            j++;
        }
        swap(ar, i + 1, ar.length - 1);

        Arrays.sort(ar, 0, i + 1);
        Arrays.sort(ar, i + 1, ar.length);
        ArrayList<Integer> arr = new ArrayList<>();
        j = i;
        i = i + 1;
        while (j >= 0 && i < ar.length) {
            arr.add(ar[j]);
            if (ar[i] == 0) {
                i++;
            }
            arr.add(ar[i]);
            j--;
            i++;
        }

        while (j >= 0) {
            arr.add(ar[j]);
            j--;
        }

        while (i < ar.length) {
            if (ar[i] != 0)
                arr.add(ar[i]);
            i++;
        }

        for (int l = 0; l < arr.size(); l++) {
            System.out.print(arr.get(l) + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
