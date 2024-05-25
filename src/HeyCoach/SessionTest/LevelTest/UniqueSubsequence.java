/*
 * 940. Count Distinct Subsequences 2
 * https://leetcode.com/problems/distinct-subsequences-ii/description/
 * 
 * 
 * Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, return it modulo 109 + 7.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing 
the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 

Example 1:

Input: s = "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
Example 2:

Input: s = "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".
Example 3:

Input: s = "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters.
 * 
 * 
 */
package HeyCoach.SessionTest.LevelTest;
import java.util.*;
public class UniqueSubsequence {
    private static final long MOD = 1000000007;
    public int uniqueSubsequences(String s) {
      //Write tyour code here; 
        char[] arr = s.toCharArray();
        int n = arr.length;
        Long[] dp = new Long[n];
        return (int)(helper(arr, 0, dp)%MOD);

 }

   public long helper(char[] arr, int i, Long[] dp) {
        if(i>=arr.length) return 0;
        if(dp[i] != null) return dp[i];
        Set<Character> set = new HashSet<>();
        long ans = 0;
        for(int j=i;j<arr.length;j++) {
            if(set.contains(arr[j])) continue;
            set.add(arr[j]);
            ans = (ans%MOD + 1 + helper(arr, j+1, dp)%MOD)%MOD;
        }
        return dp[i] = ans;
    }

}
