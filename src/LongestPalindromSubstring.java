public class LongestPalindromSubstring {
    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s, int low, int high) {

        int i = 0;
        int j = 0;
        if (s.length() == 0 || s.length() == 1)
            return s;

        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                
            }
        }
        return s.substring(i, j);
    }
}
