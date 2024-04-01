/*
 * 
 * 
 * LEAST COMMON SUBSTRING
 * 
 * given two substrings, return the least common substring 
 * 
 * 
 * Variant 1
 */

package Recursion.Backtracking.DP;

public class LCS {

    public static int lcs(int m, int n, String s1, String s2, int[][] memo){
        if(m ==0 || n == 0)
        {
          return 0;
        }
        if(memo[m][n] != -1)
            return memo[m][n];
        int ans = 0;

        if(s1.charAt(m- 1) == s2.charAt(n -1))
            return 1 +  lcs(m- 1, n - 1, s1, s2, memo);
        
        ans = Math.max(lcs(m - 1, n , s1,s2,memo), lcs(m, n - 1, s1, s2, memo));
        memo[m][n] = ans;
        return ans;
    }

    public static String longest(String s1, String s2, int m, int n, int[][] memo){
        StringBuilder str = new StringBuilder();
        while (m > 0 || n >0 ) {
            if(s1.charAt(m) == s2.charAt(n)){
                if(m!=0)
                    m--;
                if(n!=0)
                    n--;
                str.append(s1.charAt(m));
            }
            else{
                if ( n > 0)
                    n--;
                else
                    m--;
            }
        }
        return str.reverse().toString();
    }
}
