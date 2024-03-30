/*
 * 
 * Gram and the string
In a picturesque village, Gram, the revered elder, received a magical string named "s."

The village, filled with avid letter collectors, eagerly anticipated Gram's ingenuity. 
With a quest to create a unique and lexicographically ordered sequence, Gram carefully crafted an algorithm. 
Duplicates vanished, and the string transformed into a captivating tale of linguistic elegance.

The village celebrated Gram as the guardian of lexicographical order, 
and the magical string "s" became a symbol of their commitment to precision. 
The story resonated through the hills, inspiring generations to unravel the mysteries of letters and strings.

Input:
A string s of length between 1 and 10,000.

Output:
Return the smallest lexicographical order string after removing duplicates.

Example 1:
Input:

s = "bcabc"

Output:
"abc"

Example2:
Input:
s = "cbacdcbc"

Output:
"acdb"

Constraints:
The length of the input string s is within the range [1, 10,000].
The string s consists of lowercase English letters.
 */

package HeyCoach.SessionTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class UniqueLexString {

    public static String removeDuplicateLetters(String s) {
        //Write your code here 
        Stack<Character> stack = new Stack<>();

        HashMap<Character, Integer> last = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++)
            last.put(s.charAt(i), i);
        
        HashSet<Character> isPresent = new HashSet<>();

        for(int i =0; i < s.length(); i++){

            char c = s.charAt(i);

            if(!isPresent.contains(c)){

                while (!stack.isEmpty() && c < stack.peek() && last.get(stack.peek()) > i) {
                    isPresent.remove(stack.peek());
                    stack.pop();
                }
            }

            stack.push(c);
            isPresent.add(c);
        }

        StringBuilder str = new StringBuilder();

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
