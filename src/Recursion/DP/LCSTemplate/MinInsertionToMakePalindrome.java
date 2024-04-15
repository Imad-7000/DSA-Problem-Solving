/*
 *
 * 1312. https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 * 
 * Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters. 
 * 
 * Intuituion : Find LCS between s and s.reverse() . Subtract LCS from s.length. That is the answer.
 * 
 * 
 */

package Recursion.DP.LCSTemplate;

public class MinInsertionToMakePalindrome {
    int[][] memo;
    public int minInsertions(String s1) {
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
        int lcsLen =  lcs(s1.length(),s2.length(),s1,s2);
        return s1.length() - lcsLen;    
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
