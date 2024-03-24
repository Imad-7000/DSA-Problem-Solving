
/*
 * Given an infix expression, convert it to postfix experssion
 * 
 * input = "3+4*5+(2+3)/5"
 * output = "345*23+5/++"
 * 
 */

package Stacks;

import java.util.Stack;

public class InfixToPostFix {


    //Checks and returns priority of operator to shuffle stack
    public static int priority(char ch){
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '*')
            return 2;
        else
            return 0;
    }

    public static String infixToPostfix(String s){

        Stack<Character> operators = new Stack<>();
        String postFix = "";

        for(int i =0 ; i < s.length(); i++){

            //If is a number 0 - 9 jsut add to final string
            if(Character.isDigit(s.charAt(i)))
                postFix += s.charAt(i);

            // If high priority character or '(' , just push to stack
            else if(s.charAt(i) == '(' || s.charAt(i) == '*' || s.charAt(i) == '/')
                operators.push(s.charAt(i));
            //If ')' , pop until openeing bracket is found and add all to string
            else if(s.charAt(i) == ')'){
                while (operators.peek() != '(') {
                    postFix += operators.pop();
                }
                if(operators.peek() == '(')
                    operators.pop();
            }
            //If low priority operator,  compare and pop stack till a high priority operator exists
            // then push the operator to stack
            else {
                while(!operators.isEmpty() && priority(operators.peek()) > priority(s.charAt(i)))
                    {
                        postFix += operators.pop();
                    }
                operators.add(s.charAt(i));
            }
        }
        //Empty Stack and add to string
        while (!operators.isEmpty()) {
            postFix += operators.pop();
        }

        return postFix;
    }
}
