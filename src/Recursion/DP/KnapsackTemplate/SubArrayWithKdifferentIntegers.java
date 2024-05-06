/*
 * 
 * 
 * 
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
 * 
 */
package Recursion.DP.KnapsackTemplate;

import java.util.HashSet;

public class SubArrayWithKdifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        subArray(nums, k, new HashSet<>(), nums.length - 1);
        return count;
    }
    int count  = 0;
    public void subArray(int[] nums, int k, HashSet<Integer> seen, int i){
        if( i < 0 )
            return ;    
        seen.add(nums[i]);
        if(seen.size() > k)
            return;
        if(seen.size() == k)
            count++;
        subArray(nums, k, seen, i - 1);
        subArray(nums, k, new HashSet<>(), i - 1);
    }
}
