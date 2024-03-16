import java.util.HashSet;
import java.util.Objects;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcadae"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (Objects.equals(s, ""))
            return 0;
        if (s.length() == 1)
            return 1;
        HashSet<Character> seen = new HashSet<>();
        int maxCount = 0;
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (seen.contains(s.charAt(j))) {
                while (seen.contains(s.charAt(j))) {
                    seen.remove(s.charAt(i));
                    i++;
                }
            }
            seen.add(s.charAt(j));
            maxCount = Math.max(maxCount, (j - i + 1));
            j++;
        }
        return maxCount;
    }
}
