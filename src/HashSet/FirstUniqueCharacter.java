/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * 
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
 */

package HashSet;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static int firstUniqueChar(String s){
       Map<Character, Integer> myMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(myMap.containsKey(s.charAt(i))){
                myMap.put(s.charAt(i) , myMap.get(s.charAt(i)) + 1);
            }
            else
                myMap.put(s.charAt(i), 0);
        }
        for(int i =0; i < s.length(); i++){
            if(myMap.get(s.charAt(i)).equals(0))
                return i;
        }
        return -1;
    }

}
