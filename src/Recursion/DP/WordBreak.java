/*

139. Word Break

https://leetcode.com/problems/word-break/description/
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented
 *  into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

package Recursion.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict){
        HashSet<String> hash = new HashSet<>(wordDict);
        HashMap<String, Boolean> memo = new HashMap<>();
        return solveagain(s, hash, memo);
    }

    public static boolean solveagain(String s, HashSet<String> hash, HashMap<String, Boolean> memo){

        //If we reached 0 length of string, means we have found all words
        if(s.length() == 0)
            return true;
        //if memo table has seen this word before, return the val
        if(memo.containsKey(s))
            return memo.get(s);
        //We check each substring, until a match is found, if found, we recursively check its substrings, but to be safe, we continue our current loop as well
        //to see for better matches .
        for(int i = 0; i < s.length(); i++){
            String s1 = s.substring(0, i + 1);
            if(hash.contains(s1)){
                if(solveagain(s.substring(i + 1), hash, memo) == true){
                    memo.put(s, true);
                    return true;
                }
            }
        }
        //return false, when no match is found.
        memo.put(s, false);
        return false;
    }
}
