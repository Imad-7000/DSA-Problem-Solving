/*
 *
 * 1092 . shortest common supersequence
 * 
 *  https://leetcode.com/problems/shortest-common-supersequence/description/
 *  
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 *  If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.



***NOTE: This is a variation of LCS. We fill the memo table and find the length in the same manner.
        If just length of supersequence is asked the answer is |s1.len + s2.len - lcs|
        Since we are printing the SCS, we add elements moving diagnolly up as well as if elements do not match, we add 
        the bigger of the two directions.

 */


package Recursion.DP.LCSTemplate;
public class ShortestCommonSuperSequence {

    static int[][] memo;
    public static String shortestCommonSupersequence(String s1, String s2) {
        memo = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0 ; i < memo.length; i++)
            for(int j = 0 ; j < memo[i].length; j++){
                if(i == 0 || j == 0)
                    memo[i][j] = 0;
                else    
                    memo[i][j] = -1;
            }

        System.out.println(lcs(s1.length(), s2.length(), s1, s2));
        System.out.println();

        for(int i = 0 ; i < memo.length ; i++){
            for(int j = 0; j < memo[i].length; j++)
                System.out.print(memo[i][j] + "     ");
            System.out.println();
        }
        return longest(s1, s2, s1.length(), s2.length());
        
    }
    //This function finds teh length of LCS
    public static int lcs(int m, int n, String s1, String s2){
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

    //this function prints the lcs. To understand the code, the intuition of tabulation is important.
    //From table we see that, if chars at m and n match, we move diagnolly, i.e. m-1,n-1, else we move in direction which has
    //      higher value, and the char of higher value as well. finally we check if either m or n is not 0, we keep adding the elements.
    public static String longest(String s1, String s2, int m, int n){
        StringBuilder str = new StringBuilder();
        while (m > 0 && n >0 ) {
            if(s1.charAt(m - 1) == s2.charAt(n - 1)){
                str.append(s1.charAt(m - 1));
                m--;
                n--;
            }
            else if ( memo[m - 1][n] > memo[m][n - 1]){
                str.append(s1.charAt(m -1));    
                m--;
            }
            else{
                str.append(s2.charAt(n -1));
                n--;
            }
        }

        while(n > 0){
            str.append(s2.charAt(n - 1));
            n--;
        }
        while (m > 0) {
            str.append(s1.charAt(m - 1));
            m--;
        }
        return str.reverse().toString();
    }
}
