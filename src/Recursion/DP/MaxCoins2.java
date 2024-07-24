/*
 * 
 * 
 * 
 * 
 * Max coins -II
Nitin is an explorer, and he has a map that consists of n number of houses. 
All houses at this place are arranged in a circle. Each house has a certain amount of money stashed. 
The only constraint stopping Nitin from getting each of them is that adjacent houses have security systems connected, 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money Nitin can rob tonight without alerting the police.

Examples:
Input:

nums = [1, 2, 3, 1]
Output:

4
Input:

nums = [2, 7, 9, 3, 1]
Output:

11
Constraints:
1 <= nums.length <= 100

0 <= nums[i] <= 900
 * 
 * 
 * 
 */
package Recursion.DP;

public class MaxCoins2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Calculate the max money robbing from the second house to the last house
        int excludeFirst = robHelper(nums, 1, n - 1);
        // Calculate the max money robbing from the first house to the second last house
        int excludeLast = robHelper(nums, 0, n - 2);

        // Return the maximum of the two scenarios
        return Math.max(excludeFirst, excludeLast);
    }

    // Helper function to calculate the max money robbing in a linear arrangement
    private int robHelper(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start - 1], nums[i] + dp[i - start - 2]);
        }

        return dp[end - start];
    }
}
