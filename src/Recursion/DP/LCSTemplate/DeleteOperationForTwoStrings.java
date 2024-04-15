/*
 *
 * 583. Delete Operation For Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *  
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
 * 
 * 
 * 
 * INTUITION : We know that if we remove LCS from both strings, we'll get exactly the number of chars to delete. 
 * Hence s1.len + s2.len - 2*lcs
 */

package Recursion.DP.LCSTemplate;

public class DeleteOperationForTwoStrings {
    int[][] memo;

    public int minDistance(String s1, String s2) {
        memo = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0 ; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++)
                memo[i][j] = -1;
        int len = s1.length() + s2.length();
        int lcslen = lcs(s1, s2, s1.length(), s2.length());
        return Math.abs(len - 2*lcslen);
        
    }

    //Code to find LCS
    public int lcs(String s1, String s2, int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(memo[m][n] != -1)
            return memo[m][n];
        int ans = 0;
        if(s1.charAt(m - 1) == s2.charAt(n - 1)){
            ans = 1 + lcs(s1, s2, m - 1, n - 1);
        }
        else{
            ans = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
        return memo[m][n] = ans;
    }
}
