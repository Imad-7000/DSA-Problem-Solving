/*
 * 560. SubArray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * 
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

INTUITION:
    we are using the concept of prefix sum, and a map to store the count on each prefix
    the intution is if map contains a value such that current sum - k is equal to that value,
    then we can assume that a subarray surely exists at that point.
 */
package Arrays.PrefixSum;

import java.util.*;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count  = 0;
        int sum = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();

        hash.put(0,1);

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hash.containsKey(sum - k))
                count += hash.get(sum - k);
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
