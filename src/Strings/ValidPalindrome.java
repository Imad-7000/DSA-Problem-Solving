/*
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 *  letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
 * Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 * 
 * 
 */


package Strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i = 0; i< s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                str += Character.isLetter(s.charAt(i)) ? Character.toLowerCase(s.charAt(i)) : s.charAt(i);
            }
        }
        System.out.println(str);
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }
}
