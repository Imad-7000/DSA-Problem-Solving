/*
 * 771. Jewels
 * https://leetcode.com/problems/jewels-and-stones/description/
 * 
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 *  Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 */
package HashSet;

import java.util.HashSet;

public class Jewels {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewel = new HashSet<>();
        int count = 0;
        for(int i = 0; i < jewels.length(); i++){
            jewel.add(jewels.charAt(i));
        }
        for(int i = 0; i < stones.length(); i++){
            if(jewel.contains(stones.charAt(i)))
                count++;
        }
        return count;
    }
}
