/*
 * 10. Regular Exp Matching 
 * https://leetcode.com/problems/regular-expression-matching/description/
 * 
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 

Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
package General;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean arr[][] = new boolean[m+1][n+1];
        arr[0][0]= true;

        for(int i = 2; i<m; i++){
            if(p.charAt(i-1)=='*' && arr[i-2][0]) arr[i][0]= true;
        }
        for(int i=1; i<=m; i++){
             for(int j=1; j<=n; j++){
                // System.out.println(i +" " + j +" " + p.charAt(i-1) +" " +s.charAt(j-1) );
                if(p.charAt(i-1)=='*'){
                    if(arr[i-2][j-1] && (p.charAt(i-2)==s.charAt(j-1) || p.charAt(i-2)=='.')) arr[i][j]= true;
                    if(arr[i-2][j]) arr[i][j]= true;
                    if(arr[i][j-1] && (p.charAt(i-2)==s.charAt(j-1) || p.charAt(i-2)=='.')) arr[i][j]= true;
                }
                else if(p.charAt(i-1)=='.'){
                    if(arr[i-1][j-1]) arr[i][j]= true;
                }
                else if(arr[i-1][j-1] && p.charAt(i-1)==s.charAt(j-1)){
                    arr[i][j]= true;
                }

             }
        }
        // print(arr);
        return arr[m][n];
    }
    void print(boolean arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
