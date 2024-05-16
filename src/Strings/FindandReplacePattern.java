/*
 * 890. Find and Replace Patterns
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 * 
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
 * 
 * 
 * Notes::By using indexOf() you get a unique pattern that could be matched with any other string.
For example, for pattern: "abbccda" you would get an 'index pattern' of "0113350" since the first occurrence of 'a' happens at index 0,
 the first occurrence of 'b' is index 1, 'c' at index 3, and etc.
However if the string being passed in does not match the pattern such as "abbbccd" this would give an 'index pattern' of "0111446".
 For the first index that is not the same as the pattern, you return false. So in this case you would return false at index 3 since 1 is not equal to 3.
But by having a matching string such as "bccddeb" this would give you the pattern "0113350" which matches and returns true.
 */
package Strings;

import java.util.ArrayList;
import java.util.List;

public class FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) res.add(word);
        }
        return res;
    }
    
    boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) return false;
        }
        return true;
    }
}
