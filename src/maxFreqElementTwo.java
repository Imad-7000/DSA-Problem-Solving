import java.util.ArrayList;
import java.util.HashMap;

public class maxFreqElementTwo {
    public static void main(String[] args) {

    }

    public static int maxElementFrequency(int n, ArrayList<Integer> a) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            int count = hashMap.getOrDefault(a.get(i), 0) + 1;
            hashMap.put(a.get(i), count);
            if (a.get(i) > maxElement)
                maxElement = a.get(i);
        }
        return hashMap.get(maxElement);
    }

}
