/*
 * 
 * 
 * Given an array of strings strs, group the anagrams together. You can print the answer in sorted order. Also, output the list of anagrams in sorted order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Input Format:
first line contains a single integer n (size of the array).
second line contains n strings.
Output Format:
Print the group of anagrams with a single space between them

Each group in new line
Constraints:
1 <= n <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
Example:
Input:
6
eat tea tan ate nat bat

Output:
ate eat tea
bat
nat tan

Explanation:
As ate comes before bat so the group of anagrams of ate should come before group of anagrams of bat. same for others.
 */

package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
            Collections.sort(map.get(sortedWord));
        }

        
        List<List<String>> finalList = new ArrayList<>(map.values());
        Collections.sort(finalList, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                // Assuming the inner lists have at least one element
                return list1.get(0).compareTo(list2.get(0));
            }
        });

        return finalList;
    }
}

