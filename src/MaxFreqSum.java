import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxFreqSum {
    public static void main(String[] args) {


        char[] ch = new char[]{'3', '+'};
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i]))
                System.out.print("Digit " + ch[i]);
        }
        int[] arr = new int[]{1, 2, 3, 4, 3, 3, 3, 2, 2, 2, 4, 1};
        //System.out.println(countFreq(arr, arr.length));
    }

    static long countFreq(int[] arr, int n) {
        // Write your code here
        int maxCount = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = hash.getOrDefault(arr[i], 0) + 1;
            hash.put(arr[i], count);
            if (count > maxCount)
                maxCount = count;
        }

        long sum = 0;
        Iterator<Map.Entry<Integer, Integer>> itr = hash.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            if (entry.getValue() == maxCount)
                sum += entry.getKey();
        }
        return sum;
    }
}
