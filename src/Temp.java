import java.util.Vector;

public class Temp {
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>();
        arr.add(10);
        arr.add(5);
        arr.add(3);
        arr.add(7);
        mergeSort(arr, 0, arr.size());
    }

    public static void mergeSort(Vector<Integer> arr, int left, int right) {
        //Write your code here
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, right, mid);
        }
    }

    public static void merge(Vector<Integer> arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;
        System.out.println(n1 + " n1    " + n2 + " n2      " + l + " l      " + r + " r     " + m + " m     ");
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }
}
