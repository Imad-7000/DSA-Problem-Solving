/*
 * 
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper("", n, 0, 0, list);
        return list;
    }

    public void helper(String s, int n, int open, int closed, List<String> list){
        if(closed == n){
            list.add(s);
            return;
        }

        if(n > open)
            helper("(", n, open + 1, closed, list);
        if(open > closed)
            helper(")", n, open, closed + 1, list);
    }
}
