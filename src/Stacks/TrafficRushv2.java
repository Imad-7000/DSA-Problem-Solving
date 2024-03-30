package Stacks;

import java.util.Stack;

public class TrafficRushv2 {

    public static int solve(String s){
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(s.length() - 1));
        int collisions = 0;
        int j = s.length() - 2;

        while (j >= 0) {
            char cur = s.charAt(j);

            if(cur == 'S'){
                while (!stack.isEmpty() && stack.peek() == 'L') {
                    collisions +=1;
                    stack.pop();
                }
                stack.add(cur);
            }
            else if (cur == 'R'){
                if(stack.peek() == 'L'){
                    collisions += 2;
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == 'L') {
                        collisions += 1;
                        stack.pop();
                    }
                    stack.push('S');
                }
                else if(stack.peek() == 'S'){
                    collisions += 1;
                }
            }
            else if(cur == 'L'){
                stack.add('L');
            }
            j--;
        }
        return collisions;
    }

}
