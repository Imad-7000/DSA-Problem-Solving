/*
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/description/
 * 
 * 
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing 
the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its 
subsequence. In this scenario, how would you change your code?
 */
package Recursion.DP.LCSTemplate;

public class IsSubsequence {
    int[][] memo;
    public boolean isSubsequence(String s, String t) {
        memo = new int[s.length() + 1][t.length() + 1];
        for(int i = 0 ; i < memo.length; i++){
            for(int j = 0 ; j < memo[i].length; j++)
                memo[i][j] = -1;
        }
        int val = isSubsequence(s.length() - 1,t.length() - 1, s, t);
        if(val == s.length())
            return true;
        return false;
    }

    public int isSubsequence(int m, int n, String s, String t){
        if(m == 0 || n == 0)
            return 0;
        if(memo[m][n] != -1)
            return memo[m][n];
        int ans = 0;
        if(s.charAt(m) == t.charAt(n))
            ans = 1 + isSubsequence(m - 1,n - 1,s, t);
        else
            ans = Math.max(isSubsequence(m - 1, n, s, t), isSubsequence(m, n - 1, s, t));
        memo[m][n] = ans;
        return ans;
    }

}
