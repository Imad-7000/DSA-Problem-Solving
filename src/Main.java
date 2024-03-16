import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{7, 6, 5, 8, 9};
        System.out.println(maxFreq(arr));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashSet = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hashSet.put(nums[i], i);
            System.out.println(nums[i] + " " + i);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(hashSet.containsKey(target - nums[i]));
            if (hashSet.containsKey(target - nums[i]) && hashSet.get(target - nums[i]) != i) {
                answer[0] = i;
                answer[1] = hashSet.get(target - nums[i]);
                break;
            }
        }
        return answer;
    }


    public static int maxFreq(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int j : arr) {
            if (hashMap.containsKey(j))
                hashMap.put(j, hashMap.get(j) + 1);
            else
                hashMap.put(j, 1);
        }
        int maxCount = 0;
        Iterator<Map.Entry<Integer, Integer>> itr = hashMap.entrySet().iterator();
        while (itr.hasNext()) {
            int value = itr.next().getValue();
            if (value > maxCount)
                maxCount = value;
        }

        itr = hashMap.entrySet().iterator();
        int finalSum = 0;
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> value = itr.next();
            if (value.getValue() == maxCount)
                finalSum += value.getKey();
        }

        return finalSum;
    }
}
