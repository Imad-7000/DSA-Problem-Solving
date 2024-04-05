
/*

KNAPSACK PROBLEM


 * 416 . https://leetcode.com/problems/partition-equal-subset-sum/description/
 * Given an integer array nums, return true if you can partition 
 * the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */

package Recursion.DP.KnapsackTemplate;

//The intuition is to check if array is even, if yes then pass half of array and find any subset that satisfies this sum, if found return true
public class PartitionEqualSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        sum = sum/2;
        int[][] memo = new int[nums.length ][sum + 1];
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++)
                memo[i][j] = -1;

        return partitionSumks(nums.length - 1, nums, sum, memo);
    }

    public static boolean partitionSumks(int n, int[] nums, int sum, int[][] memo){
        if(n <0 ||sum < 0)
            return false;

       
        if(memo[n][sum] != -1 )
        {
            if(memo[n][sum] == 1)
                return true;
            else
                return false;
        }
        if(sum == 0)
        {
            memo[n][sum] = 1;
            return true;
        }
        boolean ans = false;
        if(nums[n] > sum)
            ans = partitionSumks(n - 1, nums, sum, memo);
        else{
            ans = partitionSumks(n-1, nums, sum, memo) || partitionSumks(n - 1, nums, sum - nums[n], memo);
        }
        if(ans)
            memo[n][sum] = 1;
        else
            memo[n][sum] = 0;
        
        return ans;
    }
}
