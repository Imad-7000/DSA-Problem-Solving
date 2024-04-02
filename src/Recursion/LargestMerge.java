/*
 *1754. Largest merge of two strings
 * https://leetcode.com/problems/largest-merge-of-two-strings/description/
 *  
 * You are given two strings word1 and word2. You want to construct a string merge in the following way: while either
 *  word1 or word2 are non-empty, choose one of the following options:

If word1 is non-empty, append the first character in word1 to merge and delete it from word1.
For example, if word1 = "abc" and merge = "dv", then after choosing this operation, word1 = "bc" and merge = "dva".
If word2 is non-empty, append the first character in word2 to merge and delete it from word2.
For example, if word2 = "abc" and merge = "", then after choosing this operation, word2 = "bc" and merge = "a".
Return the lexicographically largest merge you can construct.

A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, 
a has a character strictly larger than the corresponding character in b. For example, "abcd" is lexicographically larger than
 "abcc" because the first position they differ is at the fourth character, and d is greater than c.

 

Example 1:

Input: word1 = "cabaa", word2 = "bcaaa"
Output: "cbcabaaaaa"
Explanation: One way to get the lexicographically largest merge is:
- Take from word1: merge = "c", word1 = "abaa", word2 = "bcaaa"
- Take from word2: merge = "cb", word1 = "abaa", word2 = "caaa"
- Take from word2: merge = "cbc", word1 = "abaa", word2 = "aaa"
- Take from word1: merge = "cbca", word1 = "baa", word2 = "aaa"
- Take from word1: merge = "cbcab", word1 = "aa", word2 = "aaa"
- Append the remaining 5 a's from word1 and word2 at the end of merge.
Example 2:

Input: word1 = "abcabc", word2 = "abdcaba"
Output: "abdcabcabcaba"
 

Constraints:

1 <= word1.length, word2.length <= 3000
word1 and word2 consist only of lowercase English letters.
 */

package Recursion;

public class LargestMerge {

    public static String largestMerge(String word1, String word2) {
        return largestMergehelp(word1,word2,0,0,"");
    }


    public static String largestMergehelp(String word1, String word2, int m, int n,String finalAns){
        
        //If bopth string are empty return ans as search finsihed
        if(m == word1.length() && n == word2.length())
            return finalAns;
        //if any one string reaches lenght just append the remning of other and return
        if(m == word1.length()){
            finalAns += word2.substring(n, word2.length());
            return finalAns;
        }

        if(n == word2.length()){
            finalAns += word1.substring(m, word1.length());
            return finalAns;
        }


        //if word1 char is bigger add that
        if(word1.charAt(m) > word2.charAt(n)){
            finalAns += word1.charAt(m);
            return largestMergehelp(word1, word2, m + 1, n, finalAns);
        }

        //if word2 char is bigger add that
        else if(word2.charAt(n) > word1.charAt(m)){
            finalAns += word2.charAt(n);
            return largestMergehelp(word1, word2, m , n + 1, finalAns);
        }

        //if same, compare lexicographically bigger word of the remaining substring and add that char
        else{
            if(word1.substring(m).compareTo(word2.substring(n)) > 0){
                finalAns += word1.charAt(m);
                return largestMergehelp(word1, word2, m + 1, n, finalAns);
            }
            else{
                finalAns += word2.charAt(n);
                return largestMergehelp(word1, word2, m, n + 1, finalAns);
            }
        }
        
    }

}
