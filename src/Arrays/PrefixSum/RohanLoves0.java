/*
 * ROHAN LOVES 0 (1)
Rohan loves 0, he has been assigned a task by his coach to check whether is it possible to find a subarray in the array nums,
 with sum 0 in it. Rohan thinks that this task is quite easy as he know the brute-force method, 
 but his coach has strictly instructed to think of a optimized approach for the above problem as brute force will not work this time.

Hint: Prefix Sum Prefix Sum[i] is defined as the sum of all the values of the array up to index i.

PrefixSum[0] = nums[0];

PrefixSum[1] = nums[0]+nums[1];

PrefixSum[i] = nums[0]+nums[1]+nums[2]+........nums[i].

Sample Input:

7

1 4 -2 -2 5 -4 3

Sample Output:

Yes

Constraints :

1<=nums.length()<=10^4;

-10^4<=nums[i]<=10^4;
 * 
 */

package Arrays.PrefixSum;

import java.util.HashSet;

public class RohanLoves0 {

    //The logic is as, if a prefix sum appears again, clearly the sum has become 0. hence confirming a zero to be found.
    //Runs in 0(n) and space O(n)
    public static boolean isZero(int[] arr, int N){
        int prefixSum = arr[0];
        HashSet<Integer> seen = new HashSet<>();
        seen.add(prefixSum);
        for(int i = 1; i < N; i++){
            prefixSum += arr[i];
            if(seen.contains(prefixSum))
                return true;
            seen.add(prefixSum);
        }
        return false;
    }

}
