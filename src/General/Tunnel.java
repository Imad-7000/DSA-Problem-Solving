/*
 * 
 * 
 * 
 * Tunnel
There is a tunnel which is under construction. Workers go inside in a sequence and come out in reverse sequence i.e.,
 person going in will come out last. You have been given two sequences, IN and OUT. If any worker does not obey the sequence 
 other workers will be trapped. Determine if all the workers came out safely.

Sample Input:

5

1 2 3 4 5

5 4 3 2 1

Sample Output:

1

Constraints:
size.sequence_in = n

1 <= n <= 1e5

1 <= sequence_in[i], sequence_out[i] <= 1e9

Note :-

All workers don’t go inside together
 */
package General;

import java.util.Stack;
import java.util.Vector;

public class Tunnel {
      boolean calculateTotalTrappedWorkers(Vector<Integer> in, Vector<Integer> out) {
       //Write your code here;
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < in.size(); i++) {
            stack.push(in.get(i));

            while (!stack.isEmpty() && stack.peek().equals(out.get(j))) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();


    }
}
