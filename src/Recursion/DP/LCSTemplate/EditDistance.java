/*
 * 
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 * 
 */
package Recursion.DP.LCSTemplate;

public class EditDistance {
       //Memoization Code
       public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int storage[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
            storage[i][j] = -1;
            }
        }
        
        return editMemo(word1,word2,storage);
    }
   
   public int editMemo(String word1, String word2, int storage[][]){
       int m = word1.length();
        int n = word2.length();
       if(storage[m][n] != -1){
           return storage[m][n];
       }
       if(m==0) return storage[m][n] = n;
       if(n==0) return storage[m][n] = m;
        if(word1.charAt(0) == word2.charAt(0)){
           return storage[m][n] = editMemo(word1.substring(1),word2.substring(1),storage);
        }else{
              //insert
           int insert = editMemo(word1,word2.substring(1),storage);
            //delete
           int delete = editMemo(word1.substring(1),word2,storage);
            //replace 
           int replace = editMemo(word1.substring(1),word2.substring(1),storage);
             storage[m][n] = 1 + Math.min(insert,Math.min(delete,replace));
        }
       return storage[m][n];
   }
   
}
