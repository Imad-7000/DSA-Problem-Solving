/*
 * 
 * 
 * First Non Repeating
Given a string str which denotes stream of characters. 
Your task is to find a new string output_str. output_str is formed such that we have to find first non-repeating 
character at each instance when a character is inserted to the stream and append it at the end of output_str.
 If no such non-repeating charater is found then append 'X' at the end of output_str.

Input Format:
Only one line which contains a string that needs to be converted to output_str.
Output Format:
Return the updated string.
Input:
str = dabc

Output:
dddd

Explanation:
"d" - first non-repeating chararcter 'd'.

"da" - first non-repeating chararcter 'd'.

"dab" - first non-repeating chararcter 'd'.

"dabc" - first non-repeating chararcter 'd'
Input:
str = bbe

Output:
bXe

Explanation:
"b" - first non-repeating character 'b'

"bb" - no non-repeating character so 'X'

"bbe" - first non-repeating character 'e'

Constraints:
1 ≤ |str| ≤ 10^5
 * 
 * 
 */
package General;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirsTNonRepeatingChar {
     public String firstNonRep(String str) {
      //Write your code here
       Map<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder outputStr = new StringBuilder();

        for (char ch : str.toCharArray()) {
            // Update the frequency count
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            // Add the current character to the queue
            queue.offer(ch);

            // Remove characters from the front of the queue until we find a non-repeating one
            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.poll();
            }

            // Append the first non-repeating character to the result, or 'X' if none exists
            if (queue.isEmpty()) {
                outputStr.append('X');
            } else {
                outputStr.append(queue.peek());
            }
        }

        return outputStr.toString();
    }
}   
