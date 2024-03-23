/*
 * First Unique Number
Given a non-empty list of elements, return the sequentially first element which occurred only once in the array.

Input:
The first line contains N, N is the number of input elements. The second line contains N space-separated input integers.

Output:
Return the first Non-Repeating Element in the array. If there is no element with a frequency 1 print -1.

Constraints:
1 <= N <= 100000
0 <= A[i] <= 10^9
Example 1
Input:

4 
9 6 7 6 
Output:

9
Explanation:
In the given input, 9 and 7 have a frequency of 1 but since 9 came first so output is 9.

Example 2
Input:

5 
7 6 1 6 1 
Output

7
Explanation:
In the given input, only 7 has a frequency of 1 .
 */

package HeyCoach.SessionTest;

import java.util.HashMap;

public class SequentiallyFirstUnique {

    public static int firstUniqueInteger(int[] v) {
        //Write your code here 

        HashMap<Integer,Integer> seen = new HashMap<>();
        
        for(int i = 0; i < v.length; i++){
            if(!seen.containsKey(v[i]))
                seen.put(v[i], 1);
            else{
                seen.put(v[i], seen.get(v[i]) + 1);
            }
        }
        
        for(int i = 0; i < v.length; i++)
            if(seen.containsKey(v[i]) && seen.get(v[i]) == 1)
                return v[i];

        return -1;
       }
}
