/*
 * 
 * All Alphabets
Write a program that takes lowercase string str as input and checks if it contains all 26 alphabets at least once.
 Given a string str, return true if str contains all 26 alphabets, or false otherwise.

Input:
The first line contains a lowercase string str.

Output:
Return a boolean value true or false.

Constraints:
1 <= str.length <= 10^4
str consists of lowercase English letters.
Example 1
Input:

thequickbrownfoxjumpsoverthelazydog
Output

true
 */


package HeyCoach.SessionTest;

import java.util.HashSet;

public class AllAlphabets {

    public boolean allAlphabetsOrNot(String str) {
        HashSet<Character> seen = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            seen.add(str.charAt(i));
        }

        if(seen.size() == 26)
            return true;
        else
            return false;
    }
}
