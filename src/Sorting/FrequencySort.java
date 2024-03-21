package Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FrequencySort {
    public static void main(String[] args) {
        String s = "ssgysyqa";
        System.out.print(frequencySort(s));
    }


    public static String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayList<Character> outputArray = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int count = hashMap.getOrDefault(temp, 0);
            hashMap.put(temp, count + 1);
            outputArray.add(s.charAt(i));
        }

        FreqComparator freq = new FreqComparator(hashMap);
        Collections.sort(outputArray, freq);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < outputArray.size(); i++)
            str.append(outputArray.get(i));
        return str.toString();
    }
}

class FreqComparator implements Comparator<Character> {
    private final HashMap<Character, Integer> hash;

    public FreqComparator(HashMap<Character, Integer> hash) {
        this.hash = hash;
    }

    @Override
    public int compare(Character o1, Character o2) {
        int freq = hash.get(o2).compareTo(hash.get(o1));

        int value = o1.compareTo(o2);

        if (freq == 0)
            return value;
        else
            return freq;
    }
}
