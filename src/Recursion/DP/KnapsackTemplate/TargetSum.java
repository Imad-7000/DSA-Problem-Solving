/*
 *494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 *  
 * You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
 */

package Recursion.DP.KnapsackTemplate;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target){
       return helper(nums, nums.length - 1, target);
    }

    //There can only be 2 cases, where an element is positive or negative and adding and subtracting the element from target and checking if any case at the end
    //target becomes 0;
    public static int helper(int[] nums, int i, int target){
       if(i == -1){
            if(target == 0)
                return 1;
            return 0;
       }

       return helper(nums, i - 1, target + nums[i]) + helper(nums, i - 1, target - nums[i]);
    }
}
