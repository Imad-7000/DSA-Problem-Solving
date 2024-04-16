/*
 * 20 Valid parenthesis
 * 
 * https://leetcode.com/problems/valid-parentheses/description/
 * 
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 * 
 * 
 */


package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{
                if(!helper(stack, s.charAt(i)))
                    return false;
                }
            }
            if(!stack.isEmpty())
                return false;
            return true;
        }
    

    public boolean helper(Stack<Character> stack, Character character){
        if(stack.isEmpty())
            return false;
        Character c = (Character)stack.pop();
        if( character.equals(')') && c.equals('('))
            return true;
        if( character.equals('}') && c.equals('{'))
            return true;
        if( character.equals(']') && c.equals('['))
            return true;
        
        return false;
    }
}
