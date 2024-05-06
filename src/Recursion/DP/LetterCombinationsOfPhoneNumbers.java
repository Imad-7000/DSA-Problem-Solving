/*
 * 
 * 17. Letter Combinations
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
package Recursion.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumbers {
    HashMap<Integer, char[]> hash;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        hash = new HashMap<>();
        hash.put(2, new char[]{'a','b','c'});
        hash.put(3, new char[]{'d','e','f'});
        hash.put(4, new char[]{'g','h','i'});
        hash.put(5, new char[]{'j','k','l'});
        hash.put(6, new char[]{'m','n','o'});
        hash.put(7, new char[]{'p','q','r','s'});
        hash.put(8, new char[]{'t','u','v'});
        hash.put(9, new char[]{'w','x','y','z'});
        List<String> str = new ArrayList<>();
        comb(str, digits, 0, "");
        return str;
    }

    public void comb(List<String> str, String digits, int i, String cur){
        if(i == digits.length()){
            str.add(cur);
            return;
        }
        char[] temp = hash.get(Character.getNumericValue(digits.charAt(i)));
        for(int j = 0 ; j < temp.length; j++){
            cur += temp[j];
            comb(str, digits, i + 1, cur);
            cur = cur.substring(0,cur.length() - 1);
        }
    }
}
