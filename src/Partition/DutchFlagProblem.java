package Partition;
public class DutchFlagProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0, 2, 1, 0};
        dutchFlag(arr, arr.length);
    }

    public static void dutchFlag(int[] nums, int n) {
        int[] dutchFlags = new int[]{0, 0, 0};
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                dutchFlags[0] += 1;
            else if (nums[i] == 1)
                dutchFlags[1] += 1;
            else
                dutchFlags[2] += 1;
        }

        for (int i = 0; i < 3; i++)
            helperFlag(dutchFlags[i], i);
    }

    public static void helperFlag(int n, int value) {
        for (int i = 0; i < n; i++)
            System.out.print(value + " ");
    }
}
