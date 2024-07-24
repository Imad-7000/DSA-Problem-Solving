/*
 * 
 * 
 * 
 * MAX COINS -I
Nitin is an explorer, and he has a map that consists of n houses along a coastline of a beach. 
Each house has a certain amount of money stashed. The only constraint stopping Nitin from getting 
each of them is that adjacent houses have security systems connected, and it will automatically 
contact the police if two adjacent houses were broken into on the same night. Given an integer 
array nums representing the amount of money in each house, return the maximum amount of money Nitin can rob tonight without alerting the police.

Example:
Input:

N = 4
nums = [1, 2, 3, 1]
Output:

4
Input:

N = 5
nums = [2, 7, 9, 3, 1]
Output:

12
Constraints:
1 <= nums.length <= 100

0 <= nums[i] <= 400
 */
package Recursion.DP;

import java.util.HashMap;
import java.util.Map;

public class MaxCoins1 {
    private Map<Integer, Integer> memo;

    public int maxCoins_I(int n, int[] arr) {
        memo = new HashMap<>();
        return rob(arr, 0);
    }

    private int rob(int[] arr, int currentIndex) {
        // Base case: If current index is out of bounds, return 0
        if (currentIndex >= arr.length) {
            return 0;
        }

        // Check if we have already solved this subproblem
        if (memo.containsKey(currentIndex)) {
            return memo.get(currentIndex);
        }

        // Option 1: Rob the current house and move to the house two steps ahead
        int robCurrent = arr[currentIndex] + rob(arr, currentIndex + 2);

        // Option 2: Skip the current house and move to the next house
        int skipCurrent = rob(arr, currentIndex + 1);

        // Calculate the maximum amount we can rob from this point
        int result = Math.max(robCurrent, skipCurrent);

        // Store the result in memo for future reference
        memo.put(currentIndex, result);

        return result;
    }
}
