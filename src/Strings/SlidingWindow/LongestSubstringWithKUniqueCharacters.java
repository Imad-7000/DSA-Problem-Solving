/*
 * 
 * Create an algorithm to find a substring with the maximum length that contains precisely K distinct characters within a given string. 
 * If multiple substrings have the same maximum length, you can output any one of them.

Your Task: You don't need to read input or print anything. Your task is to complete the function longestKSubstr()
 which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters.
  If there is no substring with exactly K distinct characters then return -1.

Sample Input
S = "aabacbebebe", K = 3

Sample Output
7

Explanation
"cbebebe" is the longest substring with 3 distinct characters.


Constraints:

1 <= s.length <= 1e^6
'-a' <= s[i] <= 'z'
K <= 26

 */

package Strings.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

    public static int longestUniqueSubstring(String s, int k){

        //Initialise to -1 as if no such string is found, just return -1 
        int maxCount = -1;

        //Map to store characters and count
        HashMap<Character, Integer> seen = new HashMap<>();
        int i = 0; 
        int j = 0;

        //traverse j to end and only traverse i if hashmap size exceed k
        while (j < s.length()) {

            seen.put(s.charAt(j), seen.getOrDefault(s.charAt(j),0) + 1);

            //size of hashmap exceeds k, thus store maxcount and remove elements from map till size is again  k
            if(seen.size() > k){
                int count = j - i ;
                if(count > maxCount)
                    maxCount = count;
                
                while (seen.size() != k) {
                    seen.put(s.charAt(i), seen.get(s.charAt(i)) - 1);
                    if(seen.get(s.charAt(i)) == 0)
                        seen.remove(s.charAt(i));
                  
                    i++;
                }
            }
            j++;
        }

        //check if final size is better
        if(seen.size() == k)
            {
                if(j - i > maxCount)
                    maxCount = j - i ;
            }
        return maxCount;
    }

}
