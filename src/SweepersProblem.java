import java.util.Vector;

public class SweepersProblem {
    public static void main(String[] args) {

    }

    public static int sweepersProblem(Vector<Integer> arr, int n, int k) {
        if (n < k)
            return 0;
        int[] sweepers = new int[k];
        for (int i = 0; i < k; i++)
            sweepers[i] = arr.get(i);
        return 0;

    }

}
