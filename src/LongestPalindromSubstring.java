/*
*   5. Longest Palindromic Substring
*   https://leetcode.com/problems/longest-palindromic-substring/description/
* 
*   Given a string s, return the longest palindromic substring in s.

    Example 1:

    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
 

    Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.
 *  
 * 
 *  INTUITION = for every index, check with two pointers for Palindrome
 *              Time O(n^2);
 */

public class LongestPalindromSubstring {
    public static void main(String[] args) {
        String str = "";
        System.out.println(longestPalindrome(str));
    }

    static String beString = "";
    static int longest = 0;
    public static String longestPalindrome(String s) {
        for(int i = 0 ; i < s.length(); i++){
            longest(s, i, i);
            longest(s, i, i + 1);
        }
        return beString;
    }

    public static void longest(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(j - i + 1 > longest){
                longest = j - i + 1;
                beString = s.substring(i, j + 1);
            }
            i--;
            j++;
        }
    }
}
