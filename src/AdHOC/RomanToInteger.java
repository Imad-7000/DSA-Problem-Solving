package AdHOC;
import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("DXLIX"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'I' && i != s.length() - 1) && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V')) {
                sum += (hashMap.get(s.charAt(i + 1)) - hashMap.get(s.charAt(i)));
                i++;
            } else if ((s.charAt(i) == 'X' && i != s.length() - 1) && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                sum += (hashMap.get(s.charAt(i + 1)) - hashMap.get(s.charAt(i)));
                i++;
            } else if ((s.charAt(i) == 'C' && i != s.length() - 1) && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                sum += (hashMap.get(s.charAt(i + 1)) - hashMap.get(s.charAt(i)));
                i++;
            } else {
                sum += hashMap.get(s.charAt(i));
            }
        }
        return sum;
    }

}
