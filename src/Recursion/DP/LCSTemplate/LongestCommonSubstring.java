/*
 * 
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring. 

Examples : 

Input : X = “GeeksforGeeks”, y = “GeeksQuiz” 
Output : 5 
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd” 
Output : 4 
Explanation:
The longest common substring is “abcd” and is of length 4.



Input : X = “zxabcdezy”, y = “yzabcdezx” 
Output : 6 
Explanation:
The longest common substring is “abcdez” and is of length 6.
 * 
 */

package Recursion.DP.LCSTemplate;


public class LongestCommonSubstring {
    protected static int[][] memo;
    public static int lcs(String s1, String s2){
        memo = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0 ; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++)
                memo[i][j] = -1;
        return lonComSub(s1, s2, s1.length() - 1, s2.length() - 1, 0);
    }

    public static int lonComSub(String s1, String s2, int m, int n, int length){
        if(m < 0 || n < 0)
            return length;
        if(memo[m][n] != -1)
            return memo[m][n];
        int ans = 0;
        if(s1.charAt(m) == s2.charAt(n))
            ans  = lonComSub(s1, s2, m - 1 , n - 1, length + 1);
        else{
            int val =  Math.max(lonComSub(s1, s2, m - 1, n, length), lonComSub(s1, s2, m, n -1, length));
            ans = Math.max(val, length);
        }
        memo[m][n] = ans;
        return ans;
    }
}
