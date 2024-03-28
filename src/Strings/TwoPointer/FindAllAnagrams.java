/*
 * 
 * Count Occurences of Anagrams
Raman is a keen observer, he can easily see the jumbled words so one day one of his friend challenged him to 
count the occurrences of all the anagrams of string C in a given string S. Raman accepted the challenge but he is facing some problems in it .
 Can you help them ?

Input:

S=fororfrdofr  
C=for   
Output: 3

Input :

 S=aabaabaa  
 C=aaba  
Output: 4

1<=s.length, c.length<=10^3
 */

package Strings.TwoPointer;

import java.util.HashMap;

public class FindAllAnagrams {
    public static int countAnagrams(String s, String c) {
        int finalcount = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < c.length(); i++)
            hash.put(c.charAt(i), hash.getOrDefault(c.charAt(i), 0) + 1);
        
        int i = 0;
        while (i <= s.length() - c.length()) {
            HashMap<Character, Integer> temp = new HashMap<>();
            int j = i;
            while (j < c.length() + i) {
                if(!hash.containsKey(s.charAt(j)))
                    break;
                else
                    temp.put(s.charAt(j), temp.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }

            if(temp.equals(hash))
                finalcount++;
            i++;
        }
        return finalcount;
    }
}
