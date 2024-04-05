/*
 * 
 * 
 * LEAST COMMON SUBSTRING
 * 
 * given two substrings, return the least common substring 
 * 
 * Sol: 
 * 
 * s1 = aggtab
 * s2 = gtxxayb
 * 
 * 
 * 
 * 
 * memo table
 * ""       g          t          x         x         a         y         b
""  0         0         0         0         0         0         0         0
a   0         0         0         0         0         1         1         -1
g   0         1         1         1         1         1         1         -1
g   0         1         1         1         1         1         1         -1
t   0        -1         2         2         2         2         2         -1
a   0        -1        -1        -1        -1         3         3         -1
b   0        -1        -1        -1        -1        -1        -1          4
 * Variant 1
 */

package Recursion.DP.LCSTemplate;

public class LCS {


    //This function finds teh length of LCS
    public static int lcs(int m, int n, String s1, String s2, int[][] memo){
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
           ans =  1 +  lcs(m- 1, n - 1, s1, s2, memo);

        //if chars dont match, then check in both possiblities, that is, be decrementing 1st string and 2nd string and getting out max
        else
            ans = Math.max(lcs(m - 1, n , s1,s2,memo), lcs(m, n - 1, s1, s2, memo));
        memo[m][n] = ans;
        return ans;
    }

    //this function prints the lcs. To understand the code, the intuition of tabulation is important.
    //From table we see that, if chars at m and n match, we move diagnolly, i.e. m-1,n-1, else we move left, n-- ,
    //if no n remains, we go upwards, m--. till we reach zero box
    public static String longest(String s1, String s2, int m, int n){
        StringBuilder str = new StringBuilder();
        while (m >= 0 && n >=0 ) {
            if(s1.charAt(m) == s2.charAt(n)){
                str.append(s1.charAt(m));
                m--;
                n--;
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
