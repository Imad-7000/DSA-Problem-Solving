/*
 * 
 * Given an input array, find the next greater element for every element in the array.
 * 
 * using Stack this can be achieved in O(n)
 */

package Stacks.NextGreater.SmallerElement;

import java.util.Stack;

public class NextGreaterElement {


    public static int[] nextGreater(int[] array){
        int[] answer = new int[array.length];
        Stack<Integer> stack = new Stack<>();


        //Calculating in reverse order 
        for(int i = array.length - 1; i >=0 ; i--){

            //If stack is empty just put answer as -1 and push to stack current value
            if(stack.isEmpty()){
                answer[i] = -1;
                stack.push(array[i]);
            }

            //if not empty, pop until a amx elemen is found, then push current to stack
            else{
                while( !stack.isEmpty() && stack.peek() <= array[i]){
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
