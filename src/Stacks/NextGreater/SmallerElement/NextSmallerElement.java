/*
 * 
 * Given an array return teh next smaller element to each element
 */


package Stacks.NextGreater.SmallerElement;

import java.util.Stack;

public class NextSmallerElement {

    public int[] nextSmaller(int[] array){
        int[] answer = new int[array.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = array.length -1; i >= 0 ; i--){
            if(!stack.isEmpty())
                answer[i] = -1;
            else{
                while (!stack.isEmpty() && stack.peek() >= array[i] ) {
                    stack.pop();
                }
                if(stack.isEmpty())
                    answer[i] = -1;
                else
                    answer[i] = stack.peek();
                stack.push(array[i]);
            }
        }
        return answer;
    }
}
