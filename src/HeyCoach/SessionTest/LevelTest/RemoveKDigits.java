/*
 * 
 * 
 * 
 * Given a non-negative integer represented as a string num and an integer k, 
 * remove k digits from the number so that the new number is the smallest possible.
 *  The remaining digits should maintain their original order in the string. Return the result as a string.

Input Format:

The first line contains the string num, representing the non-negative integer.
The second line contains the integer k.
Output Format:

Print the smallest possible integer as a string after removing k digits.
Sample Input 1:

1432219
3
Sample Output 1:

1219
Explanation:

Removing the digits 4, 3, and 2 from "1432219" leads to the new number "1219", which is the smallest possible result.

Sample Input 2:

10200
1
Sample Output 2:

200
Explanation:

Removing one digit (the leading 1) from "10200" results in "0200", and removing the leading zeroes gives "200" as the smallest possible result.

Constraints:
1<=k<= num.length<= 100000
num contains of only digits
 */

package HeyCoach.SessionTest.LevelTest;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < num.length()){
            int val = Character.getNumericValue(num.charAt(i));
            while(k > 0 && !stack.isEmpty() && stack.peek() > val){
                stack.pop();
                k--;
            }
            stack.push(val);
            i++;
            if(k == 0)
                break;
        }

        while(i < num.length()){
            stack.push(Character.getNumericValue(num.charAt(i)));
            i++;
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

       

        i = str.length() -1;

        while(i >= 0) {
            if(str.charAt(i) == '0')
                str.deleteCharAt(i);
            else
                break;
            i--;
        }
         if(str.length() == 0)
            return "0";

        return str.reverse().toString();
    }
    
}
