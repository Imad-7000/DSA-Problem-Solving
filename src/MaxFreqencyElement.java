import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MaxFreqencyElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(2);
        //
        //
        int val = maxElementFrequency(arr.size(), arr);

        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }

    public static int maxElementFrequency(int n, ArrayList<Integer> a) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            int count = hashMap.getOrDefault(a.get(i), 0);
            hashMap.put(a.get(i), count + 1);
        }
        FreqComparator comp = new FreqComparator(hashMap);
        Collections.sort(a, comp);
        int maxVar = a.get(0);
        int count = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == maxVar)
                count++;
            else
                break;
        }
        return count;
    }

    static class FreqComparator implements Comparator<Integer> {
        private final HashMap<Integer, Integer> hash;

        public FreqComparator(HashMap<Integer, Integer> hash) {
            this.hash = hash;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int freq = hash.get(o2).compareTo(hash.get(o1));
            return freq;
        }
    }
}
