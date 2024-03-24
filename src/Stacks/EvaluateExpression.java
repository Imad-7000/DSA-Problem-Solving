/*
 * 
 * Given a string form of an equation , evaluate using BODMAS and return answer
 * 
 * Input = "3+4*5+(2+3)/5"
 * Output = 24
 */

package Stacks;

import java.util.Stack;

public class EvaluateExpression {


    public static int expression(int a, int b, char c){
        if(c == '+')
            return a + b;
        else if(c == '-')
            return a - b;
        else if( c == '*')
            return a*b;
        else 
            return b / a;
    }

    public static int evaluate(String str){
        
        //Get postfix expression of string
        str = InfixToPostFix.infixToPostfix(str);
        System.out.println();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < str.length(); i++)
            {
                if(Character.isDigit(str.charAt(i)))
                    stack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
                else{
                    int a = stack.pop();
                    int b = stack.pop();
                    int val = expression(a,b,str.charAt(i));

                    stack.push(val);
                }
            }
        return stack.peek();
    }
}
