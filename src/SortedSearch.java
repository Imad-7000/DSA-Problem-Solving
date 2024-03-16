import java.util.ArrayList;

public class SortedSearch {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        System.out.println(searchPosition(arr, 0));
    }

    public static int searchPosition(ArrayList<Integer> arr, int target) {
        if (arr.size() == 0)
            return 0;
        else
            return search(arr, target, 0, arr.size() - 1);
    }

    public static int search(ArrayList<Integer> arr, int target, int low, int high) {

        int mid = (low + high) / 2;

        if (arr.get(mid) == target)
            return mid;

        if (mid - 1 > -1) {
            if (target > arr.get(mid - 1) && target < arr.get(mid))
                return mid;
        }
        if (mid + 1 < arr.size()) {
            if (target > arr.get(mid) && target < arr.get(mid + 1))
                return mid + 1;
        }

        if (target < arr.get(mid)) {
            if (mid - low == 1) {
                if (target <= arr.get(low))
                    return low;
                else
                    return mid;
            } else
                return search(arr, target, low, mid - 1);
        } else {
            if (high - mid == 1) {
                if (target >= arr.get(high))
                    return high;
                else
                    return mid;
            } else
                return search(arr, target, mid + 1, high);
        }
    }
}
