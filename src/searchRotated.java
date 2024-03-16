import java.util.Vector;

public class searchRotated {
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>();
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        System.out.println(searchRotated(arr, 3));
    }

    public static int searchRotated(Vector<Integer> nums, int target) {
        //Write your code here
        return searchIndex(nums, target, 0, nums.size() - 1);

    }

    public static int searchIndex(Vector<Integer> nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (nums.elementAt(mid) == target)
            return mid;

        if (target >= nums.elementAt(left) && target < nums.elementAt(mid))
            return searchIndex(nums, target, left, mid);
        else
            return searchIndex(nums, target, mid + 1, right);
    }
}
