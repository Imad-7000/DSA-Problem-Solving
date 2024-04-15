/*
 * 
 * Minimum number of deletions and insertions to transform one string into another
Last Updated : 11 Nov, 2023
Given two strings ‘str1’ and ‘str2’ of size m and n respectively. 
The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2.
 It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted at some another point.

Example 1: 

Input : 
str1 = "heap", str2 = "pea" 
Output : 
Minimum Deletion = 2 and
Minimum Insertion = 1
Explanation:
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.
 * 
 */

package Recursion.DP.LCSTemplate;

public class MinInsertionDeletions {
    int[][] memo;

    public void minDistance(String s1, String s2) {
        memo = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0 ; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++)
                memo[i][j] = -1;
        int lcslen = lcs(s1, s2, s1.length(), s2.length());

        System.out.println(" Minimum Number of Deletions : " + (s1.length() - lcslen));
        System.out.println();
        System.out.println(" Minimum Number of Insertions : " + (s2.length() - lcslen));
        
    }
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
