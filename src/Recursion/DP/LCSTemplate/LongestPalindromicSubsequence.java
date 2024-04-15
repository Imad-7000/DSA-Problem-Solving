/*
 * 
 *516. Longest Palindromic Subsequence
 * 
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * 
 *Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by 
deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 *  
 * INTUITION : We know that we are given only one String. We just need to find the lcs between s and s.reverse(), since we are looking for longest palindromic
 * Subsequence.
 * 
 */

package Recursion.DP.LCSTemplate;

public class LongestPalindromicSubsequence {
    int[][] memo;
    public int longestPalindromeSubseq(String s1) {
        StringBuilder str = new StringBuilder(s1);
        String s2 = str.reverse().toString();
        memo = new int[s1.length() + 1][s1.length() + 1];
        for(int i = 0 ; i < memo.length; i++)
            for(int j = 0 ; j < memo[i].length; j++){
                if(i == 0 || j == 0)
                    memo[i][j] = 0;
                else    
                    memo[i][j] = -1;
            }
        return lcs(s1.length(),s2.length(),s1,s2);    
    }

    public int lcs(int m, int n, String s1, String s2){
        //if either string reaches end nothing to return
        if(m == 0 || n == 0)
        {
          return 0;
        }
        //if string already processed at that point, return
        if(memo[m][n] != -1)
            return memo[m][n];
        int ans = 0;

        //if chars match, increment count and check for remaining
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
           ans =  1 +  lcs(m- 1, n - 1, s1, s2);

        //if chars dont match, then check in both possiblities, that is, be decrementing 1st string and 2nd string and getting out max
        else
            ans = Math.max(lcs(m - 1, n , s1,s2), lcs(m, n - 1, s1, s2));
        memo[m][n] = ans;
        return ans;
    }

}
