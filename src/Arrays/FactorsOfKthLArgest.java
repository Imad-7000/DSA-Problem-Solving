/**
 * FACTORS OF K TH LARGEST
You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, return the kth largest factor in this list or return -1 if n has less than k factors.

Input Format:

A single line containing two space seperated integers denoting the value of n and k respectively.

Output Format:

The kth largest factor of 'n'.

Example 1
Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd largest factor is 4.
Constraints
1<=k,n<=1000
 */

package Arrays;

import java.util.ArrayList;

public class FactorsOfKthLArgest {
    public int solve(int n, int k) {
        //Write your code here
       ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0)
                al.add(i);
        }
        if(al.size() >= k -1)
            return al.get(al.size() - k);
        else
          return -1;
    }
}
