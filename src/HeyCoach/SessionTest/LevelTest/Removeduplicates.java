/*
 * 
 * 
 * 
 * 
 * Dholu is very creative and wants to play with strings and he has a very good idea. You have given a string s,
 *  remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order

Input Format:
first line consists of a string
Output Format:
print the output string
Sample Input:
cbacdcbc

Sample Output:
abcd

Explanation: Since if we only collect unique letters, they come out to be 'c', 'b', 'a' and 'd' and when they are arranged lexicographically the output is abcd.

Constraints:
1<= s.length<= 10000
Note: Input consists of only lower case letters.
 */

package HeyCoach.SessionTest.LevelTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Removeduplicates {
    public String removeDuplicateLetters(String s) {
        //Write your code here; 
        HashSet<Character> hash = new HashSet<>();
  
        for(int i = 0; i < s.length(); i++){
            hash.add(s.charAt(i));
        }
        String str = "";
        Iterator<Character> itr = hash.iterator();
        while (itr.hasNext()) {
            str += itr.next();
        }
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        str = new String(ch);
        return str;
    }
}
