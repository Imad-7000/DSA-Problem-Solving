public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] newArr = reverseArray(arr, 3);

        for (int num : newArr)
            System.out.println(num);
    }

    public static int[] reverseArray(int[] arr, int n) {
        int[] res = new int[n + n];

        for (int i = 0; i < n; i++) {
            res[i] = arr[i];
        }

        int k = n - 1;
        for (int i = n; i < res.length; i++) {
            res[i] = res[k];
            k--;
        }

        return res;
    }
}
