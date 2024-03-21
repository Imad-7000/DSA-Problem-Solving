package Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        //int[] array = new int[];
        //int[] arr = twoSum(array, array.length);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashSet = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hashSet.put(nums[i], i);
            System.out.println(nums[i] + " " + i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashSet.containsKey(target - nums[i]) && hashSet.get(target - nums[i]) != i) {
                answer[0] = i;
                answer[1] = hashSet.get(target - nums[i]);
                break;
            }
        }
        return answer;
    }
}
