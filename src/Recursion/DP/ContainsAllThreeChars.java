/*
 * 
 * 1358. Number of substrings containing all three chars
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 * 
 * Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", 
"abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
 */
package Recursion.DP;

import java.util.HashSet;

public class ContainsAllThreeChars {
    public int numberOfSubstrings(String s) {
        int j = s.length() - 1;
        int i = s.length() - 1;
        int count = 0;
        HashSet<Character> hash = new HashSet<>();
        while(j >= 0){
            hash.add(s.charAt(j));
            if(hash.size() == 3){
                count++;
                count = count + (s.length() - 1 - i);
                while(hash.size() == 3){
                    hash.remove(s.charAt(i));
                    i--;
                }
            }
            j--;
        }

        return count;
    }

    public int number(String s, int i){
        if(i >= s.length() - 3)
            return 0;
        if()
    }
}
