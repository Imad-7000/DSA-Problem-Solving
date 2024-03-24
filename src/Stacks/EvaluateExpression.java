/*
 * 
 * Given a string form of an equation , evaluate using BODMAS and return answer
 * 
 * Input = "3+4*5+(2+3)/5"
 * Output = 24
 * 
 * 
 * The code below considers the string contatins only single digit numbers
 */

package Stacks;

import java.util.Stack;

public class EvaluateExpression {

    //Helper to send operation
    public static int expression(int a, int b, char c){
        if(c == '+')
            return a + b;
        else if(c == '-')
            return b - a;
        else if( c == '*')
            return a*b;
        else 
            return b / a;
    }

    public static int evaluate(String str){
        
        //Get postfix expression of string
        str = InfixToPostFix.infixToPostfix(str);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < str.length(); i++)
            {
                //If char is a digit, push to stack after parsing
                if(Character.isDigit(str.charAt(i)))
                    stack.push(Integer.parseInt(String.valueOf(str.charAt(i))));

                //if is a operator, perform operation and push back to stack
                else{
                    int a = stack.pop();
                    int b = stack.pop();
                    int val = expression(a,b,str.charAt(i));

                    stack.push(val);
                }
            }
        //only 1 element remains in stack which is answer.
        return stack.peek();
    }
}
