/*
 * 
 * 
 * Partition with minimum sum difference
Given an integer array nums, representing the number of chocolates in ith bag where 1<=i<=N and N is the length of Array nums ,
 Alice and Bob are best friends they want to share chocolates in such a way that minimises the absolute difference between the sum of two arrays.
  Return the minimum possible absolute difference.

For example the given array is [8, 6, 5] and we divide it in arrays [6,5] and [8] then the absolute difference of these arrays would be |8 - (6+5)| = 3.
     You have to seperate the array in such a way that the absolute difference between the array is minimised.

Example 1 :

Input:  nums = [3,9,7,3]

Output: 2
Example 2 :

Input: nums = [36,36]

Output: 0
Constraints:

1 <= n <= 15

nums.length == 2 * n

0 <= nums[i] <= 10^5
 */
package Recursion.DP;

import java.util.HashMap;
import java.util.Map;

public class MinSumPartition {
    public static int minDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Memoization map
        Map<String, Integer> memo = new HashMap<>();
        
        return minDifferenceHelper(arr, n, 0, 0, totalSum, memo);
    }

    private static int minDifferenceHelper(int[] arr, int n, int index, int currentSum, int totalSum, Map<String, Integer> memo) {
        if (index == n) {
            return Math.abs((totalSum - currentSum) - currentSum);
        }

        // Create a unique key for the current state
        String key = index + "-" + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Include the current element in the subset
        int includeInSubset = minDifferenceHelper(arr, n, index + 1, currentSum + arr[index], totalSum, memo);

        // Exclude the current element from the subset
        int excludeFromSubset = minDifferenceHelper(arr, n, index + 1, currentSum, totalSum, memo);

        // Find the minimum of both choices
        int result = Math.min(includeInSubset, excludeFromSubset);

        // Store the result in the memoization map
        memo.put(key, result);

        return result;
    }
}
