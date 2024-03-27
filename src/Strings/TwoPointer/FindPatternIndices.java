/*
 * Unraveling Clues with Professor
Problem Statement:

In the bustling city of Bangalore, there exists a prestigious coding academy named HeyCoach. This academy is renowned for nurturing brilliant young minds and turning them into skilled programmers and problem solvers. Among the students is Varshil, a diligent and passionate learner who is always eager to explore new challenges.

One day, as Varshil is working on an advanced algorithms assignment, their mentor, Professor Prateek, notices their enthusiasm and decides to present them with a perplexing puzzle. Professor Prateek hands Varshil a piece of paper with a jumble of lowercase alphabetical characters, both a pattern and a text.

"Varshil," Professor Prateek says with a smile, "I have a challenge for you. I want you to find all the indices where this pattern appears within the text."

Help Varshil solve this problem.

Input:

- A string text (1 <= |text| <= 10^5): A jumble of lowercase alphabetical characters.
- A string pattern (1 <= |pattern| <= 10^5): The pattern to search within the text.
Output:

A list of integers representing the indices where the pattern appears within the text. If 
Example 1:

Input:

- text = "ababcabab"
- pattern = "ab"
Output:

[0, 2, 5, 7]
Explanation:

The pattern "ab" appears at indices 0, 2, 4, and 7 within the text.
Constraints:

- 1 <= |text| <= 10^5

- 1 <= |pattern| <= 10^5

1 <= |text| <= 10^5

1 <= |pattern| <= 10^5

The input consists of lowercase alphabetical characters.
 * 
 * 
 * 
 * a case can be like this .. text : aaaaaaa ; pattern = aa where index is every element except len - 1;
 * 
 * 
 * 
 * O(n) time complexity
 * O(n) space to hold final array
 */

package Strings.TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class FindPatternIndices {
    public static List<Integer> findPatternIndices(String text, String pattern) {

        //list to add indices
        List<Integer> list = new ArrayList<>();
        int j = 0;
        //iterate throuugh text to see where an element exists that mathes pattern start
        while (j < text.length()) {
            //if match is present, test the remaining string
            if(text.charAt(j) == pattern.charAt(0)){    
                int i = 1;
                int k = j + 1; //k = j + 1 because first char already verified

                //keep checking until pattern matches and i and j in limits
                while (i < pattern.length() && k < text.length() && text.charAt(k) == pattern.charAt(i)) {
                    i++;
                    k++;
                }
                
                //if i reaches pattern length, then add the starting pos which is j
                if( i == pattern.length())
                    list.add(j);
              }
        //increment and check all possiblities
          j++;
        }
        return list;
    }
}
